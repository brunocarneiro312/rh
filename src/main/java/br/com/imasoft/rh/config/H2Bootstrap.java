package br.com.imasoft.rh.config;

import br.com.imasoft.rh.model.Empresa;
import br.com.imasoft.rh.model.Funcionario;
import br.com.imasoft.rh.model.Ponto;
import br.com.imasoft.rh.model.Usuario;
import br.com.imasoft.rh.repository.EmpresaRepository;
import br.com.imasoft.rh.repository.FuncionarioRepository;
import br.com.imasoft.rh.repository.PontoRepository;
import br.com.imasoft.rh.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class H2Bootstrap implements ApplicationRunner {

    private final EmpresaRepository empresaRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioService funcionarioService;

    @Autowired
    public H2Bootstrap(EmpresaRepository empresaRepository,
                       FuncionarioRepository funcionarioRepository,
                       FuncionarioService funcionarioService) {
        this.empresaRepository = empresaRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioService = funcionarioService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("-----------");
        System.out.println("H2Bootstrap");
        System.out.println("-----------");

        Empresa google = google();

        Funcionario bruno = new Funcionario.Builder()
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
                .horarioEntrada(LocalTime.of(8, 0))
                .horarioSaida(LocalTime.of(17, 0))
                .cargaHorariaSemanal(40)
                .build();


        google.getColaboradores().add(bruno);
        this.empresaRepository.save(google);

        Ponto novoRegistro = new Ponto(null, null, LocalDateTime.now(), "Meu primeiro dia de trabalho");
        this.funcionarioService.registrarPonto(bruno, novoRegistro);

    }

    private Empresa google() {
        return new Empresa.Builder()
                .cnpj("46.123.195/0001-68")
                .nome("Google")
                .segmento("TI")
                .telefone("555 0370")
                .email("google@gmail.com")
                .build();
    }
}
