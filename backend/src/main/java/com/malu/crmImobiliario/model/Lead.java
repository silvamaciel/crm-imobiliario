package com.malu.crmImobiliario.model;

import com.malu.crmImobiliario.model.enums.LeadStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lead {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;

    private String email;

    private String telefone;

    private String origem;

    @Column(length = 500)
    private String informacoesAdicionais;

    @Column(length = 500)
    private String endereco;


    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    private LocalDateTime createdAt;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Empreendimento empreendimento;

    @ManyToOne
    private Apartamento apartamento;
}