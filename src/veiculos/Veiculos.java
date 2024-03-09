// Classe base Veiculos
package veiculos;

import javax.swing.JOptionPane;

import Maquinas.Motor;
import Maquinas.Pneu;
import funcionarios.Motorista;

public class Veiculos {
    // Atributos
    private String marca;
    private String modelo, matricula;
    private int ano;
    private Motorista motorista; // Atributo de agregação
    private Motor motor;
    private Pneu pneu;

    // Construtor
    public Veiculos(String marca, String modelo, String matricula, int ano , Motor motor , Pneu pneu) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.matricula = matricula;
        this.motor = motor;
        this.pneu = pneu;
    }

    // Métodos

    public void realizarManutencao(String tipo, double quantidadeLitros) {
        motor.trocarOleo(tipo, quantidadeLitros);
        pneu.calibrar();
    }

    public void trocarOleo(String tipo, double quantidadeLitros) {
        motor.trocarOleo(tipo, quantidadeLitros);
    }

    // Método para atribuir um motorista ao veículo
    public void atribuirMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    // Método para exibir informações do veículo com o motorista associado
    public Boolean VerificarMotorista() {
        if (motorista == null) {
            return true;
        } else {
            return false;
        }
    }

    // Motor
    public void AdicionarMotor(Motor motor) {
        if (this.motor == null) {
            this.motor = motor;
        }
    }

    public boolean VerificarMotor() {
        if (motor != null) {
            return true;
        } else {
            return false;
        }
    }

    public void acelerar() {
        motor.acelerar();
    }

    public void iniciarMotor() {
        if (motor != null) {
            motor.ligar();
        } else
            JOptionPane.showMessageDialog(null, "veiculo sem motor");
    }

    public void desligarMotor() {
        if (motor != null) {
            motor.desligar();
            ;
        } else
            JOptionPane.showMessageDialog(null, "veiculo sem motor");
    }

    // Pneu
    public void AdicionarPneu(Pneu pneu) {
        if (this.pneu == null) {
            this.pneu = pneu;
        }
    }

    public boolean VerificarPneu() {
        if (pneu != null) {
            return true;
        } else {
            return false;
        }
    }

    public void calibrar() {
        pneu.calibrar();
    }

    // Sobrescrita do método toString para representação de string do objeto
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("marca: " + marca + '\n' +
                "modelo: " + modelo + '\n' +
                "Matricula:" + matricula + "\n" +
                "ano: " + ano + "\n");

        if (motor != null) {
            result.append("Motor: ").append(motor.toString()).append('\n');
        } else {
            result.append("Motor: Sem Motor\n");
        }

        if (motorista != null) {
            result.append("Motorista: ").append(motorista.toString()).append('\n');
        } else {
            result.append("Motorista: Sem motorista\n");
        }

        if (pneu != null) {
            result.append("Pneu: ").append(pneu.toString()).append('\n');
        } else {
            result.append("Pneu: Sem Pneus\n");
        }

        return result.toString();
    }

    // getters e setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Pneu getPneu() {
        return pneu;
    }

    public void setPneu(Pneu pneu) {
        this.pneu = pneu;
    }
}
