package com.malu.crmImobiliario.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;



@Entity
@Table(name = "apartamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apartamento {

    @Id
    @GeneratedValue
    private UUID id;

    private Integer numero;
    private Float area;
    private Float preco;

    @Column(columnDefinition = "jsonb")
    private String informacoesAdicionais;

    @ManyToOne
    @JoinColumn(name = "empreendimento_id", nullable = false)
    private Empreendimento empreendimento;
}