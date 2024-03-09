package Maquinas;

import veiculos.Veiculos;

// Subclasse Carro
public class Carro extends Veiculos {
     // Atributo específico para Carro
    private int numeroPortas;

    public Carro(String marca, String modelo, String matricula, int ano, Motor motor, Pneu pneu , int numeroPortas) {
        super(marca, modelo, matricula, ano, motor, pneu);
        this.numeroPortas = numeroPortas;
        
    }

   

    // Construtor
    

    // Sobrescrita do método toString para incluir atributos específicos de Carro
    @Override
    public String toString() {
        return super.toString() +
                "\nnumeroPortas=" + numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }
}
