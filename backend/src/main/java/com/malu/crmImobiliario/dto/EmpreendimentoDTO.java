package com.malu.crmImobiliario.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class EmpreendimentoDTO {
    private UUID id;
    private String nome;
    private String localizacao;
    private UUID empresaId;
}