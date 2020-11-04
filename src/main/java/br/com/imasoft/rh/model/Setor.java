package br.com.imasoft.rh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "setor")
public class Setor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_setor")
    @SequenceGenerator(name = "seq_setor", sequenceName = "seq_setor")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToOne
    private Supervisor supervisor;

    @OneToMany(mappedBy = "setor")
    private Set<Funcionario> funcionarios;

    @ManyToOne
    private Empresa empresa;

    public Setor(Integer id, String nome, Supervisor supervisor, Empresa empresa) {
        this.id = id;
        this.nome = nome;
        this.supervisor = supervisor;
        this.empresa = empresa;
    }

    public static class Builder {

        private Integer id;
        private String nome;
        private Supervisor supervisor;
        private Empresa empresa;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder supervisor(Supervisor supervisor) {
            this.supervisor = supervisor;
            return this;
        }

        public Builder empresa(Empresa empresa) {
            this.empresa = empresa;
            return this;
        }

        public Setor build() {
            return new Setor(id, nome, supervisor, empresa);
        }
    }
}
