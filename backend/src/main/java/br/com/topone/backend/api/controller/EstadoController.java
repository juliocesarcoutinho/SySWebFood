package br.com.topone.backend.api.controller;

import br.com.topone.backend.domain.exception.EntidadeEmUsoException;
import br.com.topone.backend.domain.exception.EntidadeNaoEncontradaException;
import br.com.topone.backend.domain.model.Estado;
import br.com.topone.backend.domain.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/estados")
public class EstadoController {    
    public final EstadoService estadoService;    
    @Autowired
    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }
    
    @GetMapping
    public ResponseEntity<List<Estado>> listar() {
        List<Estado> estados = estadoService.listar();
        return ResponseEntity.ok().body(estados);
    }
    
    @PostMapping
    public ResponseEntity<Estado> inserir(@RequestBody Estado estado) {
        Estado estadoSalvo = estadoService.adicionar(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoSalvo);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<String> alterar(@PathVariable Long id,
                                          @RequestBody Estado estado) {
        try {
            estadoService.atualizar(id, estado);
            return ResponseEntity.ok("Estado alterado com sucesso");
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.noContent().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        try {
            estadoService.remover(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


}
