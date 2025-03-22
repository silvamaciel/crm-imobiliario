package com.malu.crmImobiliario.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malu.crmImobiliario.model.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, UUID> {
    List<Apartamento> findByEmpreendimentoId(UUID empreendimentoId);
}
