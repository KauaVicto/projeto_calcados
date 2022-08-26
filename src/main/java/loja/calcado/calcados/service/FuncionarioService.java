package loja.calcado.calcados.service;

import loja.calcado.calcados.domain.Funcionario;
import loja.calcado.calcados.repository.FuncionarioRepository;
import loja.calcado.calcados.requests.FuncionarioPostRequestBody;
import loja.calcado.calcados.requests.FuncionarioPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    public List<Funcionario> listAll(){
        return funcionarioRepository.findAll();
    }
    public Funcionario findByIdOrThrowBadRequestException(long id){
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto not Found"));
    }

    public Funcionario save(FuncionarioPostRequestBody funcionarioPostRequestBody) {
        Funcionario funcionario = Funcionario.builder()
                .name(funcionarioPostRequestBody.getName())
                .carteira_trabalho(funcionarioPostRequestBody.getCarteira_trabalho())
                .email(funcionarioPostRequestBody.getEmail())
                .endereco(funcionarioPostRequestBody.getEndereco())
                .rg(funcionarioPostRequestBody.getRg())
                .cpf(funcionarioPostRequestBody.getCpf())
                .data_nascimento(funcionarioPostRequestBody.getData_nascimento())
                .telefone(funcionarioPostRequestBody.getTelefone())
                .build();
        return funcionarioRepository.save(funcionario);
    }

    public void delete(long id) {
        funcionarioRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(FuncionarioPutRequestBody funcionarioPutRequestBody) {
        Funcionario savedFuncionario = findByIdOrThrowBadRequestException(funcionarioPutRequestBody.getId());

        Funcionario funcionario = Funcionario.builder()
                .id(savedFuncionario.getId())
                .name(funcionarioPutRequestBody.getName())
                .carteira_trabalho(funcionarioPutRequestBody.getCarteira_trabalho())
                .email(funcionarioPutRequestBody.getEmail())
                .endereco(funcionarioPutRequestBody.getEndereco())
                .rg(funcionarioPutRequestBody.getRg())
                .cpf(funcionarioPutRequestBody.getCpf())
                .data_nascimento(funcionarioPutRequestBody.getData_nascimento())
                .telefone(funcionarioPutRequestBody.getTelefone())
                .build();
        funcionarioRepository.save(funcionario);
    }
}
