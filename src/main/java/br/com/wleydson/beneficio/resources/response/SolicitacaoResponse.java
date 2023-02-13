package br.com.wleydson.beneficio.resources.response;

import br.com.wleydson.beneficio.model.Pessoa;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class SolicitacaoResponse {

    private Integer id;
    private LocalDateTime dataCriacao;
    private Integer pontos;
    private Pessoa solicitante;

}
