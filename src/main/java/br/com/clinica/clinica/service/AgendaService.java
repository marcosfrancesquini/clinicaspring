package br.com.clinica.clinica.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinica.clinica.dto.ConsultaMedicoDTO;
import br.com.clinica.clinica.dto.MedicoAgendaDTO;
import br.com.clinica.clinica.entity.Consulta;
import br.com.clinica.clinica.entity.Medico;
import br.com.clinica.clinica.repository.ConsultaRepository;
import br.com.clinica.clinica.repository.MedicoRepository;

@Service
public class AgendaService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<MedicoAgendaDTO> agendaCompleta() {
        List<Medico> medicos = medicoRepository.findAll();

        return medicos.stream().map(m -> {
            List<Consulta> consultas =
                consultaRepository.findByMedicoIdOrderByDataConsultaAsc(m.getId());

            List<ConsultaMedicoDTO> consultasDTO = consultas.stream()
                .map(c -> new ConsultaMedicoDTO(
                        c.getId(),
                        c.getDataConsulta(),
                        c.getPaciente().getNome(),
                        c.getObservacoes()
                ))
                .collect(Collectors.toList());

            return new MedicoAgendaDTO(
                    m.getId(),
                    m.getNome(),
                    m.getEspecialidade(),
                    consultasDTO
            );
        }).collect(Collectors.toList());
    }
}

