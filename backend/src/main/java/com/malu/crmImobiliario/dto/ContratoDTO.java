package com.malu.crmImobiliario.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
import java.util.Date;

@Getter
@Setter
public class ContratoDTO {
    private UUID id;
    private Date data;
    private double valor;
    private UUID leadId;
    private UUID apartamentoId;
}