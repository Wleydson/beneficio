package br.com.wleydson.beneficio.repository;

import br.com.wleydson.beneficio.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer> {

    @Query("""
        SELECT s FROM Solicitacao s JOIN FETCH s.solicitante JOIN FETCH s.dependentes
    """)
    List<Solicitacao> findAllJoinFetch();
}
