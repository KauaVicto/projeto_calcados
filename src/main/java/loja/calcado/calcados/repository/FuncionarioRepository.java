package loja.calcado.calcados.repository;

import loja.calcado.calcados.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
