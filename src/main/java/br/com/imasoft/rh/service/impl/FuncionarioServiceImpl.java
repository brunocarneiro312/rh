package br.com.imasoft.rh.service.impl;

import br.com.imasoft.rh.model.Funcionario;
import br.com.imasoft.rh.model.Ponto;
import br.com.imasoft.rh.repository.FuncionarioRepository;
import br.com.imasoft.rh.repository.PontoRepository;
import br.com.imasoft.rh.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final PontoRepository pontoRepository;

    @Autowired
    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository, PontoRepository pontoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.pontoRepository = pontoRepository;
    }

    @Override
    public Ponto registrarPonto(Funcionario funcionario, Ponto ponto) throws Exception {
        try {
            Funcionario.Validations.validate(funcionario);
            Ponto.Validations.validate(ponto);
            ponto.setFuncionario(funcionario);
            return this.pontoRepository.save(ponto);
        }
        catch (Exception e) {
            System.err.println("Não foi possível registrar o ponto do funcionario.");
            throw new Exception(e);
        }
    }

    @Override
    public Funcionario registrarNovoFuncionario(Funcionario funcionario) throws Exception {
        try {
            /**
             * TODO:
             * - se o usuário não existir, registrar
             * - se o usuário existir, altera funcionário e seta usuário para ativo
             */
            Funcionario.Validations.validate(funcionario);
            if (funcionario.getDataContratacao() == null) {
                funcionario.setDataContratacao(LocalDate.now());
            }
            return this.funcionarioRepository.save(funcionario);
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public Funcionario alterarRegistroDeFuncionario(Funcionario funcionario) throws Exception {
        try {
            return null;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public Funcionario desligarFuncionario(Funcionario funcionario) throws Exception {
        try {
            /**
             * TODO:
             * - preencher data de desligamento do funcionário
             * - alterar o usuário do funcionaŕio para inativo (active = false)
             */
            return null;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public List<Funcionario> consultarFeriasDosFuncionarios() throws Exception {
        try {
            // TODO: apenas dos usuários ativos
            return null;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public List<Funcionario> consultarFeriasDosFuncionarios(Integer nosProximosXDias) throws Exception {
        try {
            // TODO: se o parâmetro for null ou 0, listar as férias de todos os funcionários ativos
            return null;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public List<Funcionario> consultarSalariosDosFuncionarios() throws Exception {
        try {
            return null;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
