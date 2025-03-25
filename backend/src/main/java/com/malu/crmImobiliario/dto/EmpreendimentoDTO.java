package com.malu.crmImobiliario.dto;

import lombok.*;
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
    private UUID empresaId;
}