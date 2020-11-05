package br.com.imasoft.rh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empresa")
    @SequenceGenerator(name = "seq_empresa", sequenceName = "seq_empresa")
    private Integer id;

    @OneToMany(mappedBy = "empresa")
    private Set<Responsavel> responsaveis;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cnpj", unique = true, nullable = false)
    private String cnpj;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "segmento", nullable = false)
    private String segmento;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST)
    private Set<Funcionario> colaboradores = new HashSet<>();

    @OneToMany(mappedBy = "empresa")
    private Set<Setor> setores = new HashSet<>();

    public Empresa(Integer id,
                   Set<Responsavel> responsaveis,
                   String nome,
                   String cnpj,
                   String email,
                   String telefone,
                   String segmento,
                   Set<Funcionario> colaboradores,
                   Set<Setor> setores) {
        this.id = id;
        this.responsaveis = responsaveis;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.segmento = segmento;
        this.colaboradores = colaboradores;
        this.setores = setores;
    }

    public static class Builder {

        private Integer id;
        private Set<Responsavel> responsaveis;
        private String nome;
        private String email;
        private String cnpj;
        private String telefone;
        private String segmento;
        private Set<Funcionario> colaboradores = new HashSet<>();
        private Set<Setor> setores = new HashSet<>();

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder responsaveis(Set<Responsavel> responsaveis) {
            this.responsaveis = responsaveis;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder cnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder segmento(String segmento) {
            this.segmento = segmento;
            return this;
        }

        public Builder colaboradores(Set<Funcionario> colaboradores) {
            this.colaboradores = colaboradores;
            return this;
        }

        public Builder setores(Set<Setor> setores) {
            this.setores = setores;
            return this;
        }

        public Empresa build() {
            return new Empresa(id, responsaveis, nome, cnpj, email, telefone, segmento, colaboradores, setores);
        }
    }
}
