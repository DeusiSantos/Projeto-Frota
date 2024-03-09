package Maquinas;

public class Pneu {
    // Atributos
    private String marca;
    private int tamanho; // Exemplo: 16 para um pneu de tamanho 16 polegadas
    private String tipo; // Exemplo: Verão, Inverno, ou outros
    private boolean calibrado;

    // Construtor
    public Pneu(String marca, int tamanho, String tipo) {
        this.marca = marca;
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.calibrado = false;
    }

    // Métodos
    public Boolean calibrar() {
        if (!calibrado) {
            calibrado = true;
            return true;
        } else {
            return false;
        }
    }

    //Gettes e setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pneu \nmarca:" + marca + "\ntamanho:" + tamanho + "\ntipo:" + tipo + "\nClilibração: "+calibrado;
    }
}

