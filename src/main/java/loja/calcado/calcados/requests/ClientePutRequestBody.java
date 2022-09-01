package loja.calcado.calcados.requests;

import lombok.Data;

@Data
public class ClientePutRequestBody {
    private Long id;
    private String name;
    private String telefone;
    private String data_nascimento;
    private String cpf;
    private String endereco;
    private String cartao;
}
