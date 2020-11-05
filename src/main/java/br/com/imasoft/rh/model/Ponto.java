package br.com.imasoft.rh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Predicate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ponto")
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ponto")
    @SequenceGenerator(name = "seq_ponto", sequenceName = "seq_ponto")
    private Integer id;

    @ManyToOne
    private Funcionario funcionario;

    @Column(name = "hora_registro", nullable = false)
    private LocalDateTime horaRegistro;

    @Column(name = "anotacoes")
    private String anotacoes;

    public Ponto(Integer id, Funcionario funcionario, LocalDateTime horaRegistro, String anotacoes) {
        this.id = id;
        this.funcionario = funcionario;
        this.horaRegistro = horaRegistro;
        this.anotacoes = anotacoes;
    }

    @Override
    public String toString() {
        return "Ponto{" +
                "id=" + id +
                ", funcionario=" + funcionario +
                ", horaRegistro=" + horaRegistro +
                ", anotacoes='" + anotacoes + '\'' +
                '}';
    }

    /**
     * ---------
     * Validator
     * ---------
     */
    public static class Validations {

        public static Predicate<Ponto> isPontoValidToPersist() {
            return p ->
                    Objects.nonNull(p)
                    && Objects.nonNull(p.getHoraRegistro());
        }

        public static void validate(Ponto ponto) {
            if (Ponto.Validations.isPontoValidToPersist().test(ponto))
                throw new IllegalStateException("Registro de ponto inválido.");
        }
    }
}
