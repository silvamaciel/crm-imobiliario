package com.malu.crmImobiliario.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contrato {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate data;

    private float valor;

    @ManyToOne
    private Lead lead;

    @OneToOne
    private Apartamento apartamento;
}
