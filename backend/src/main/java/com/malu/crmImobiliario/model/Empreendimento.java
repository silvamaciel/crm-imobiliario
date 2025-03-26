package com.malu.crmImobiliario.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "empreendimento")
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

    private String matriculaImovel;
    private String areaDeLazer;
    private String registroDeIncorporacao;
    private LocalDate dtLancamento;
    private LocalDate previsaoDeEntrega;


    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;


    @OneToMany(mappedBy = "empreendimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apartamento> apartamentos;



}