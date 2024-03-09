package Maquinas;

import javax.swing.JOptionPane;

public class Motor {
    // Atributos
    private String modelo; // Ex: V8, elétrico, turbo
    private int potencia; // Em cavalos de potência
    private boolean ligado; // Indica se o motor está ligado ou desligado
    private int quilometragem; // Quilometragem total percorrida pelo motor
    private OleoVeiculo oleoVeiculo;

    // Construtor
    public Motor(String modelo, int potencia){
        this.modelo = modelo;
        this.potencia = potencia;
        this.ligado = false; // Por padrão, o motor começa desligado
        this.quilometragem = 0;
    }

    // Métodos
    public void ligar() {
        if (!ligado) {
            JOptionPane.showMessageDialog(null, "Ligando o Moto: bzbzbzbzbzbz.");
            ligado = true;
            JOptionPane.showMessageDialog(null, "Motor Ligado.");
        } else {
            JOptionPane.showMessageDialog(null, "O motor já está ligado.");
        }
    }

    public void desligar() {
        if (ligado) {
            
            JOptionPane.showMessageDialog(null,"Desligando o motor...");
            JOptionPane.showMessageDialog(null,"Motor Desligado");
            ligado = false;
            this.quilometragem = 0;
        } else {
            JOptionPane.showMessageDialog(null,"O motor já está desligado.");
        }
    }

    public void acelerar() {
        if (ligado) {
            quilometragem += 10; // Simulação de aumento de quilometragem ao acelerar
            JOptionPane.showMessageDialog(null,"Acelerando o motor: ..." + this.quilometragem + "km");
        } else {
            JOptionPane.showMessageDialog(null,"Não é possível acelerar. O motor está desligado.");
        }
    }

    public OleoVeiculo trocarOleo(String tipo , double quantidadeLitros) {
        oleoVeiculo = new OleoVeiculo(tipo, quantidadeLitros);
        return oleoVeiculo;
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    // Método toString para representação de string do objeto
    @Override
    public String toString() {
        if (oleoVeiculo != null) {
            return "\nmodelo:" + modelo + "\npotencia:" + potencia + "\nligado=" + ligado
                + "\nquilometragem:" + quilometragem + " km"+
                "\n"+ oleoVeiculo.toString();
        }
        return "\nmodelo:" + modelo + "\npotencia:" + potencia + "\nligado=" + ligado
                + "\nquilometragem:" + quilometragem + " km";
    }
}
