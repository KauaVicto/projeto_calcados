package loja.calcado.calcados.controller;

import loja.calcado.calcados.domain.Funcionario;
import loja.calcado.calcados.requests.FuncionarioPostRequestBody;
import loja.calcado.calcados.requests.FuncionarioPutRequestBody;
import loja.calcado.calcados.service.FuncionarioService;
import loja.calcado.calcados.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("funcionarios")
@Log4j2
@RequiredArgsConstructor
public class FuncionarioController {
    private final DateUtil dateUtil;
    private final FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(funcionarioService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable long id){
        return ResponseEntity.ok(funcionarioService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody FuncionarioPostRequestBody funcionarioPostRequestBody){
        return new ResponseEntity<>(funcionarioService.save(funcionarioPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        funcionarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody FuncionarioPutRequestBody funcionarioPutRequestBody){
        funcionarioService.replace(funcionarioPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
