package br.com.imasoft.rh.repository;

import br.com.imasoft.rh.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
