package loja.calcado.calcados.requests;

import lombok.Data;

@Data
public class ProdutoPutRequestBody {
    private Long id;
    private String name;
    private String tipo;
    private String marca;
    private String genero;
    private double preco;
}
