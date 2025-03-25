package com.malu.crmImobiliario.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApartamentoDTO {
    private UUID id;
    private int numero;
    private double area;
    private double preco;
    private UUID empreendimentoId;
}

