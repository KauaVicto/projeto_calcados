package loja.calcado.calcados.requests;

import lombok.Data;

@Data
public class ProdutoPostRequestBody {
    private String name;
    private String tipo;
    private String marca;
    private String genero;
    private String img;
    private double preco;
}
