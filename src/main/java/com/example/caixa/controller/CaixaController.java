package com.example.caixa.controller;

import com.example.caixa.model.Caixa;
import com.example.caixa.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // Habilita CORS para todos os origens
@RequestMapping("/caixa")
public class CaixaController {

    @Autowired
    private CaixaRepository caixaRepository;

    @GetMapping
    public List<Caixa> getAllCaixas() {
        return caixaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caixa> getCaixaById(@PathVariable Long id) {
        Optional<Caixa> caixa = caixaRepository.findById(id);
        if (caixa.isPresent()) {
            return ResponseEntity.ok(caixa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Caixa createCaixa(@RequestBody Caixa caixa) {
        return caixaRepository.save(caixa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caixa> updateCaixa(@PathVariable Long id, @RequestBody Caixa caixaDetails) {
        Optional<Caixa> caixa = caixaRepository.findById(id);
        if (caixa.isPresent()) {
            Caixa caixaToUpdate = caixa.get();
            caixaToUpdate.setDescricao(caixaDetails.getDescricao());
            caixaToUpdate.setTipo(caixaDetails.getTipo());
            caixaToUpdate.setCliente(caixaDetails.getCliente());
            caixaToUpdate.setValor(caixaDetails.getValor());
            caixaToUpdate.setnumero_nota(caixaDetails.getnumero_nota());
            Caixa updatedCaixa = caixaRepository.save(caixaToUpdate);
            return ResponseEntity.ok(updatedCaixa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaixa(@PathVariable Long id) {
        if (caixaRepository.existsById(id)) {
            caixaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
