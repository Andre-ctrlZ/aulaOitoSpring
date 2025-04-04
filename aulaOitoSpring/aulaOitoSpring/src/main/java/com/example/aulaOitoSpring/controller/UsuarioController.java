package com.example.aulaOitoSpring.controller;

import com.example.aulaOitoSpring.model.Usuario;
import com.example.aulaOitoSpring.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> ListarTodos(){
        return usuarioService.ListarUsuarios();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", usuarioService.mensagem(usuario)));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Usuario usuario){
        usuarioService.atualizar(usuario);
        return ResponseEntity.ok().body(Map.of("Mensagem", usuarioService.mensagemAtualizar(usuario)));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, Object>>excluir(@PathVariable String email){
        usuarioService.excluir(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(Map.of("Mensagem", "Usuário excluido com sucesso!"));
    }
}