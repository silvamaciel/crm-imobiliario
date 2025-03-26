package com.malu.crmImobiliario.service;

import com.malu.crmImobiliario.dto.EmpreendimentoDTO;
import com.malu.crmImobiliario.model.Empreendimento;
import com.malu.crmImobiliario.model.Empresa;
import com.malu.crmImobiliario.repository.EmpreendimentoRepository;
import com.malu.crmImobiliario.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpreendimentoService {

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empreendimento> listarTodos() {
        return empreendimentoRepository.findAll();
    }

    public Optional<Empreendimento> buscarPorId(UUID id) {
        return empreendimentoRepository.findById(id);
    }

    public Empreendimento salvar(EmpreendimentoDTO empreendimentoDTO) {
        Empresa empresa = empresaRepository.findById(empreendimentoDTO.getEmpresaId())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
    
        Empreendimento empreendimento = new Empreendimento();
        empreendimento.setNome(empreendimentoDTO.getNome());
        empreendimento.setLocalizacao(empreendimentoDTO.getLocalizacao());
        empreendimento.setMatriculaImovel(empreendimentoDTO.getMatriculaImovel());
        empreendimento.setAreaDeLazer(empreendimentoDTO.getAreaDeLazer());
        empreendimento.setRegistroDeIncorporacao(empreendimentoDTO.getRegistroDeIncorporacao());
        empreendimento.setDtLancamento(empreendimentoDTO.getDtLancamento());
        empreendimento.setPrevisaoDeEntrega(empreendimentoDTO.getPrevisaoDeEntrega());
        empreendimento.setEmpresa(empresa); 
    
        return empreendimentoRepository.save(empreendimento);
    }

    public void deletar(UUID id) {
        empreendimentoRepository.deleteById(id);
    }
}
