package loja.calcado.calcados.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Funcionario {
    private Long id;
    private String name;
    private String telefone;
    private String data_nascimento;
    private String cpf;
    private String rg;
    private Endereco endereco;
    private String email;
    private String carteira_trabalho;
}
