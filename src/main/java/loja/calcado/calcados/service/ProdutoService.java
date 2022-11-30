package loja.calcado.calcados.service;

import loja.calcado.calcados.domain.Produto;
import loja.calcado.calcados.requests.ProdutoPostRequestBody;
import loja.calcado.calcados.requests.ProdutoPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import loja.calcado.calcados.repository.ProdutoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {


    private final ProdutoRepository produtoRepository;
    public List<Produto> listAll(){
        return produtoRepository.findAll();
    }
    public Produto findByIdOrThrowBadRequestException(long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto not Found"));
    }

    public Produto save(String nome, String tipo, String genero, String marca, double preco, String img) {
        Produto produto = Produto.builder()
                .name(nome)
                .marca(marca)
                .tipo(tipo)
                .genero(genero)
                .preco(preco)
                .img(img)
                .build();
        return produtoRepository.save(produto);
    }

    public void delete(long id) {
        produtoRepository.delete(findByIdOrThrowBadRequestException(id));
    }


    public void replace(ProdutoPutRequestBody produtoPutRequestBody) {
        Produto savedProduto = findByIdOrThrowBadRequestException(produtoPutRequestBody.getId());

        Produto produto = Produto.builder()
                .id(savedProduto.getId())
                .name(produtoPutRequestBody.getName())
                .marca(produtoPutRequestBody.getMarca())
                .tipo(produtoPutRequestBody.getTipo())
                .genero(produtoPutRequestBody.getGenero())
                .preco(produtoPutRequestBody.getPreco())
                .build();
        produtoRepository.save(produto);
    }
}
