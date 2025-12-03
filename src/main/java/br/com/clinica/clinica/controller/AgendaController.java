package br.com.clinica.clinica.controller;

import br.com.clinica.clinica.dto.MedicoAgendaDTO;
import br.com.clinica.clinica.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    // Exibir a agenda completa em página HTML
    @GetMapping("/listar")
    public String listarAgenda(Model model) {
        List<MedicoAgendaDTO> agenda = agendaService.agendaCompleta();
        model.addAttribute("agenda", agenda);
        return "agenda/agendaCompleta"; // templates/agenda/agendaCompleta.html
    }
}
