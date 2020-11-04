package br.com.imasoft.rh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario")
    private Integer id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name ="password", nullable = false)
    private String password;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Usuario(Integer id, String email, String password, Boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.active = active;
        this.createdAt = createdAt;
    }

    public Usuario(String email, String password, Boolean active, LocalDateTime createdAt) {
        this.email = email;
        this.password = password;
        this.active = active;
        this.createdAt = createdAt;
    }

    public static class Builder {
        private Integer id;
        private String email;
        private String password;
        private Boolean active;
        private LocalDateTime createdAt;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Usuario build() {
            return new Usuario(id, email, password, active, createdAt);
        }

    }
}
