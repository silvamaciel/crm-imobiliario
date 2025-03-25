package com.malu.crmImobiliario.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeadDTO {
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String origem;
    private UUID usuarioId;
    private UUID empresaId;
}
