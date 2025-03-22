package com.malu.crmImobiliario.controller;

import com.malu.crmImobiliario.dto.UsuarioDTO;
import com.malu.crmImobiliario.model.Empresa;
import com.malu.crmImobiliario.model.Usuario;
import com.malu.crmImobiliario.service.UsuarioService;
import com.malu.crmImobiliario.repository.EmpresaRepository;
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

    @Autowired
    private EmpresaRepository empresaRepository;  // Repositório da Empresa para buscar a empresa pelo ID

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable UUID id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        // Verifica se o ID da empresa é nulo
        if (usuarioDTO.getEmpresaId() == null) {
            return ResponseEntity.badRequest().build(); // ou um erro personalizado
        }

        // Busca a empresa pelo ID
        Empresa empresa = empresaRepository.findById(usuarioDTO.getEmpresaId())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        // Criação da entidade Usuario a partir do DTO
        Usuario usuario = Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .perfil(usuarioDTO.getPerfil())
                .empresa(empresa)  // Associa a empresa ao usuário
                .build();

        // Salva o usuário no banco de dados
        Usuario savedUsuario = usuarioService.salvar(usuario);

        return ResponseEntity.ok(savedUsuario); // Retorna o usuário salvo
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}