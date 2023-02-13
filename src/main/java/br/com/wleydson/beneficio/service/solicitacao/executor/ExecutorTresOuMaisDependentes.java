package br.com.wleydson.beneficio.service.solicitacao.executor;

import br.com.wleydson.beneficio.model.Pessoa;
import br.com.wleydson.beneficio.model.Solicitacao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExecutorTresOuMaisDependentes implements ExecutorRegrasBeneficioInterface {

    private final int PONTOS =  3;
    private final int DEPENDENTES_MINIMO =  3;

    @Override
    public int executar(Solicitacao solicitacao) {
        List<Pessoa> familia = solicitacao.getFamilia();
        int dependentes = Math.toIntExact(familia.stream().filter(p -> p.getIdade() < 18).count());
        if (dependentes >= DEPENDENTES_MINIMO){
            return PONTOS;
        }
        return 0;
    }

}
