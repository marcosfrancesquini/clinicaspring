package br.com.clinica.clinica.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer id;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(length = 15)
    private String telefone;

    @Column(length = 80)
    private String email;

    @ManyToMany
    @JoinTable(
        name = "paciente_exame", // nome da tabela intermediária
        joinColumns = @JoinColumn(name = "paciente_id"),   // FK para Paciente
        inverseJoinColumns = @JoinColumn(name = "exame_id") // FK para Exame
    )
    private List<Exame> exames = new ArrayList<>();
}

