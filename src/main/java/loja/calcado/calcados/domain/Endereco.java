package loja.calcado.calcados.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Endereco {
    private String bairro;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
}
