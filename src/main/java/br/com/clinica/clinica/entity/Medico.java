package br.com.clinica.clinica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")   // <-- garante que bate com o banco
    private Integer id;

    @Column(nullable = false, length = 60)
    private String nome;  // compatível com *{nome}

    @Column(nullable = false, length = 60)
    private String especialidade; // compatível com *{especialidade}
}
