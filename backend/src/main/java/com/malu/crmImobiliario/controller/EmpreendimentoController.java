package com.malu.crmImobiliario.controller;

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
    public List<Empreendimento> listarTodos() {
        return empreendimentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empreendimento> buscarPorId(@PathVariable UUID id) {
        return empreendimentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empreendimento salvar(@RequestBody Empreendimento empreendimento) {
        return empreendimentoService.salvar(empreendimento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        empreendimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}