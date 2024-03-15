package br.com.topone.backend.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Data
@Table(name = "cidade")
@EqualsAndHashCode(of = "id")
public class Cidade implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    @NotNull
    @NotBlank
    private String nome;
    
    @JoinColumn(name = "estado_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;
    
}
