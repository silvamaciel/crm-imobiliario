package com.malu.crmImobiliario.controller;

import com.malu.crmImobiliario.dto.UsuarioDTO;
import com.malu.crmImobiliario.model.Usuario;
import com.malu.crmImobiliario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    // Buscar usuário por email ou CPF
    @GetMapping("/email/{email}")
public ResponseEntity<UsuarioDTO> buscarPorEmail(@PathVariable String email) {
    return usuarioService.buscarPorEmail(email)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
}

// Buscar usuário pelo CPF
@GetMapping("/cpf/{cpf}")
public ResponseEntity<UsuarioDTO> buscarPorCpf(@PathVariable String cpf) {
    return usuarioService.buscarPorCpf(cpf)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
}

    // Criar usuário
    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody Usuario usuario) {
        UsuarioDTO novoUsuario = usuarioService.salvar(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    // Deletar usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable UUID id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}