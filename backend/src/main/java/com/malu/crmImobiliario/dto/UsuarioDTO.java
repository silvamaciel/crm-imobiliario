package com.malu.crmImobiliario.dto;

import com.malu.crmImobiliario.model.enums.PerfilUsuario;
import java.util.UUID;

public record UsuarioDTO(
    UUID id,
    String nome,
    String email,
    PerfilUsuario perfil,
    UUID empresaId
) {}