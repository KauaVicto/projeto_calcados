package loja.calcado.calcados.repository;

import loja.calcado.calcados.domain.Cliente;

import java.util.List;

public interface ClienteRepository {
    List<Cliente> listAll();
}
