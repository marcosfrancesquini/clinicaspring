package br.com.clinica.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clinica.clinica.entity.Medico;
import br.com.clinica.clinica.service.MedicoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/medicos") //medicos
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    //Método para abriri o formulário de criação de medicos
    @GetMapping("/criar") // /medicos/criar/ que ta no href da html
    public String criarForme(Model model) {
        model.addAttribute("medico", new Medico()); //cria novo objeto vazio!!!
        return "medico/formularioMedico"; //cria e manda pro formulario de medico "${medico}"
    }
    
    @PostMapping("/salvar") //isso sao rotas!
    public String salvar(@ModelAttribute Medico medico) {
        medicoService.save(medico);
        return "redirect:/medicos/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Medico> medicos = medicoService.findAll();
        model.addAttribute("medicos", medicos);
        return "medico/listaMedico";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        medicoService.deleteById(id);
        return "redirect:/medicos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Medico medico = medicoService.findById(id);
        model.addAttribute("medico", medico);
        return "medico/formularioMedico";
    }
    
    
}
