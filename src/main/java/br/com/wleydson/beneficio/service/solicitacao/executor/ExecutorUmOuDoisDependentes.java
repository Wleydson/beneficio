package br.com.wleydson.beneficio.service.solicitacao.executor;

import br.com.wleydson.beneficio.model.Pessoa;
import br.com.wleydson.beneficio.model.Solicitacao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExecutorUmOuDoisDependentes implements ExecutorRegrasBeneficioInterface {

    private final int PONTOS =  2;
    private final int DEPENDENTES_MINIMO =  1;
    private final int DEPENDENTES_MAXIMO =  2;

    @Override
    public int executar(Solicitacao solicitacao) {
        List<Pessoa> familia = solicitacao.getFamilia();
        int dependentes = Math.toIntExact(familia.stream().filter(p -> p.getIdade() < 18).count());
        if (dependentes == DEPENDENTES_MINIMO || dependentes == DEPENDENTES_MAXIMO){
            return PONTOS;
        }
        return 0;
    }

}
