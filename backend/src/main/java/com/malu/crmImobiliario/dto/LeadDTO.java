package com.malu.crmImobiliario.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class LeadDTO {
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String origem;
    private UUID usuarioId;
    private UUID empresaId;
}
