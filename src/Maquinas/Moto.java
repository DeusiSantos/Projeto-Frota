package Maquinas;

import veiculos.Veiculos;

// Subclasse Moto
public class Moto extends Veiculos {
    // Atributo específico para Moto
    private boolean possuiPartidaEletrica;

    // Construtor

    public Moto(String marca, String modelo, String matricula,Motor motor , Pneu pneu, int ano, boolean possuiPartidaEletrica) {
        super(marca, modelo, matricula, ano,motor,pneu);
        this.possuiPartidaEletrica = possuiPartidaEletrica; 
    }

        // Sobrescrita do método toString para incluir atributos específicos de Moto
    @Override
    public String toString() {
        return super.toString() + " Moto{" +
                "possuiPartidaEletrica=" + possuiPartidaEletrica +
                '}';
    }



    public boolean isPossuiPartidaEletrica() {
        return possuiPartidaEletrica;
    }



    public void setPossuiPartidaEletrica(boolean possuiPartidaEletrica) {
        this.possuiPartidaEletrica = possuiPartidaEletrica;
    }
}