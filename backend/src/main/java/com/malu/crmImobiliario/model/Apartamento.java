package com.malu.crmImobiliario.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apartamento {

    @Id
    @GeneratedValue
    private UUID id;

    private int numero;

    private float area;

    private float preco;

    @ManyToOne
    private Empreendimento empreendimento;
}