package com.malu.crmImobiliario.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

import com.malu.crmImobiliario.model.enums.UserPerfil;

@Entity
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

    @Column(unique = true)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private UserPerfil perfil;

    @ManyToOne
    private Empresa empresa;
}