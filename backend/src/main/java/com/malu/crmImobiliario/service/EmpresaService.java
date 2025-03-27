package com.malu.crmImobiliario.service;

import com.malu.crmImobiliario.dto.EmpresaDTO;
import com.malu.crmImobiliario.model.Empresa;
import com.malu.crmImobiliario.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

        @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaDTO> listarTodas() {
        return empresaRepository.findAll()
                .stream()
                .map(emp -> new EmpresaDTO(emp.getId(), emp.getNome(), emp.getCnpj()))
                .collect(Collectors.toList());
    }

    public Optional<EmpresaDTO> buscarPorId(UUID id) {
        return empresaRepository.findById(id)
                .map(emp -> new EmpresaDTO(emp.getId(), emp.getNome(), emp.getCnpj()));
    }

    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deletar(UUID id) {
        empresaRepository.deleteById(id);
    }

}