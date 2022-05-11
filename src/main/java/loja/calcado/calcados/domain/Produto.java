package loja.calcado.calcados.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Produto {
    private Long id;
    private String name;
    private String tipo;
    private String marca;
    private String genero;
    private double preco;
}
