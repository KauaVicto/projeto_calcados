package loja.calcado.calcados.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    private Long id;
    private String name;
    private String telefone;
    private String data_nascimento;
    private String cpf;
    private Endereco endereco;
    private Cartao cartao;
}
