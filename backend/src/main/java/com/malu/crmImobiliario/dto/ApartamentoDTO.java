package com.malu.crmImobiliario.dto;

import java.util.UUID;

public record ApartamentoDTO(
        UUID id,
        String numero,
        Double area,
        Double preco,
        String matricula,
        String fracaoIdeal,
        String bloco,
        Integer andar,
        Integer quartos,
        Integer vagas,
        UUID empreendimentoId
) {}
