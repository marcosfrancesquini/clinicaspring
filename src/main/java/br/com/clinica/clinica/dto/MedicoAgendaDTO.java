package br.com.clinica.clinica.dto;

import java.util.List;

public class MedicoAgendaDTO {
    private Integer idMedico;
    private String nomeMedico;
    private String especialidade;
    private List<ConsultaMedicoDTO> consultas;

    public MedicoAgendaDTO() {}

    public MedicoAgendaDTO(Integer idMedico, String nomeMedico, String especialidade, List<ConsultaMedicoDTO> consultas) {
        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.consultas = consultas;
    }

    public Integer getIdMedico() { return idMedico; }
    public void setIdMedico(Integer idMedico) { this.idMedico = idMedico; }

    public String getNomeMedico() { return nomeMedico; }
    public void setNomeMedico(String nomeMedico) { this.nomeMedico = nomeMedico; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public List<ConsultaMedicoDTO> getConsultas() { return consultas; }
    public void setConsultas(List<ConsultaMedicoDTO> consultas) { this.consultas = consultas; }
}
