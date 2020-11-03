package br.com.imasoft.rh.service.impl;

import br.com.imasoft.rh.model.Funcionario;
import br.com.imasoft.rh.model.Usuario;
import br.com.imasoft.rh.repository.UsuarioRepository;
import br.com.imasoft.rh.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrarNovoUsuario(Usuario usuario) throws Exception {
        return null;
    }

    @Override
    public Usuario ativarUsuario(Usuario usuario) throws Exception {
        return null;
    }

    @Override
    public Usuario desativarUsuario(Usuario usuario) throws Exception {
        return null;
    }

    @Override
    public Usuario resetarSenha(Funcionario funcionario, String novaSenha) throws Exception {
        return null;
    }

    @Override
    public List<Usuario> listarFuncionarios() throws Exception {
        return null;
    }
}
