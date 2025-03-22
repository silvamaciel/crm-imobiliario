package com.malu.crmImobiliario.model;

import com.malu.crmImobiliario.model.enums.PerfilUsuario;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private PerfilUsuario perfil;
}