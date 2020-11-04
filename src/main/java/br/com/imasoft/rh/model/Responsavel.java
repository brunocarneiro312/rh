package br.com.imasoft.rh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "responsavel")
public class Responsavel extends Pessoa {

    @ManyToOne
    private Empresa empresa;

    public Responsavel(Empresa empresa) {
        this.empresa = empresa;
    }

    public Responsavel(Integer id, String documento, String nome, Usuario usuario, Empresa empresa) {
        super(id, documento, nome, usuario);
        this.empresa = empresa;
    }

    public static class Builder extends Pessoa.Builder {

        private Empresa empresa;

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

        public Responsavel build() {
            return new Responsavel(getId(), getDocumento(), getNome(), getUsuario(), empresa);
        }
    }
}
