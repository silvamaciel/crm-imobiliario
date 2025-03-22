package com.malu.crmImobiliario.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "empreendimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empreendimento {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String localizacao;

    @ManyToOne
    private Empresa empresa;

    @OneToMany(mappedBy = "empreendimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apartamento> apartamentos;
}