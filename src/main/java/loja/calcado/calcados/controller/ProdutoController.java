package loja.calcado.calcados.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import loja.calcado.calcados.domain.Produto;
import loja.calcado.calcados.requests.ProdutoPostRequestBody;
import loja.calcado.calcados.requests.ProdutoPutRequestBody;
import loja.calcado.calcados.service.ProdutoService;
import loja.calcado.calcados.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("cors-library/managed/produtos")
@Log4j2
@RequiredArgsConstructor
public class ProdutoController {
    private final DateUtil dateUtil;
    private final ProdutoService produtoService;

    private static String caminhoImagens = "src/public/img/";

    @GetMapping
    public ResponseEntity<List<Produto>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        Iterable<Produto> p1 = produtoService.listAll();

        List<Produto> produtos =  StreamSupport.stream(p1.spliterator(), false).map(produto ->{
            Produto prod = new Produto();
            BeanUtils.copyProperties(produto, prod);
            prod.setImg("opa.png");
            return prod;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(produtos);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id){
        return ResponseEntity.ok(produtoService.findByIdOrThrowBadRequestException(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<Produto> save(
            @RequestParam(value = "file", required = true) MultipartFile arquivo,
            @RequestParam(value= "nome") String nome,
            @RequestParam(value= "tipo") String tipo,
            @RequestParam(value= "genero") String genero,
            @RequestParam(value= "marca") String marca,
            @RequestParam(value= "preco") double preco
    ){

        try{
            if(!arquivo.isEmpty()){
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagens + arquivo.getOriginalFilename());
                Files.write(caminho, bytes);


            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(produtoService.save(nome, tipo, genero, marca, preco, arquivo.getOriginalFilename()), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ProdutoPutRequestBody produtoPutRequestBody){
        produtoService.replace(produtoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
