package com.azold6.corejavastudies.assuntos.modelmapper.domain;

import com.azold6.corejavastudies.assuntos.modelmapper.serializers.GeneroAlunoSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_ALUNO")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double n1;
    private Double n2;
    private Double n3;
    private Date dataNasc;

    //JsonSerializer serve para personalizar os dados expostos na API, via serializador customizado.
    @JsonSerialize(using = GeneroAlunoSerializer.class)
    @Enumerated(value = EnumType.STRING)
    private GeneroAluno generoAluno;

    @ManyToMany
    @JoinTable(
            name = "TB_ALUNO_DISCIPLINA",
            joinColumns = @JoinColumn(name = "CD_ALUNO"),
            inverseJoinColumns = @JoinColumn(name = "CD_DISCIPLINA")
    )
    private List<Disciplina> disciplinas = new ArrayList<>();
}
