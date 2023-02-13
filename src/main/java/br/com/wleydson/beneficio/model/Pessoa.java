package br.com.wleydson.beneficio.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(value = AccessLevel.NONE)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "cpf")
    @Setter(value = AccessLevel.NONE)
    private String cpf;

    @Column(name = "renda")
    private BigDecimal renda;

}
