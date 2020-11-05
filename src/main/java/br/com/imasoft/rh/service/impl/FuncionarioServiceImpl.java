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
            System.err.println("Não foi possível registrar o ponto do funcionario [Matrícula: " + funcionario.getMatricula() + "]");
            throw new Exception(e);
        }
    }

    @Override
    public Funcionario registrarNovoFuncionario(Funcionario funcionario) throws Exception {
        try {
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
            return null;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public List<Funcionario> consultarFeriasDosFuncionarios() throws Exception {
        try {
            return null;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public List<Funcionario> consultarFeriasDosFuncionarios(Integer nosProximosXDias) throws Exception {
        try {
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
