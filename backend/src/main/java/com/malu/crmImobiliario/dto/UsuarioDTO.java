package com.malu.crmImobiliario.dto;

import com.malu.crmImobiliario.model.enums.PerfilUsuario;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private PerfilUsuario perfil;
    private UUID empresaId; 
}
