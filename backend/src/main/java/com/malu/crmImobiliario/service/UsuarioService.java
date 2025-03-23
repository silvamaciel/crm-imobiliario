package com.malu.crmImobiliario.service;


import com.malu.crmImobiliario.dto.UsuarioDTO;
import com.malu.crmImobiliario.model.Usuario;
import com.malu.crmImobiliario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public Optional<UsuarioDTO> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).map(this::toDTO);
    }
    
    public Optional<UsuarioDTO> buscarPorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).map(this::toDTO);
    }

    public UsuarioDTO salvar(Usuario usuario) {
        Usuario savedUser = usuarioRepository.save(usuario);
        return toDTO(savedUser);
    }

    public void deletar(UUID id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getPerfil(),
            usuario.getEmpresa().getId()
        );
    }
}
