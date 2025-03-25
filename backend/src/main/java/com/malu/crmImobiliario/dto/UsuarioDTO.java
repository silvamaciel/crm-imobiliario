package com.malu.crmImobiliario.dto;

import com.malu.crmImobiliario.model.enums.PerfilUsuario;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private UUID id;
    private String nome;
    private String email;
    private PerfilUsuario perfil;
    private UUID empresaId;
}