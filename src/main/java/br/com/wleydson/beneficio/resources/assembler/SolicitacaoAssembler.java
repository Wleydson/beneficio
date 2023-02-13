package br.com.wleydson.beneficio.resources.assembler;

import br.com.wleydson.beneficio.model.Solicitacao;
import br.com.wleydson.beneficio.resources.response.SolicitacaoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SolicitacaoAssembler {

    public List<SolicitacaoResponse> toResponse(List<Solicitacao> entities){
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public SolicitacaoResponse toResponse(Solicitacao entity) {
        if(Objects.isNull(entity)){
            return null;
        }

        return SolicitacaoResponse.builder()
                .id(entity.getId())
                .dataCriacao(entity.getDataCriacao())
                .pontos(entity.getTotalPontos())
                .solicitante(entity.getSolicitante())
                .build();
    }
}
