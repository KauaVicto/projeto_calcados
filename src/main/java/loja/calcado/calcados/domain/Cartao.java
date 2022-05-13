package loja.calcado.calcados.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cartao {
    private int id;
    private String numero_cartao;
    private String bandeira;
    private double limite;
    private String tipo; // Débito ou crédito
}
