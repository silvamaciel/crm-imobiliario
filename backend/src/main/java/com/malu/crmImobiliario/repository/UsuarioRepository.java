package com.malu.crmImobiliario.repository;

import com.malu.crmImobiliario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByEmail(String email); // Buscar usuário pelo e-mail

    Optional<Usuario> findByCpf(String cpf); // Buscar usuário pelo CPF

}