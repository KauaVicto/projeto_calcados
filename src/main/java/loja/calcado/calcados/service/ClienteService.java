package loja.calcado.calcados.service;

import loja.calcado.calcados.domain.Endereco;
import loja.calcado.calcados.domain.Cartao;
import loja.calcado.calcados.domain.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ClienteService {
    private static List<Cliente> clientes;
    static {
        Endereco end1 = new Endereco("Baraúnas", "Rua José Alvino Machado", "Brumado", "Bahia", "46100000");
        Endereco end2 = new Endereco("Esmeraldas", "Rua Orácio", "Brumado", "Bahia", "46100000");
        Cartao c1 = new Cartao(1, "4235234598766789", "Mastercard", 2000.00, "Crédito");
        Cartao c2 = new Cartao(2, "0987897567843674", "Visa", 3500.00, "Crédito");
        clientes = new ArrayList<>(List.of(new Cliente(1L, "Mirella", "(77) 99953-2654", "2005-12-05", "42323454322", end1, c1), new Cliente(2L, "Pedro", "(77) 99954-9378", "2006-01-23", "98540392533", end2, c2)));
    }


    // private final ProdutoRepository produtoRepository;
    public List<Cliente> listAll(){
        return clientes;
    }
    public Cliente findById(long id){
        return clientes.stream()
                .filter(clientes -> clientes.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto not Found"));
    }

    public Cliente save(Cliente cliente) {
        cliente.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        clientes.add(cliente);
        return cliente;
    }

    public void delete(long id) {
        clientes.remove(findById(id));
    }
}
