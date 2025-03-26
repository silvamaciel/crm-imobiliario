package com.malu.crmImobiliario.controller;

import com.malu.crmImobiliario.dto.EmpreendimentoDTO;
import com.malu.crmImobiliario.model.Empreendimento;
import com.malu.crmImobiliario.service.EmpreendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/empreendimentos")
public class EmpreendimentoController {

    @Autowired
    private EmpreendimentoService empreendimentoService;

    @GetMapping
    public List<EmpreendimentoDTO> listarTodos() {
        return empreendimentoService.listarTodos().stream()
                .map(empreendimento -> new EmpreendimentoDTO(
                        empreendimento.getId(),
                        empreendimento.getNome(),
                        empreendimento.getLocalizacao(),
                        empreendimento.getMatriculaImovel(),
                        empreendimento.getAreaDeLazer(),
                        empreendimento.getRegistroDeIncorporacao(),
                        empreendimento.getDtLancamento(),
                        empreendimento.getPrevisaoDeEntrega(),
                        empreendimento.getEmpresa().getId()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpreendimentoDTO> buscarPorId(@PathVariable UUID id) {
        return empreendimentoService.buscarPorId(id)
                .map(empreendimento -> ResponseEntity.ok(new EmpreendimentoDTO(
                        empreendimento.getId(),
                        empreendimento.getNome(),
                        empreendimento.getLocalizacao(),
                        empreendimento.getMatriculaImovel(),
                        empreendimento.getAreaDeLazer(),
                        empreendimento.getRegistroDeIncorporacao(),
                        empreendimento.getDtLancamento(),
                        empreendimento.getPrevisaoDeEntrega(),
                        empreendimento.getEmpresa().getId()
                )))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EmpreendimentoDTO salvar(@RequestBody EmpreendimentoDTO empreendimentoDTO) {
        Empreendimento empreendimento = empreendimentoService.salvar(empreendimentoDTO);
        return new EmpreendimentoDTO(
                empreendimento.getId(),
                empreendimento.getNome(),
                empreendimento.getLocalizacao(),
                empreendimento.getMatriculaImovel(),
                empreendimento.getAreaDeLazer(),
                empreendimento.getRegistroDeIncorporacao(),
                empreendimento.getDtLancamento(),
                empreendimento.getPrevisaoDeEntrega(),
                empreendimento.getEmpresa().getId()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        empreendimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}