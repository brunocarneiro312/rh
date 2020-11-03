package br.com.imasoft.rh.service.impl;

import br.com.imasoft.rh.model.Funcionario;
import br.com.imasoft.rh.repository.FuncionarioRepository;
import br.com.imasoft.rh.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Funcionario registrarNovoFuncionario(Funcionario funcionario) throws Exception {
        return null;
    }

    @Override
    public Funcionario alterarRegistroDeFuncionario(Funcionario funcionario) throws Exception {
        return null;
    }

    @Override
    public Funcionario desligarFuncionario(Funcionario funcionario) throws Exception {
        return null;
    }

    @Override
    public List<Funcionario> consultarFeriasDosFuncionarios() throws Exception {
        return null;
    }

    @Override
    public List<Funcionario> consultarFeriasDosFuncionarios(Integer nosProximosXDias) throws Exception {
        return null;
    }

    @Override
    public List<Funcionario> consultarSalariosDosFuncionarios() throws Exception {
        return null;
    }
}
