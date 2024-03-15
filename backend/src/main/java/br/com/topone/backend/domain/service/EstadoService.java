package br.com.topone.backend.domain.service;

import br.com.topone.backend.domain.exception.EntidadeNaoEncontradaException;
import br.com.topone.backend.domain.model.Estado;
import br.com.topone.backend.domain.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {    
    public final EstadoRepository estadoRepository;   
    @Autowired
    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }
    
    public List<Estado> listar(){
        return estadoRepository.findAll();
    }

    public Estado adicionar(Estado estado){
        return estadoRepository.save(estado);
    }

    public void atualizar(Long id, Estado estadoAtual){
        Optional<Estado> estado = estadoRepository.findById(id);
        if (estado.isEmpty()){
            throw new EntidadeNaoEncontradaException(String.format("Estado com id %d não encontrado", id));
        } else {
            BeanUtils.copyProperties(estadoAtual, estado.get(), "id");
            estadoRepository.save(estado.get());
        }
    }
    public void remover (Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        if (estado.isEmpty()) {
            throw new EntidadeNaoEncontradaException(String.format("Estado com id %d não encontrado", id));
        } else {
            estadoRepository.delete(estado.get());
        }
    }
    
}
