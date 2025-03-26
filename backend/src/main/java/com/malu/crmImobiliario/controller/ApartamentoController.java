package com.malu.crmImobiliario.controller;

import com.malu.crmImobiliario.dto.ApartamentoDTO;
import com.malu.crmImobiliario.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @GetMapping
    public List<ApartamentoDTO> listarTodos() {
        return apartamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartamentoDTO> buscarPorId(@PathVariable UUID id) {
        Optional<ApartamentoDTO> apartamento = apartamentoService.buscarPorId(id);
        return apartamento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApartamentoDTO> salvar(@RequestBody ApartamentoDTO apartamentoDTO) {
        ApartamentoDTO novoApartamento = apartamentoService.salvar(apartamentoDTO);
        return ResponseEntity.ok(novoApartamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        apartamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
