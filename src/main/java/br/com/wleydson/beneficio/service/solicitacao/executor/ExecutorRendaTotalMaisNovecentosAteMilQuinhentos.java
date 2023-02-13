package br.com.wleydson.beneficio.service.solicitacao.executor;

import br.com.wleydson.beneficio.model.Pessoa;
import br.com.wleydson.beneficio.model.Solicitacao;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ExecutorRendaTotalMaisNovecentosAteMilQuinhentos implements ExecutorRegrasBeneficioInterface {

    private final int PONTOS =  3;
    private final BigDecimal RENDA_TOTAL_MINIMA =  BigDecimal.valueOf(900L);
    private final BigDecimal RENDA_TOTAL_MAXIMA =  BigDecimal.valueOf(1500L);

    @Override
    public int executar(Solicitacao solicitacao) {
        List<Pessoa> familia = solicitacao.getFamilia();
        BigDecimal rendaTotal = familia.stream().map(Pessoa::getRenda).reduce(BigDecimal.ZERO, BigDecimal::add);
        if(RENDA_TOTAL_MINIMA.compareTo(rendaTotal) < 0 && RENDA_TOTAL_MAXIMA.compareTo(rendaTotal) >= 0){
            return PONTOS;
        }
        return 0;
    }

}
