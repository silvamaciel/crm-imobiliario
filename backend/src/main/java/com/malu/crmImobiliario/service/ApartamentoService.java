package com.malu.crmImobiliario.service;

import com.malu.crmImobiliario.dto.ApartamentoDTO;
import com.malu.crmImobiliario.model.Apartamento;
import com.malu.crmImobiliario.model.Empreendimento;
import com.malu.crmImobiliario.repository.ApartamentoRepository;
import com.malu.crmImobiliario.repository.EmpreendimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApartamentoService {

     @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;

    public List<ApartamentoDTO> listarTodos() {
        return apartamentoRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public Optional<ApartamentoDTO> buscarPorId(UUID id) {
        return apartamentoRepository.findById(id).map(this::convertToDTO);
    }


    public ApartamentoDTO salvar(ApartamentoDTO apartamentoDTO) {
        Empreendimento empreendimento = empreendimentoRepository.findById(apartamentoDTO.empreendimentoId())
                .orElseThrow(() -> new RuntimeException("Empreendimento não encontrado"));

        Apartamento apartamento = Apartamento.builder()
                .numero(apartamentoDTO.numero())
                .area(apartamentoDTO.area())
                .preco(apartamentoDTO.preco())
                .matricula(apartamentoDTO.matricula())
                .fracaoIdeal(apartamentoDTO.fracaoIdeal())
                .bloco(apartamentoDTO.bloco())
                .andar(apartamentoDTO.andar())
                .quartos(apartamentoDTO.quartos())
                .vagas(apartamentoDTO.vagas())
                .empreendimento(empreendimento)
                .build();

        return convertToDTO(apartamentoRepository.save(apartamento));
    }

    public void deletar(UUID id) {
        apartamentoRepository.deleteById(id);
    }

     private ApartamentoDTO convertToDTO(Apartamento apartamento) {
        return new ApartamentoDTO(
                apartamento.getId(),
                apartamento.getNumero(),
                apartamento.getArea(),
                apartamento.getPreco(),
                apartamento.getMatricula(),
                apartamento.getFracaoIdeal(),
                apartamento.getBloco(),
                apartamento.getAndar(),
                apartamento.getQuartos(),
                apartamento.getVagas(),
                apartamento.getEmpreendimento().getId()
        );
    }
}