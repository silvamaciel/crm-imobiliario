package com.malu.crmImobiliario.controller;

import com.malu.crmImobiliario.model.Lead;
import com.malu.crmImobiliario.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping
    public List<Lead> listarTodos() {
        return leadService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> buscarPorId(@PathVariable UUID id) {
        return leadService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lead salvar(@RequestBody Lead lead) {
        return leadService.salvar(lead);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        leadService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}