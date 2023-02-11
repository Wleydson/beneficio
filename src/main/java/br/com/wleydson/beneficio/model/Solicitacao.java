package br.com.wleydson.beneficio.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "solicitacao")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(value = AccessLevel.NONE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "solicitante")
    private Pessoa solicitante;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

}
