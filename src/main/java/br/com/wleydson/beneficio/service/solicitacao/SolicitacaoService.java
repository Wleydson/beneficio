package br.com.wleydson.beneficio.service.solicitacao;

import br.com.wleydson.beneficio.model.Solicitacao;
import br.com.wleydson.beneficio.repository.SolicitacaoRepository;
import br.com.wleydson.beneficio.service.solicitacao.executor.ExecutorRegrasBeneficioInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitacaoService {

    private final SolicitacaoRepository repository;
    private final List<ExecutorRegrasBeneficioInterface> processadorBeneficio;

    public List<Solicitacao> getPontosFamilias(){
        List<Solicitacao> solicitacaos = repository.findAllJoinFetch();
        solicitacaos.forEach(this::executarRegraCasaPopular);
        return solicitacaos.stream().sorted(Comparator.comparing(Solicitacao::getTotalPontos).reversed()).collect(Collectors.toList());
    }

    private void executarRegraCasaPopular(Solicitacao solicitacao){
        int totalPontos = processadorBeneficio.stream().mapToInt(p -> p.executar(solicitacao)).sum();
        solicitacao.setTotalPontos(totalPontos);
    }
}
