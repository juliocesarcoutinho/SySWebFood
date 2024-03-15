package br.com.topone.backend.domain.exception;

public class EntidadeEmUsoException extends RuntimeException{
    public EntidadeEmUsoException(String mensagem){
        super(mensagem);
    }
}
