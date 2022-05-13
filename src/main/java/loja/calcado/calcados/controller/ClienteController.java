package loja.calcado.calcados.controller;

import loja.calcado.calcados.domain.Cliente;
import loja.calcado.calcados.service.ClienteService;
import loja.calcado.calcados.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("clientes")
@Log4j2
@RequiredArgsConstructor
public class ClienteController {
    private final DateUtil dateUtil;
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(clienteService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id){
        return ResponseEntity.ok(clienteService.findById(id));
    }
}