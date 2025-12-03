package br.com.clinica.clinica.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") // para converter o input date do HTML
    @Column(nullable = false)
    private Date dataConsulta;

    @Column(nullable = false, length = 60)
    private String paciente;

    @Column(length = 255)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;
}

