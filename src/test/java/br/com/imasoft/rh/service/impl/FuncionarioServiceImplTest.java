package br.com.imasoft.rh.service.impl;

import br.com.imasoft.rh.model.*;
import br.com.imasoft.rh.repository.FuncionarioRepository;
import br.com.imasoft.rh.repository.PontoRepository;
import br.com.imasoft.rh.service.FuncionarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FuncionarioServiceImplTest {

    private FuncionarioService funcionarioService;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private PontoRepository pontoRepository;

    @BeforeEach
    public void setUp() {
        this.funcionarioService = new FuncionarioServiceImpl(funcionarioRepository, pontoRepository);
    }

    @Test
    @DisplayName("Dado um registro de ponto e um funcionário, quando registrar o ponto, então retorna o registro")
    public void givenFuncionarioPonto_whenRegistrarPonto_thenReturnPontoRegistrado() throws Exception {

        // given
        Funcionario funcionario = getFuncionario();
        Ponto ponto = getPonto();
        given(this.funcionarioRepository.findById(any())).willReturn(Optional.of(funcionario));
        given(this.pontoRepository.save(any())).willReturn(ponto);

        // when
        Ponto pontoRegistrado = this.funcionarioService.registrarPonto(funcionario, ponto);

        // then
        verify(this.funcionarioRepository).findById(any());
        verify(this.pontoRepository).save(any(Ponto.class));
        assertAll("Testando registro de ponto",
                () -> assertNotNull(pontoRegistrado),
                () -> assertNotNull(ponto.getFuncionario()));
    }

    @Test
    @DisplayName("Dado um funcionário, quando o funcionário é registrado, então retorna novo funcionário")
    public void givenFuncionario_whenRegistrarNovoFuncionario_thenReturnFuncionarioRegistrado() throws Exception {

        // given
        Funcionario funcionario = getFuncionario();
        given(this.funcionarioRepository.save(any(Funcionario.class))).willReturn(funcionario);

        // when
        Funcionario novoFuncionario = this.funcionarioService.registrarNovoFuncionario(funcionario);

        // then
        verify(this.funcionarioRepository).save(any());
        assertAll("Testando registro de funcionário",
                () -> assertNotNull(novoFuncionario));
    }

    private Funcionario getFuncionario() {
        return new Funcionario.Builder()
                .documento("7777777")
                .nome("Bruno Carneiro")
                .dataContratacao(LocalDate.of(2020, 1, 1))
                .matricula("77777777")
                .empresa(getEmpresa())
                .setor(getSetor())
                .horarioEntrada(LocalTime.of(8, 0))
                .horarioSaida(LocalTime.of(17,0))
                .cargaHorariaSemanal(40)
                .usuario(new Usuario.Builder()
                        .email("bruno.carneiro312@gmail.com")
                        .password("test")
                        .active(true)
                        .build())
                .build();
    }

    private Ponto getPonto() {
        return new Ponto(null, null, LocalDateTime.now(), "ponto teste");
    }

    private Empresa getEmpresa() {
        return new Empresa.Builder()
                .nome("Empresa teste")
                .email("empresa@test.com")
                .segmento("TI")
                .cnpj("10.965.991/0001-09")
                .telefone("7777777")
                .build();
    }

    private Setor getSetor() {
        return new Setor.Builder()
                .nome("Setor7")
                .supervisor(getSupervisor())
                .build();
    }

    private Supervisor getSupervisor() {
        return new Supervisor.Builder()
                .documento("88888888")
                .nome("Thiago Carneiro")
                .usuario(new Usuario.Builder()
                        .active(true)
                        .email("thiago.carneiro@gmail.com")
                        .password("teste")
                        .createdAt(LocalDateTime.now())
                        .build())
                .build();
    }
}