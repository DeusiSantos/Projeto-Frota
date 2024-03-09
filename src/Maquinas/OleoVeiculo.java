package Maquinas;

public class OleoVeiculo {

    // Atributos
    private String tipo;
    private double quantidadeLitros;

    // Construtor
    public OleoVeiculo(String tipo, double quantidadeLitros) {
        this.tipo = tipo;
        this.quantidadeLitros = quantidadeLitros;
    }

    // Getter para tipo
    public String getTipo() {
        return tipo;
    }

    // Setter para tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter para quantidadeLitros
    public double getQuantidadeLitros() {
        return quantidadeLitros;
    }

    // Setter para quantidadeLitros
    public void setQuantidadeLitros(double quantidadeLitros) {
        this.quantidadeLitros = quantidadeLitros;
    }

    @Override
    public String toString() {
        return "Oleo Veiculo: \ntipo=" + tipo + "\nquantidadeLitros=" + quantidadeLitros;
    }

    
}

