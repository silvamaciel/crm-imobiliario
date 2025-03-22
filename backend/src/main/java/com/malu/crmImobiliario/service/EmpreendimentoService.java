package com.malu.crmImobiliario.service;

import com.malu.crmImobiliario.model.Empreendimento;
import com.malu.crmImobiliario.repository.EmpreendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpreendimentoService {

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;

    public List<Empreendimento> listarTodos() {
        return empreendimentoRepository.findAll();
    }

    public Optional<Empreendimento> buscarPorId(UUID id) {
        return empreendimentoRepository.findById(id);
    }

    public Empreendimento salvar(Empreendimento empreendimento) {
        return empreendimentoRepository.save(empreendimento);
    }

    public void deletar(UUID id) {
        empreendimentoRepository.deleteById(id);
    }
}
