package com.malu.crmImobiliario.service;

import com.malu.crmImobiliario.model.Apartamento;
import com.malu.crmImobiliario.repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    public List<Apartamento> listarTodos() {
        return apartamentoRepository.findAll();
    }

    public Optional<Apartamento> buscarPorId(UUID id) {
        return apartamentoRepository.findById(id);
    }

    public Apartamento salvar(Apartamento apartamento) {
        return apartamentoRepository.save(apartamento);
    }

    public void deletar(UUID id) {
        apartamentoRepository.deleteById(id);
    }
}