package funcionarios;

import javax.swing.JOptionPane;

import veiculos.Veiculos;

public class Motorista extends Pessoa {
    // Novos atributos específicos para Condutor
    private String numeroCarteira;
    private String tipoMotorista;
    private String email;
    private String senha;
    private Veiculos veiculos;

    // Construtor para a classe Condutor
    public Motorista(String nome, String sobrenome, int idade, String numeroCarteira, String tipoMotorista,
            String email, String senha) {
        // Chama o construtor da classe base (Pessoa)
        super(nome, sobrenome, idade);

        // Inicializa os atributos específicos da classe Condutor
        this.numeroCarteira = numeroCarteira;
        this.tipoMotorista = tipoMotorista;
        this.email = email;
        this.senha = senha;

    }

    // Método toString para representação de string do objeto

    public boolean verificaVeiculo() {
        if (this.veiculos == null) {
            return true;
        } else {
            return false;
        }
    }

    public void iniciarMotor() {
        if (veiculos != null) {
            veiculos.iniciarMotor();;
        } else {
            JOptionPane.showMessageDialog(null, "Veículo sem motor ou motorista sem veículo associado.");
        }
    }

    // Método para desligar o motor do veículo
    public void desligarMotor() {
        if (veiculos != null) {
            veiculos.desligarMotor();
        } else {
            JOptionPane.showMessageDialog(null, "Veículo sem motor ou motorista sem veículo associado.");
        }
    }

    // Método para acelerar o veículo
    public void acelerar() {
        if (veiculos != null) {
            veiculos.acelerar();
        } else {
            JOptionPane.showMessageDialog(null, "Veículo sem motor ou motorista sem veículo associado.");
        }
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(String numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public String getTipoMotorista() {
        return tipoMotorista;
    }

    public void setTipoMotorista(String tipoMotorista) {
        this.tipoMotorista = tipoMotorista;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        String veiculoInfo = (veiculos != null)
                ? "Veiculo: \n marca:" + veiculos.getMarca() + "\n modelo:" + veiculos.getModelo() + "\nmatricula:"
                        + veiculos.getMatricula()
                : "\nVeiculo: Sem veiculo selecionado";

        return super.toString() + "\nNumeroCarteira: " + numeroCarteira + "\nTipoMotorista: " + tipoMotorista + "\n"
                + veiculoInfo;
    }

    public void setVeiculos(Veiculos veiculos) {
        this.veiculos = veiculos;
    }

    public Veiculos getVeiculos() {
        return veiculos;
    }

}
