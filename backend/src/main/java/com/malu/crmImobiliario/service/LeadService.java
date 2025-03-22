package com.malu.crmImobiliario.service;

import com.malu.crmImobiliario.model.Lead;
import com.malu.crmImobiliario.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public List<Lead> listarTodos() {
        return leadRepository.findAll();
    }

    public Optional<Lead> buscarPorId(UUID id) {
        return leadRepository.findById(id);
    }

    public Lead salvar(Lead lead) {
        return leadRepository.save(lead);
    }

    public void deletar(UUID id) {
        leadRepository.deleteById(id);
    }
}
