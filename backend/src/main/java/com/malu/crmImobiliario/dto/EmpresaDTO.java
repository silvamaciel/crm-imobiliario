package com.malu.crmImobiliario.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaDTO {
    private UUID id;
    private String nome;
    private String cnpj;
}
