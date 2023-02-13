package br.com.wleydson.beneficio.service;

import br.com.wleydson.beneficio.model.Solicitacao;
import br.com.wleydson.beneficio.repository.SolicitacaoRepository;
import br.com.wleydson.beneficio.service.solicitacao.executor.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class, MockitoExtension.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class SolicitacaoServiceTest {

    @Autowired
    private SolicitacaoRepository repository;

    private List<Solicitacao> solicitacaos = new ArrayList<>();
    @BeforeAll
    public void iniciar() {
        solicitacaos = repository.findAllJoinFetch();
    }

    @Test
    @Order(1)
    @DisplayName("Deve checar a quantidade de solicitações")
    void testContarDados() {
        assertEquals(4, solicitacaos.size());
        assertEquals(1, solicitacaos.get(0).getSolicitante().getId());
        assertEquals(3, solicitacaos.get(0).getDependentes().size());
    }

    @Test
    @Order(2)
    @DisplayName("Deve executar regra renda total ate novecentos")
    void testExecutorRendaTotalAteNovecentos() {
        ExecutorRegrasBeneficioInterface executor = new ExecutorRendaTotalAteNovecentos();
        assertEquals(0, executor.executar(solicitacaos.get(0)));
        assertEquals(0, executor.executar(solicitacaos.get(1)));
        assertEquals(5, executor.executar(solicitacaos.get(2)));
        assertEquals(0, executor.executar(solicitacaos.get(3)));
    }

    @Test
    @Order(3)
    @DisplayName("Deve executar regra renda total mais novecentos ate mil quinhentos")
    void testExecutorRendaTotalMaisNovecentosAteMilQuinhentos() {
        ExecutorRegrasBeneficioInterface executor = new ExecutorRendaTotalMaisNovecentosAteMilQuinhentos();
        assertEquals(0, executor.executar(solicitacaos.get(0)));
        assertEquals(0, executor.executar(solicitacaos.get(1)));
        assertEquals(0, executor.executar(solicitacaos.get(2)));
        assertEquals(3, executor.executar(solicitacaos.get(3)));
    }

    @Test
    @Order(4)
    @DisplayName("Deve executar regra três ou mais dependentes")
    void testExecutorTresOuMaisDependentes() {
        ExecutorRegrasBeneficioInterface executor = new ExecutorTresOuMaisDependentes();
        assertEquals(0, executor.executar(solicitacaos.get(0)));
        assertEquals(3, executor.executar(solicitacaos.get(1)));
        assertEquals(3, executor.executar(solicitacaos.get(2)));
        assertEquals(0, executor.executar(solicitacaos.get(3)));
    }

    @Test
    @Order(5)
    @DisplayName("Deve executar regra um ou dois dependentes")
    void testExecutorUmOuDoisDependentes() {
        ExecutorRegrasBeneficioInterface executor = new ExecutorUmOuDoisDependentes();
        assertEquals(2, executor.executar(solicitacaos.get(0)));
        assertEquals(0, executor.executar(solicitacaos.get(1)));
        assertEquals(0, executor.executar(solicitacaos.get(2)));
        assertEquals(2, executor.executar(solicitacaos.get(3)));
    }
}
