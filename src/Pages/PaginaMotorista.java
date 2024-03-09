package Pages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Maquinas.Bicicleta;
import Maquinas.Carro;
import Maquinas.Moto;
import funcionarios.Motorista;

public class PaginaMotorista extends JFrame {

    public PaginaMotorista(Motorista motorista, ArrayList<Motorista> motoristas,
            ArrayList<Carro> carros,
            ArrayList<Moto> motos,
            ArrayList<Bicicleta> bicicletas) {

        // String[] cidades = { "Luanda", "Talatona", "Viana", "Cacuaco" };

        // grafo.adicionarCidade("Luanda");
        // grafo.adicionarCidade("Talatona");
        // grafo.adicionarCidade("Viana");
        // grafo.adicionarCidade("Cacuaco");

        // // Adicionar estradas
        // grafo.adicionarEstrada("Luanda", "Talatona", 25);
        // grafo.adicionarEstrada("Luanda", "Cacuaco", 15);
        // grafo.adicionarEstrada("Luanda", "Viana", 20);
        // grafo.adicionarEstrada("Viana", "Cacuaco", 10);
        // grafo.adicionarEstrada("Viana", "Talatona", 10);

        Panel panel = new Panel();
        panel.setBackground(Color.white);
        panel.setSize(1920, 1080);
        panel.setLayout(null);

        ImageIcon iconLogout = new ImageIcon("src/img/icons8-desligar-48.png");
        JLabel logoutIcon = new JLabel(iconLogout);
        logoutIcon.setBounds(1800, 15, 80, 60);
        logoutIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                logout();
            }

        });

        Panel panel2 = new Panel();
        panel2.setBounds(300, 400, 600, 300);
        panel2.setLayout(null);

        JLabel labelNome = new JLabel("Bem-vindo, ".toUpperCase() + motorista.getNome().toUpperCase() + " "
                + motorista.getSobrenome().toUpperCase() + "!");
        labelNome.setFont(new Font("Verdana", Font.BOLD, 20));
        labelNome.setBounds(30, 20, 700, 50);
        panel.add(labelNome);
        panel.add(logoutIcon);

        // JLabel veiculoAConduzir = new JLabel("Escolha o veiculo a conduzir: ");
        // veiculoAConduzir.setBounds(30, 100, 350, 50);
        // veiculoAConduzir.setFont(new Font("Verdana", Font.BOLD, 20));
        // panel2.add(veiculoAConduzir);

        // // veiculosComboBox = new JComboBox<>();
        // // veiculosComboBox.setBounds(370, 110, 350, 30);
        // // panel2.add(veiculosComboBox);

        // JButton selecionarVeiculoButton = new JButton("Selecionar Veículo");
        // selecionarVeiculoButton.setBounds(740, 110, 200, 30);
        // selecionarVeiculoButton.setBackground(new Color(2, 117, 216));
        // selecionarVeiculoButton.setForeground(Color.white);
        // panel2.add(selecionarVeiculoButton);

        ImageIcon BikeIcon = new ImageIcon("src/img/driver.png");
        JLabel BikeJLabel = new JLabel(BikeIcon);
        BikeJLabel.setBounds(1200, 200, 520, 670);
        BikeJLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        add(BikeJLabel);

        // JLabel caminhoMaisProximo = new JLabel("Calcular o caminho mais proximo: ");
        // caminhoMaisProximo.setBounds(30, 200, 390, 50);
        // caminhoMaisProximo.setFont(new Font("Verdana", Font.BOLD, 20));
        // panel2.add(caminhoMaisProximo);

        // JLabel origem = new JLabel("Origem: ");
        // origem.setBounds(30, 300, 100, 50);
        // origem.setFont(new Font("Verdana", Font.BOLD, 20));
        // panel2.add(origem);

        // JComboBox<String> origemComboBox = new JComboBox<>(cidades);
        // origemComboBox.setBounds(130, 313, 170, 25);
        // origemComboBox.setFont(new Font("Verdana", Font.BOLD, 20));
        // panel2.add(origemComboBox);

        // JComboBox<String> destinComboBox = new JComboBox<>(cidades);
        // destinComboBox.setBounds(455, 313, 170, 25);
        // destinComboBox.setFont(new Font("Verdana", Font.BOLD, 20));
        // panel2.add(destinComboBox);

        // JLabel destino = new JLabel("Destino: ");
        // destino.setBounds(350, 300, 150, 50);
        // destino.setFont(new Font("Verdana", Font.BOLD, 20));
        // panel2.add(destino);

        // JButton calcular = new JButton("Calcular");
        // calcular.setBounds(660, 310, 200, 30);
        // calcular.setBorder(null);
        // calcular.setBackground(new Color(2, 117, 216));
        // calcular.setForeground(Color.white);
        // panel2.add(calcular);

        // calcular.addActionListener(e -> {
        // GrafoCidades.CaminhoMaisCurto caminhoMaisCurto = grafo.caminhoMaisCurto(
        // (String) origemComboBox.getSelectedItem(), (String)
        // destinComboBox.getSelectedItem());
        // JOptionPane.showMessageDialog(null, "Caminho mais curto: " +
        // caminhoMaisCurto.getCaminho()
        // + "\nDistância total: " + caminhoMaisCurto.getDistanciaTotal() + " km");
        // });

        JButton botaoLigarMotor = new JButton("Ligar Motor");
        botaoLigarMotor.setBounds(30, 30, 150, 50);
        botaoLigarMotor.setBorder(null);
        botaoLigarMotor.setBackground(new Color(2, 117, 216));
        botaoLigarMotor.setForeground(Color.white);
        panel2.add(botaoLigarMotor);

        JButton botaoDesligarMotor = new JButton("Desligar Motor");
        botaoDesligarMotor.setBounds(210, 130, 150, 50);
        botaoDesligarMotor.setBorder(null);
        botaoDesligarMotor.setBackground(new Color(2, 117, 216));
        botaoDesligarMotor.setForeground(Color.white);
        panel2.add(botaoDesligarMotor);

        JButton acelerarMotor = new JButton("Acelerar Motor");
        acelerarMotor.setBounds(380, 230, 150, 50);
        acelerarMotor.setBorder(null);
        acelerarMotor.setBackground(new Color(2, 117, 216));
        acelerarMotor.setForeground(Color.white);
        panel2.add(acelerarMotor);

        botaoLigarMotor.addActionListener(e -> {
            motorista.iniciarMotor();
        });

        botaoDesligarMotor.addActionListener(e -> {
            motorista.desligarMotor();
        });

        acelerarMotor.addActionListener(e -> {
            motorista.acelerar();
        });

        add(panel2);
        add(panel);

        // JButton selecionarVeiculoButton = new JButton("Selecionar Veículo");
        // selecionarVeiculoButton.setBounds(740, 110, 200, 30);
        // panel.add(selecionarVeiculoButton);

        // selecionarVeiculoButton.addActionListener(e -> {
        // selecionarVeiculo(motorista, carros, motos, bicicletas);
        // });

        setTitle("Pagina Motorista");
        setSize(1920, 1080);
        setResizable(false);

    }

    private void logout() {
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja fazer logout?", "Confirmação de Logout",
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            setVisible(false);
            // Adicione aqui qualquer lógica adicional necessária para o logout
        }
    }

    public void exibirPagina(ArrayList<Carro> carros,
            ArrayList<Moto> motos,
            ArrayList<Bicicleta> bicicletas) {
        setVisible(true);
    }
}

// private void selecionarVeiculo(Motorista motorista, ArrayList<Carro> carros,
// ArrayList<Moto> motos,
// ArrayList<Bicicleta> bicicletas) {
// // Obter o veículo selecionado na JComboBox
// String veiculoSelecionado = ((String)
// veiculosComboBox.getSelectedItem()).split("-> Matricula: ")[1];

// for (Carro carro : carros) {
// if (carro.getMatricula().equals(veiculoSelecionado)) {
// boolean motoristaVerificado = carro.VerificarMotorista();

// if (motoristaVerificado) {
// carro.setMotorista(motorista);
// JOptionPane.showMessageDialog(this, "Veículo selecionado: " +
// veiculoSelecionado);
// } else {
// JOptionPane.showMessageDialog(this,
// "Veículo Já tem motorista: " + " \n ");
// }

// }
// }

// for (Moto moto : motos) {
// if (moto.getMatricula().equals(veiculoSelecionado)) {
// boolean motoristaVerificado = moto.VerificarMotorista();

// if (motoristaVerificado) {
// moto.setMotorista(motorista);
// JOptionPane.showMessageDialog(this, "Veículo selecionado: " +
// veiculoSelecionado);
// } else {
// JOptionPane.showMessageDialog(this,
// "Veículo Já tem motorista: " + " \n " + moto.getMotorista().toString());
// }

// }
// }

// for (Bicicleta bicicleta : bicicletas) {
// if (bicicleta.getMatricula().equals(veiculoSelecionado)) {
// boolean motoristaVerificado = bicicleta.VerificarMotorista();

// if (motoristaVerificado) {
// bicicleta.setMotorista(motorista);
// JOptionPane.showMessageDialog(this, "Veículo selecionado: " +
// veiculoSelecionado);
// } else {
// JOptionPane.showMessageDialog(this,
// "Veículo Já tem motorista: " + " \n " + bicicleta.getMotorista().toString());
// }

// }
// }

// }
// }
