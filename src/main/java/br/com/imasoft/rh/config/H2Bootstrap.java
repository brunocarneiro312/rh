package br.com.imasoft.rh.config;

import br.com.imasoft.rh.model.Funcionario;
import br.com.imasoft.rh.model.Usuario;
import br.com.imasoft.rh.repository.FuncionarioRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class H2Bootstrap implements ApplicationRunner {

    private final FuncionarioRepository funcionarioRepository;

    public H2Bootstrap(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("-----------");
        System.out.println("H2Bootstrap");
        System.out.println("-----------");

        Funcionario funcionario = new Funcionario.Builder()
                .nome("Bruno Carneiro")
                .documento("00825346169")
                .usuario(new Usuario.Builder()
                        .active(true)
                        .createdAt(LocalDateTime.now())
                        .email("bruno.carneiro312@gmail.com")
                        .password("senha")
                        .build())
                .matricula("7777777")
                .dataContratacao(LocalDate.now())
                .build();

        this.funcionarioRepository.save(funcionario);
    }
}
