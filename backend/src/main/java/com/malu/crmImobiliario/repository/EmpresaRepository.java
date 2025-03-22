package com.malu.crmImobiliario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malu.crmImobiliario.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, UUID> {
}
