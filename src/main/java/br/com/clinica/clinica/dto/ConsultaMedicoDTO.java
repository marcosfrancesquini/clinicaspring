package br.com.clinica.clinica.dto;

import java.util.Date;

public class ConsultaMedicoDTO {
    private Integer id;
    private Date dataConsulta;
    private String paciente;
    private String observacoes;

    public ConsultaMedicoDTO() {}

    public ConsultaMedicoDTO(Integer id, Date dataConsulta, String paciente, String observacoes) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.paciente = paciente;
        this.observacoes = observacoes;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Date getDataConsulta() { return dataConsulta; }
    public void setDataConsulta(Date dataConsulta) { this.dataConsulta = dataConsulta; }

    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
