package com.malu.crmImobiliario.dto;

import lombok.*;
import java.util.UUID;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ContratoDTO {
    private UUID id;
    private Date data;
    private double valor;
    private UUID leadId;
    
    private UUID apartamentoId;
}