package br.com.imasoft.rh.service;

import br.com.imasoft.rh.model.Funcionario;
import br.com.imasoft.rh.model.Ponto;

import java.util.List;

public interface FuncionarioService {

    Funcionario registrarNovoFuncionario(Funcionario funcionario) throws Exception;

    Ponto registrarPonto(Funcionario funcionario, Ponto ponto) throws Exception;

    Funcionario alterarRegistroDeFuncionario(Funcionario funcionario) throws Exception;

    Funcionario desligarFuncionario(Funcionario funcionario) throws Exception;

    List<Funcionario> consultarFeriasDosFuncionarios() throws Exception;

    List<Funcionario> consultarFeriasDosFuncionarios(Integer nosProximosXDias) throws Exception;

    List<Funcionario> consultarSalariosDosFuncionarios() throws Exception;

}
