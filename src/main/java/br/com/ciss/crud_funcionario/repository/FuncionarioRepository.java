package br.com.ciss.crud_funcionario.repository;

import br.com.ciss.crud_funcionario.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
