package com.malu.crmImobiliario.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malu.crmImobiliario.model.Empreendimento;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, UUID> {
    List<Empreendimento> findByEmpresaId(UUID empresaId);
}