package com.malu.crmImobiliario.service;

import com.malu.crmImobiliario.model.Contrato;
import com.malu.crmImobiliario.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> listarTodos() {
        return contratoRepository.findAll();
    }

    public Optional<Contrato> buscarPorId(UUID id) {
        return contratoRepository.findById(id);
    }

    public Contrato salvar(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public void deletar(UUID id) {
        contratoRepository.deleteById(id);
    }
}
