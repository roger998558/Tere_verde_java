package com.praticando.tere_verde.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticando.tere_verde.config.JwtServise;
import com.praticando.tere_verde.model.Usuario;
import com.praticando.tere_verde.repositorio.UsuarioRepositorio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping ("/Autenticar")
public class AulthController {
    @Autowired  
    private  UsuarioRepositorio repositorio;


    @Autowired 
    private PasswordEncoder password; 

    @Autowired 
    private JwtServise jwt;


        @GetMapping
        public List<Usuario>  listarUsuario () {
            return repositorio.findAll();
        }
        


    @PostMapping("/registrar")
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
       usuario.setSenha(password.encode(usuario.getSenha()));
        return repositorio.save(usuario);
    }

    @PostMapping("/login")
    public String loginUsuario(@RequestBody Usuario dadosLogin) {
    Usuario usuarioBanco = repositorio.findByEmail(dadosLogin.getEmail()).orElse(null);
     
    if (usuarioBanco == null) {
        
        return  "Usuário não encontrado";
    }

    boolean senhaCorreta = password.matches(dadosLogin.getSenha() , usuarioBanco.getSenha());

    if (!senhaCorreta) {

        return "Senha incorreta";
    }

    return jwt.gerarToken(usuarioBanco);
    }
    
    

}
