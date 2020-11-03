package br.com.imasoft.rh.service;

import br.com.imasoft.rh.model.Funcionario;
import br.com.imasoft.rh.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario registrarNovoUsuario(Usuario usuario) throws Exception;

    Usuario ativarUsuario(Usuario usuario) throws Exception;

    Usuario desativarUsuario(Usuario usuario) throws Exception;

    Usuario resetarSenha(Funcionario funcionario, String novaSenha) throws Exception;

    List<Usuario> listarFuncionarios() throws Exception;

}
