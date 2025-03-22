package com.malu.crmImobiliario.controller;

import com.malu.crmImobiliario.model.Apartamento;
import com.malu.crmImobiliario.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @GetMapping
    public List<Apartamento> listarTodos() {
        return apartamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartamento> buscarPorId(@PathVariable UUID id) {
        return apartamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Apartamento salvar(@RequestBody Apartamento apartamento) {
        return apartamentoService.salvar(apartamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        apartamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
