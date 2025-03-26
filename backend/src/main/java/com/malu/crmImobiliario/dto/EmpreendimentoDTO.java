package com.malu.crmImobiliario.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpreendimentoDTO {
    private UUID id;
private String nome;
    private String localizacao;
    private String matriculaImovel;
    private String areaDeLazer;
    private String registroDeIncorporacao;
    private LocalDate dtLancamento;
    private LocalDate previsaoDeEntrega;
    private UUID empresaId;
}