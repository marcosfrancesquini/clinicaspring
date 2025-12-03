package br.com.clinica.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clinica.clinica.entity.Usuario;
import br.com.clinica.clinica.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControler {

    @Autowired
    private UsuarioService usuarioService;

      //Método para abriri o formulário de criação de 
    @GetMapping("/criar") // //criar/ que ta no href da html
    public String criarForm(Model model) {
        model.addAttribute("usuario", new Usuario()); //cria novo objeto vazio!!!
        return "usuario/formularioUsuario"; //cria e manda pro formulario de "
    }
    
    @PostMapping("/salvar") //isso sao rotas!
    public String salvar(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "/login";
    }

    
}
