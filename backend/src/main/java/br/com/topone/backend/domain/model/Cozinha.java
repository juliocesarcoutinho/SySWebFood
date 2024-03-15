package br.com.topone.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "cozinha")
public class Cozinha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@JsonProperty("titulo") /*Devolvendo para o Body o valor representativo*/
    //@JsonIgnore /*Ignora a propriedade ao enviar para o Body*/
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    /*Relacionamento Bidirecional*/
    @JsonIgnore // Não serializa o Objeto
    @OneToMany(mappedBy = "cozinha")
    private List<Restaurante> restaurantes = new ArrayList<>();
    
}
