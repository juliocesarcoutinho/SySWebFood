package br.com.topone.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
@EqualsAndHashCode(of = "id")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String senha;

    @Column(columnDefinition = "datetime")
    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime dataCadastro;

    @JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    @ManyToMany
    private List<Grupo> grupos = new ArrayList<>();

}
