package br.com.topone.backend.api.controller;

import br.com.topone.backend.domain.exception.EntidadeEmUsoException;
import br.com.topone.backend.domain.exception.EntidadeNaoEncontradaException;
import br.com.topone.backend.domain.model.Cidade;
import br.com.topone.backend.domain.model.Estado;
import br.com.topone.backend.domain.service.CidadeService;
import br.com.topone.backend.domain.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cidades")
public class CidadeController {
    
    public final CidadeService cidadeService;
    
    @Autowired
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listar() {
        List<Cidade> cidades = cidadeService.listar();
        return ResponseEntity.ok().body(cidades);
    }
    
    @PostMapping
    public ResponseEntity<Cidade> inserir (@RequestBody Cidade cidade){
        Cidade cidadeNova = cidadeService.adcionar(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeNova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterar(@PathVariable Long id,
                                          @RequestBody Cidade cidade) {
        try {
            cidadeService.atualizar(id, cidade);
            return ResponseEntity.ok("Cidade alterada com sucesso");
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.noContent().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        try {
            cidadeService.remover(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    
    
}
