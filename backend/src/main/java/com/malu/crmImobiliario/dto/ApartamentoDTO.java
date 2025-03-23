package com.malu.crmImobiliario.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class ApartamentoDTO {
    private UUID id;
    private int numero;
    private double area;
    private double preco;
    private UUID empreendimentoId;
}

