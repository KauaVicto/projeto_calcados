package loja.calcado.calcados.service;

import loja.calcado.calcados.domain.Endereco;
import loja.calcado.calcados.domain.Funcionario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FuncionarioService {
    private static List<Funcionario> funcionarios;
    static {
        Endereco end1 = new Endereco("Baraúnas", "Rua José Alvino Machado", "Brumado", "Bahia", "46100000");
        Endereco end2 = new Endereco("Esmeraldas", "Rua Orácio", "Brumado", "Bahia", "46100000");
        funcionarios = new ArrayList<>(List.of(new Funcionario(1L, "João", "(77) 99954-2346", "2003-10-19", "09878967856", "4789234732", end1, "joao@gmail.com", "5469523475"), new Funcionario(2L, "Kauã", "(77) 99983-1299", "2003-05-23", "54548652154", "1545648645", end2, "kaua@gmail.com", "5656452")));
    }


    // private final ProdutoRepository produtoRepository;
    public List<Funcionario> listAll(){
        return funcionarios;
    }
    public Funcionario findById(long id){
        return funcionarios.stream()
                .filter(funcionarios -> funcionarios.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto not Found"));
    }

}
