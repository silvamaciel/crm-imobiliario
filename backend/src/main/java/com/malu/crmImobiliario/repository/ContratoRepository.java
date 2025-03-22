package com.malu.crmImobiliario.repository;

import com.malu.crmImobiliario.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ContratoRepository extends JpaRepository<Contrato, UUID> {
    List<Contrato> findByLeadId(UUID leadId);
}