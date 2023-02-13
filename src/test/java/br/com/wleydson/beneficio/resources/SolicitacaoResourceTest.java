package br.com.wleydson.beneficio.resources;

import br.com.wleydson.beneficio.resources.assembler.SolicitacaoAssembler;
import br.com.wleydson.beneficio.resources.extractor.PayloadExtractor;
import br.com.wleydson.beneficio.resources.response.SolicitacaoResponse;
import br.com.wleydson.beneficio.service.solicitacao.SolicitacaoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class, MockitoExtension.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SolicitacaoResourceTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper jsonMapper;

    private PayloadExtractor payloadExtractor;

    @BeforeAll
    public void iniciar() {
        payloadExtractor = new PayloadExtractor(jsonMapper);
    }

    @Test
    @Order(1)
    @DisplayName("Deve criar um resposta")
    public void createAnswer() throws Exception {
        mockMvc.perform(get("/beneficio"))
                .andDo(payloadExtractor)
                .andExpect(status().isOk())
                .andReturn();

        List<SolicitacaoResponse> response = payloadExtractor.asListOf(SolicitacaoResponse.class, false);
        assertEquals(4, response.size());
        assertEquals(8, response.get(0).getPontos());
        assertEquals("90553421069", response.get(0).getSolicitante().getCpf());

    }
}
