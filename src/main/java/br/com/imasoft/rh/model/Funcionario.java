package br.com.imasoft.rh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

    @Column(name = "matricula", unique = true, nullable = false)
    private String matricula;

    @Column(name = "data_contratacao", nullable = false)
    private LocalDate dataContratacao;

    @Column(name = "data_desligamento")
    private LocalDate dataDesligamento;

    public Funcionario(String matricula, LocalDate dataContratacao, LocalDate dataDesligamento) {
        super();
        this.matricula = matricula;
        this.dataContratacao = dataContratacao;
        this.dataDesligamento = dataDesligamento;
    }

    public Funcionario(Integer id,
                       String documento,
                       String nome,
                       Usuario usuario,
                       String matricula,
                       LocalDate dataContratacao,
                       LocalDate dataDesligamento) {
        super(id, documento, nome, usuario);
        this.matricula = matricula;
        this.dataContratacao = dataContratacao;
        this.dataDesligamento = dataDesligamento;
    }

    public static class Builder extends Pessoa.Builder {

        private String matricula;
        private LocalDate dataContratacao;
        private LocalDate dataDesligamento;

        public Builder id(Integer id) {
            super.id(id);
            return this;
        }

        public Builder documento(String documento) {
            super.documento(documento);
            return this;
        }

        public Builder nome(String nome) {
            super.nome(nome);
            return this;
        }

        public Builder usuario(Usuario usuario) {
            super.usuario(usuario);
            return this;
        }

        public Builder matricula(String matricula) {
            this.matricula = matricula;
            return this;
        }

        public Builder dataContratacao(LocalDate dataContratacao) {
            this.dataContratacao = dataContratacao;
            return this;
        }

        public Builder dataDesligamento(LocalDate dataDesligamento) {
            this.dataDesligamento = dataDesligamento;
            return this;
        }

        public Funcionario build() {
            return new Funcionario(getId(), getDocumento(), getNome(), getUsuario(), matricula, dataContratacao, dataDesligamento);
        }
    }

}
