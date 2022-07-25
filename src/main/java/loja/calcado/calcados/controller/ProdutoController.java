package loja.calcado.calcados.controller;

import loja.calcado.calcados.domain.Funcionario;
import loja.calcado.calcados.domain.Produto;
import loja.calcado.calcados.service.ProdutoService;
import loja.calcado.calcados.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("produtos")
@Log4j2
@RequiredArgsConstructor
public class ProdutoController {
    private final DateUtil dateUtil;
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(produtoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id){
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
    }
}
