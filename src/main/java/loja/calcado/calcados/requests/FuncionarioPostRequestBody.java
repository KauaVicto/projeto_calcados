package loja.calcado.calcados.requests;

import loja.calcado.calcados.domain.Endereco;
import lombok.Data;

@Data
public class FuncionarioPostRequestBody {
    private String name;
    private String telefone;
    private String data_nascimento;
    private String cpf;
    private String rg;
    private String endereco;
    private String email;
    private String carteira_trabalho;
}
