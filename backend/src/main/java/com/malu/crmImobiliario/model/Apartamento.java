package com.malu.crmImobiliario.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;



@Entity
@Table(name = "apartamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String numero;
    private Double area;
    private Double preco;
    private String matricula;
    private String fracaoIdeal;
    private String bloco;
    private Integer andar;
    private Integer quartos;
    private Integer vagas;

    @ManyToOne
    @JoinColumn(name = "empreendimento_id", nullable = false)
    private Empreendimento empreendimento;
}