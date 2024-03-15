package br.com.topone.backend.domain.service;

import br.com.topone.backend.domain.exception.EntidadeNaoEncontradaException;
import br.com.topone.backend.domain.model.Cidade;
import br.com.topone.backend.domain.model.Estado;
import br.com.topone.backend.domain.repository.CidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    
    public final CidadeRepository cidadeRepository;

    @Autowired
    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }
    
    public List<Cidade> listar (){
        return cidadeRepository.findAll();
    }
    
    public Cidade adcionar (Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public void atualizar(Long id, Cidade cidadeAtual){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if (cidade.isEmpty()){
            throw new EntidadeNaoEncontradaException(String.format("Cidade com id %d não encontrado", id));
        } else {
            BeanUtils.copyProperties(cidadeAtual, cidade.get(), "id");
            cidadeRepository.save(cidade.get());
        }
    }

    public void remover (Long id){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if (cidade.isEmpty()) {
            throw new EntidadeNaoEncontradaException(String.format("Cidade com id %d não encontrado", id));
        } else {
            cidadeRepository.delete(cidade.get());
        }
    }
    
}
