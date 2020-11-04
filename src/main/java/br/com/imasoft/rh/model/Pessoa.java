package br.com.imasoft.rh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa")
    @Column(name = "id_pessoa")
    private Integer id;

    @Column(name = "documento", nullable = false, unique = true)
    private String documento;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Usuario usuario;

    public Pessoa(Integer id, String documento, String nome, Usuario usuario) {
        this.id = id;
        this.documento = documento;
        this.nome = nome;
        this.usuario = usuario;
    }

    @Getter
    public static class Builder {

        private Integer id;
        private String documento;
        private String nome;
        private Usuario usuario;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder documento(String documento) {
            this.documento = documento;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder usuario(Usuario usuario) {
            this.usuario = usuario;
            return this;
        }

    }

}
