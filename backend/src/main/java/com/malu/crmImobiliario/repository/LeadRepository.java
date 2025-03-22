package com.malu.crmImobiliario.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malu.crmImobiliario.model.Lead;

public interface LeadRepository extends JpaRepository<Lead, UUID> {
    List<Lead> findByEmpresaId(UUID empresaId);
}
