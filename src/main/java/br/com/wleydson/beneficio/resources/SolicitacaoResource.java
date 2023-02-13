package br.com.wleydson.beneficio.resources;

import br.com.wleydson.beneficio.resources.assembler.SolicitacaoAssembler;
import br.com.wleydson.beneficio.resources.response.SolicitacaoResponse;
import br.com.wleydson.beneficio.service.solicitacao.SolicitacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/beneficio")
public class SolicitacaoResource {

    private final SolicitacaoService service;
    private final SolicitacaoAssembler assembler;

    @GetMapping
    public List<SolicitacaoResponse> get(){
        return assembler.toResponse(service.getPontosFamilias());
    }
}
