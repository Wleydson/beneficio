package br.com.wleydson.beneficio.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "solicitacao")
public class Solicitacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(value = AccessLevel.NONE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "solicitante")
    private Pessoa solicitante;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "solicitacao", fetch = FetchType.LAZY)
    private List<Dependentes> dependentes = new ArrayList<>();

    @Transient
    private int totalPontos;

    public List<Pessoa> getFamilia() {
        List<Pessoa> familia = this.dependentes.stream().map(Dependentes::getPessoa).collect(Collectors.toList());
        familia.add(this.solicitante);
        return familia;
    }

}
