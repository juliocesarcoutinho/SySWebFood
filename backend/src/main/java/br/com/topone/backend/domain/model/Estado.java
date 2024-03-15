package br.com.topone.backend.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Data
@Table(name = "estado")
@EqualsAndHashCode(of = "id")
public class Estado implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    @NotBlank
    @NotNull
    private String nome;

    @Column
    @NotBlank
    @NotNull
    private String sigla;
    
    
    
}

