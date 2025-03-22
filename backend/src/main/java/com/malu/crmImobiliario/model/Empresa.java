package com.malu.crmImobiliario.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import jakarta.persistence.CascadeType;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empresa {
    @Id
    @GeneratedValue

    private UUID id;
    private String nome;
    private String cnpj;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Usuario> usuarios;

@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Lead> leads;

@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Empreendimento> empreendimentos;


}
