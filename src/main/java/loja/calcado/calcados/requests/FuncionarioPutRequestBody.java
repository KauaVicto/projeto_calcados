package loja.calcado.calcados.requests;

import lombok.Data;

@Data
public class FuncionarioPutRequestBody {
    private Long id;
    private String name;
    private String telefone;
    private String data_nascimento;
    private String cpf;
    private String rg;
    private String endereco;
    private String email;
    private String carteira_trabalho;
}
