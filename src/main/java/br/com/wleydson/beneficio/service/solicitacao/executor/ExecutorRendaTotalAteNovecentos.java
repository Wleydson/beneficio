package br.com.wleydson.beneficio.service.solicitacao.executor;

import br.com.wleydson.beneficio.model.Pessoa;
import br.com.wleydson.beneficio.model.Solicitacao;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ExecutorRendaTotalAteNovecentos implements ExecutorRegrasBeneficioInterface {

    private final int PONTOS =  5;
    private final BigDecimal RENDA_TOTAL =  BigDecimal.valueOf(900L);

    @Override
    public int executar(Solicitacao solicitacao) {
        List<Pessoa> familia = solicitacao.getFamilia();
        BigDecimal rendaTotal = familia.stream().map(Pessoa::getRenda).reduce(BigDecimal.ZERO, BigDecimal::add);
        if(RENDA_TOTAL.compareTo(rendaTotal) >= 0){
            return PONTOS;
        }

        return 0;
    }

}
