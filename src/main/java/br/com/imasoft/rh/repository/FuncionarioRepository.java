package br.com.imasoft.rh.repository;

import br.com.imasoft.rh.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
