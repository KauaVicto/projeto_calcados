package loja.calcado.calcados.requests;

import lombok.Data;

@Data
public class ClientePostRequestBody {
    private String name;
    private String telefone;
    private String data_nascimento;
    private String cpf;
    private String endereco;
    private String cartao;
}
