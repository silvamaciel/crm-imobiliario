package com.malu.crmImobiliario.controller;

import com.malu.crmImobiliario.model.Contrato;
import com.malu.crmImobiliario.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<Contrato> listarTodos() {
        return contratoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarPorId(@PathVariable UUID id) {
        return contratoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contrato salvar(@RequestBody Contrato contrato) {
        return contratoService.salvar(contrato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        contratoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
