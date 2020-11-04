package br.com.imasoft.rh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "supervisor")
public class Supervisor extends Pessoa {

    @OneToOne(mappedBy = "supervisor")
    private Setor setor;

    public Supervisor(Setor setor) {
        this.setor = setor;
    }

    public Supervisor(Integer id, String documento, String nome, Usuario usuario, Setor setor) {
        super(id, documento, nome, usuario);
        this.setor = setor;
    }

    public static class Builder extends Pessoa.Builder {

        private Setor setor;

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

        public Builder setor(Setor setor) {
            this.setor = setor;
            return this;
        }

        public Supervisor build() {
            return new Supervisor(getId(), getDocumento(), getNome(), getUsuario(), setor);
        }
    }
}
