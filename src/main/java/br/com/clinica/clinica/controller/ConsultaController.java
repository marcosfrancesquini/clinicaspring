package br.com.clinica.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clinica.clinica.entity.Consulta;
import br.com.clinica.clinica.service.ConsultaService;
import br.com.clinica.clinica.service.MedicoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/consulta") // consulta
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private MedicoService medicoService;

    //Método para abrir o formulário de criação de consultas
    @GetMapping("/criar") // /consulta/criar
    public String criarForm(Model model) {
        model.addAttribute("consulta", new Consulta()); // objeto vazio
        model.addAttribute("medicos", medicoService.findAll()); // lista para o <select>
        return "consulta/formularioConsulta";
    }

    //Salvar consulta
    @PostMapping("/salvar") // rota para salvar
    public String salvar(@ModelAttribute Consulta consulta) {
        consultaService.save(consulta);
        return "redirect:/consulta/listar";
    }

    //Listar consultas
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Consulta> consultas = consultaService.findAll();
        model.addAttribute("consultas", consultas);
        return "consulta/listaConsulta";
    }

    //Excluir consulta
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        consultaService.deleteById(id);
        return "redirect:/consulta/listar";
    }

    //Editar consulta
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Consulta consulta = consultaService.findById(id);
        model.addAttribute("consulta", consulta);
        model.addAttribute("medicos", medicoService.findAll()); // repassa a lista no modo edição
        return "consulta/formularioConsulta";
    }
}
