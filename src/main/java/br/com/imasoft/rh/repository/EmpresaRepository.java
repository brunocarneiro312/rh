package br.com.imasoft.rh.repository;

import br.com.imasoft.rh.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
