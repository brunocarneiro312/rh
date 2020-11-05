package br.com.imasoft.rh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

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

    @Column(name = "horario_entrada")
    private LocalTime horarioEntrada;

    @Column(name = "horario_saida")
    private LocalTime horarioSaida;

    @Column(name = "carga_horaria_semanal")
    private Integer cargaHorariaSemanal;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Setor setor;

    @OneToMany(mappedBy = "funcionario")
    private Set<Ponto> registrosDePonto = new HashSet<>();

    public Funcionario(String matricula,
                       LocalDate dataContratacao,
                       LocalDate dataDesligamento,
                       LocalTime horarioEntrada,
                       LocalTime horarioSaida,
                       Integer cargaHorariaSemanal,
                       Empresa empresa,
                       Setor setor,
                       Set<Ponto> registrosDePonto) {
        this.matricula = matricula;
        this.dataContratacao = dataContratacao;
        this.dataDesligamento = dataDesligamento;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.empresa = empresa;
        this.setor = setor;
        this.registrosDePonto = registrosDePonto;
    }

    public Funcionario(Integer id,
                       String documento,
                       String nome,
                       Usuario usuario,
                       String matricula,
                       LocalDate dataContratacao,
                       LocalDate dataDesligamento,
                       LocalTime horarioEntrada,
                       LocalTime horarioSaida,
                       Integer cargaHorariaSemanal,
                       Empresa empresa,
                       Setor setor,
                       Set<Ponto> registrosDePonto) {
        super(id, documento, nome, usuario);
        this.matricula = matricula;
        this.dataContratacao = dataContratacao;
        this.dataDesligamento = dataDesligamento;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.empresa = empresa;
        this.setor = setor;
        this.registrosDePonto = registrosDePonto;
    }

    /**
     * -------
     * Builder
     * -------
     */
    public static class Builder extends Pessoa.Builder {

        private String matricula;
        private LocalDate dataContratacao;
        private LocalDate dataDesligamento;
        private LocalTime horarioEntrada;
        private LocalTime horarioSaida;
        private Integer cargaHorariaSemanal;
        private Empresa empresa;
        private Setor setor;
        private Set<Ponto> registrosDePonto = new HashSet<>();

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

        public Builder horarioEntrada(LocalTime horarioEntrada) {
            this.horarioEntrada = horarioEntrada;
            return this;
        }

        public Builder horarioSaida(LocalTime horarioEntrada) {
            this.horarioSaida = horarioEntrada;
            return this;
        }

        public Builder cargaHorariaSemanal(Integer cargaHorariaSemanal) {
            this.cargaHorariaSemanal = cargaHorariaSemanal;
            return this;
        }

        public Builder setor(Setor setor) {
            this.setor = setor;
            return this;
        }

        public Builder empresa(Empresa empresa) {
            this.empresa = empresa;
            return this;
        }

        public Builder registrosDePonto(Set<Ponto> registrosDePonto) {
            this.registrosDePonto = registrosDePonto;
            return this;
        }

        public Funcionario build() {
            return new Funcionario(
                    getId(),
                    getDocumento(),
                    getNome(),
                    getUsuario(),
                    matricula,
                    dataContratacao,
                    dataDesligamento,
                    horarioEntrada,
                    horarioSaida,
                    cargaHorariaSemanal,
                    empresa,
                    setor,
                    registrosDePonto);
        }
    }

    /**
     * ---------
     * Validator
     * ---------
     */
    public static class Validations {

        public static Predicate<Funcionario> isFuncionarioValidToPersist() {
            return f ->
                    Objects.nonNull(f)
                            && Objects.nonNull(f.getEmpresa())
                            && Objects.nonNull(f.getUsuario())
                            && Objects.nonNull(f.getSetor())
                            && Strings.isNotBlank(f.getMatricula())
                            && Strings.isNotBlank(f.getNome());
        }

        public static void validate(Funcionario funcionario) {
            if (Funcionario.Validations.isFuncionarioValidToPersist().negate().test(funcionario))
                throw new IllegalStateException("Funcionário inválido.");
        }
    }
}
