package Maquinas;

import javax.swing.JOptionPane;

import veiculos.Veiculos;

// Subclasse Bicicleta
public class Bicicleta extends Veiculos {

    // Atributo específico para Bicicleta
    private int numeroMarchas;

    public Bicicleta(String marca, String modelo, String matricula, int ano, Motor motor, Pneu pneu , int numeroMarchar) {
        super(marca, modelo, matricula, ano, motor, pneu);
        this.numeroMarchas = numeroMarchar;
    }
    
    

    

    @Override
    public void AdicionarMotor(Motor motor) {
        super.AdicionarMotor(null);
        JOptionPane.showMessageDialog(null, "Veículo é uma bicicleta, não pode ter motor.");
    }
    @Override
    public String toString() {
        return super.toString() + " Bicicleta{" +
                "numeroMarchas=" + numeroMarchas +
                '}';
    }


    public int getNumeroMarchas() {
        return numeroMarchas;
    }


    public void setNumeroMarchas(int numeroMarchas) {
        this.numeroMarchas = numeroMarchas;
    }
}
