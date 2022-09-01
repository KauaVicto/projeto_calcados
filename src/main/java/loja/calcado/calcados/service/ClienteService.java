package loja.calcado.calcados.service;

import loja.calcado.calcados.domain.Cliente;
import loja.calcado.calcados.domain.Produto;
import loja.calcado.calcados.requests.ClientePostRequestBody;
import loja.calcado.calcados.requests.ClientePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import loja.calcado.calcados.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class ClienteService {


    private final ClienteRepository clienteRepository;
    public List<Cliente> listAll(){
        return clienteRepository.findAll();

    }
    public Cliente findByIdOrThrowBadRequestException(long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente not Found"));
    }

    public Cliente save(ClientePostRequestBody clientePostRequestBody) {
        Cliente cliente = Cliente.builder()
                .name(clientePostRequestBody.getName())
                .telefone(clientePostRequestBody.getTelefone())
                .data_nascimento(clientePostRequestBody.getData_nascimento())
                .cpf(clientePostRequestBody.getCpf())
                .endereco(clientePostRequestBody.getEndereco())
                .cartao(clientePostRequestBody.getCartao())
                .build();
        return clienteRepository.save(cliente);
    }

    public void delete(long id) {
        clienteRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ClientePutRequestBody clientePutRequestBody) {
        Cliente savedCliente = findByIdOrThrowBadRequestException(clientePutRequestBody.getId());

        Cliente cliente = Cliente.builder()
                .id(clientePutRequestBody.getId())
                .name(clientePutRequestBody.getName())
                .telefone(clientePutRequestBody.getTelefone())
                .data_nascimento(clientePutRequestBody.getData_nascimento())
                .cpf(clientePutRequestBody.getCpf())
                .endereco(clientePutRequestBody.getEndereco())
                .cartao(clientePutRequestBody.getCartao())
                .build();
        clienteRepository.save(cliente);
    }
}
