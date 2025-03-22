package com.malu.crmImobiliario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malu.crmImobiliario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByEmail(String email);
}
