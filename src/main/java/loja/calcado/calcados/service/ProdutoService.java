package loja.calcado.calcados.service;

import loja.calcado.calcados.domain.Funcionario;
import loja.calcado.calcados.domain.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ProdutoService {
    private static List<Produto> produtos;
    static {
        produtos = new ArrayList<>(List.of(new Produto(1L, "Tênis de Corrida", "tênis", "Adidas", "masculino", 230.00), new Produto(2L, "Bota", "Bota", "Bota boa", "masculina", 145.50)));
    }


    // private final ProdutoRepository produtoRepository;
    public List<Produto> listAll(){
        return produtos;
    }
    public Produto findById(long id){
        return produtos.stream()
                .filter(produtos -> produtos.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto not Found"));
    }

    public Produto save(Produto produto) {
        produto.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        produtos.add(produto);
        return produto;
    }

    public void delete(long id) {
        produtos.remove(findById(id));
    }
}
