package com.malu.crmImobiliario.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
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

    @OneToMany(mappedBy = "empreendimento")
    private List<Apartamento> apartamentos;
}