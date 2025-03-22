package com.malu.crmImobiliario.service;

import com.malu.crmImobiliario.model.Empresa;
import com.malu.crmImobiliario.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> buscarPorId(UUID id) {
        return empresaRepository.findById(id);
    }

    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deletar(UUID id) {
        empresaRepository.deleteById(id);
    }
}