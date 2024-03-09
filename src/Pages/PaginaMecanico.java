package Pages;

import java.awt.Color;
import java.awt.Cursor;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.MouseEvent;

import Maquinas.Bicicleta;
import Maquinas.Carro;
import Maquinas.Moto;
import Maquinas.Motor;
import Maquinas.Pneu;
import funcionarios.Mecanico;
import veiculos.Veiculos;

public class PaginaMecanico extends JFrame {

    public PaginaMecanico(Mecanico mecanico, ArrayList<Mecanico> Mecanico, ArrayList<Carro> carros,
            ArrayList<Moto> motos,
            ArrayList<Bicicleta> bicicletas) {

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
            public void mouseClicked(MouseEvent e) {
                logout();
            }

        });

        JLabel labelNome = new JLabel("Bem-vindo, ".toUpperCase() + mecanico.getNome().toUpperCase() + " "
                + mecanico.getSobrenome().toUpperCase() + "!");
        labelNome.setFont(new Font("Verdana", Font.BOLD, 20));
        labelNome.setBounds(30, 20, 700, 50);
        panel.add(labelNome);
        panel.add(logoutIcon);

        Panel panel2 = new Panel();
        panel2.setLayout(null);
        panel2.setSize(500, 500);
        panel2.setBounds(400, 400, 460, 400);


         ImageIcon Icon = new ImageIcon("src/img/repair.png");
        JLabel IconJLabel = new JLabel(Icon);
        IconJLabel.setBounds(1000, 200, 450, 640);

        // Add carro
        ImageIcon carroIcon = new ImageIcon("src/img/car-engine.png");
        JLabel carroIconJLabel = new JLabel(carroIcon);
        carroIconJLabel.setBounds(20, 0, 100, 64);
    

        JButton Motor = new JButton("Motor");
        Motor.setBounds(10, 70, 130, 50);
        Motor.setBorder(null);
        Motor.setBackground(new Color(2, 117, 216));
        Motor.setForeground(Color.white);

        JButton Pneu = new JButton("Pneus");
        Pneu.setBounds(160, 150, 130, 50);
        Pneu.setBorder(null);
        Pneu.setBackground(new Color(217, 83, 79));
        Pneu.setForeground(Color.white);

        JButton Manutencao = new JButton("Manutenção");
        Manutencao.setBounds(310, 230, 130, 50);
        Manutencao.setBorder(null);
        Manutencao.setBackground(new Color(240, 173, 78));
        Manutencao.setForeground(Color.white);

        Motor.addActionListener(e -> {
            gerenciarMotor(carros, motos,bicicletas);
        });

        Pneu.addActionListener(e -> {
            gerirPneus(carros, motos, bicicletas);
        });

        Manutencao.addActionListener(e -> {
            gerirManutencao(carros, motos, bicicletas);
        });

        // Add Moto
        ImageIcon motoIcon = new ImageIcon("src/img/tires.png");
        JLabel motoJLabel = new JLabel(motoIcon);
        motoJLabel.setBounds(160, 85, 100, 64);
        motoJLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        // Add Biscicleta
        ImageIcon BikeIcon = new ImageIcon("src/img/mechanic.png");
        JLabel BikeJLabel = new JLabel(BikeIcon);
        BikeJLabel.setBounds(310, 160, 100, 64);
        BikeJLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        panel2.add(carroIconJLabel);
        panel2.add(Motor);
        panel2.add(Pneu);
        panel2.add(Manutencao);

        panel2.add(motoJLabel);

        panel2.add(motoJLabel);

        panel2.add(BikeJLabel);

        panel.add(panel2);
        panel.add(IconJLabel);
        setTitle("Pagina do Mecanico");
        setResizable(false);
        setSize(1920, 1080);
        add(panel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void ExibirPagina() {
        setVisible(true);
    }

    private void logout() {
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja fazer logout?", "Confirmação de Logout",
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            setVisible(false);
            // Adicione aqui qualquer lógica adicional necessária para o logout
        }
    }

    public void gerenciarMotor(ArrayList<Carro> carros, ArrayList<Moto> motos,ArrayList<Bicicleta> bicicletas) {
        String[] operacoes = { "Adicionar Motor", "Remover Motor", "Verificar" };
        JComboBox<String> operacaoComboBox = new JComboBox<>(operacoes);
        operacaoComboBox.setSelectedIndex(0);

        Object[] message = {
                "Escolha a operação:", operacaoComboBox,
        };

        int resposta = JOptionPane.showConfirmDialog(null, message, "Gerenciar Motor",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.OK_OPTION) {
            String operacaoSelecionada = (String) operacaoComboBox.getSelectedItem();

            // Implemente a lógica para adicionar ou remover o motor com base na operação
            // selecionada e na matrícula
            if (operacaoSelecionada.equals("Adicionar Motor")) {
                adicionarMotor(carros, motos, bicicletas);
            } else if (operacaoSelecionada.equals("Remover Motor")) {
                removerMotor(carros, motos);
            } else if (operacaoSelecionada.equals("Verificar")) {
                VerificarMotor(carros, motos);
            }
        }
    }

    public void adicionarMotor(ArrayList<Carro> carros, ArrayList<Moto> motos,ArrayList<Bicicleta> bicicletas) {
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do veículo:");
        Veiculos veiculo = verificarMatriculaExistente(matricula, carros, motos, bicicletas);

        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
            return;
        }
        if (veiculo instanceof Bicicleta) {
            JOptionPane.showMessageDialog(null, "Não é possível adicionar motor em uma bicicleta.");
            return;
        }

        if (!veiculo.VerificarMotor()) {
            // Se o veículo existir e não tiver motor, continua para adicionar o motor
            JPanel customPanel = new JPanel(new GridLayout(3, 2));
            JTextField marcaField = new JTextField();
            JTextField potenciaField = new JTextField();

            customPanel.add(new JLabel("Marca:"));
            customPanel.add(marcaField);
            customPanel.add(new JLabel("Potência:"));
            customPanel.add(potenciaField);

            int result = JOptionPane.showConfirmDialog(null, customPanel, "Adicionar Motor",
                    JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String marca = marcaField.getText();
                int potencia = Integer.parseInt(potenciaField.getText());

                Motor novoMotor = new Motor(marca, potencia);
                veiculo.AdicionarMotor(novoMotor);
                JOptionPane.showMessageDialog(null, "Motor Adicionado com sucesso");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veículo já possui Motor.");
        }
    }

    public void removerMotor(ArrayList<Carro> carros, ArrayList<Moto> motos) {
        // Solicita a matrícula primeiro
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do veículo:");
        Veiculos veiculo = verificarMatriculaExistente(matricula, carros, motos, null);

        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
            return;
        }

        if (veiculo.VerificarMotor()) {
            veiculo.setMotor(null);
            JOptionPane.showMessageDialog(null, "Motor removido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Veiculo sem motor.");
        }
    }

    public void VerificarMotor(ArrayList<Carro> carros, ArrayList<Moto> motos) {
        // Solicita a matrícula primeiro
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do veículo:");
        Veiculos veiculo = verificarMatriculaExistente(matricula, carros, motos, null);

        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
            return;
        }

        if (veiculo.VerificarMotor()) {
            JOptionPane.showMessageDialog(null, "Veiculo com motor: " + veiculo.getMotor().toString());
        } else {
            JOptionPane.showMessageDialog(null, "Veiculo sem motor");
        }
    }

    public void ManutencaoVeiculo(ArrayList<Carro> carros, ArrayList<Moto> motos) {
        // Solicita a matrícula primeiro
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do veículo:");
        Veiculos veiculo = verificarMatriculaExistente(matricula, carros, motos, null);

        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
            return;
        }

        if (veiculo.VerificarMotor() && veiculo.VerificarPneu()) {
            String tipoOleo = JOptionPane.showInputDialog("Digite o tipo de oleo:");
            String quantidade = JOptionPane.showInputDialog("Digite a quantidade de oleo:");
            Double quantidadeOleo = Double.parseDouble(quantidade);

            veiculo.realizarManutencao(tipoOleo, quantidadeOleo);
            JOptionPane.showMessageDialog(null, "Manutencao Feita");
        } else {
            JOptionPane.showMessageDialog(null, "Veiculo sem motor");
        }
    }

    public void gerirPneus(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        JPanel panel = new JPanel();
        String[] opcoes = { "Adicionar", "Remover", "Verificar" };
        JComboBox<String> comboBox = new JComboBox<>(opcoes);

        Object[] message = {
                "Escolha a ação:", comboBox
        };

        int resposta = JOptionPane.showConfirmDialog(panel, message, "Gerir Pneus", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.OK_OPTION) {
            String escolha = (String) comboBox.getSelectedItem();

            switch (escolha) {
                case "Adicionar":
                    adicionarPneu(carros, motos, bicicletas);
                    break;
                case "Remover":
                    removerPneu(carros, motos, bicicletas);
                    break;
                case "Verificar":
                    verificarPneu(carros, motos, bicicletas);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }

    public void adicionarPneu(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        // Solicita a matrícula primeiro
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do veículo:");
        Veiculos veiculo = verificarMatriculaExistente(matricula, carros, motos, bicicletas);

        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
            return;
        }

        if (!veiculo.VerificarPneu()) {
            // Se o veículo existir, continua para adicionar o pneu
            JPanel customPanel = new JPanel(new GridLayout(3, 2));
            JTextField marcaField = new JTextField();
            JTextField tamanhoField = new JTextField();
            JTextField tipoField = new JTextField();

            customPanel.add(new JLabel("Marca:"));
            customPanel.add(marcaField);
            customPanel.add(new JLabel("Tamanho:"));
            customPanel.add(tamanhoField);
            customPanel.add(new JLabel("Tipo:"));
            customPanel.add(tipoField);

            int result = JOptionPane.showConfirmDialog(null, customPanel, "Adicionar Pneu",
                    JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String marca = marcaField.getText();
                int tamanho = Integer.parseInt(tamanhoField.getText());
                String tipo = tipoField.getText();

                Pneu novoPneu = new Pneu(marca, tamanho, tipo);
                veiculo.AdicionarPneu(novoPneu);
                JOptionPane.showMessageDialog(null, "Pneu Adicionado com sucesso");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veiculo já tem Pneus");
        }
    }

    public void removerPneu(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        // Solicita a matrícula primeiro
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do veículo:");
        Veiculos veiculo = verificarMatriculaExistente(matricula, carros, motos, bicicletas);

        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
            return;
        }

        if (veiculo.VerificarPneu()) {
            veiculo.setPneu(null);
            JOptionPane.showMessageDialog(null, "Pneu removido com sucesso.");
        }else{
            JOptionPane.showMessageDialog(null, "Veiculo sem Pneu");
        }
    }

    public void verificarPneu(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        // Solicita a matrícula primeiro
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do veículo:");
        Veiculos veiculo = verificarMatriculaExistente(matricula, carros, motos, bicicletas);

        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
            return;
        }

        if (veiculo.VerificarPneu()) {
            JOptionPane.showMessageDialog(null, "Veiculo com pneu: " + veiculo.getPneu().toString());
        } else {
            JOptionPane.showMessageDialog(null, "Veiculo sem pneu");
        }
    }

    private Veiculos verificarMatriculaExistente(String matricula, ArrayList<Carro> carros, ArrayList<Moto> motos,
            ArrayList<Bicicleta> bicicletas) {
        for (Veiculos veiculo : carros) {
            if (veiculo.getMatricula().equals(matricula)) {
                return veiculo;
            }
        }
        for (Veiculos veiculo : motos) {
            if (veiculo.getMatricula().equals(matricula)) {
                return veiculo;
            }
        }

        for (Veiculos veiculo : bicicletas) {
            if (veiculo.getMatricula().equals(matricula)) {
                return veiculo;
            }
        }
        return null;
    }

    private void CalibrarPneu(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do veículo:");
        Veiculos veiculo = verificarMatriculaExistente(matricula, carros, motos, bicicletas);

        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
            return;
        }

        if (veiculo.VerificarPneu()) {
            veiculo.getPneu().calibrar();
            JOptionPane.showMessageDialog(null, "Pneu Calibrado.");
        }else{
            JOptionPane.showMessageDialog(null, "Veículo Sem Pneu.");
        }
    }

    private void TrocarOleo(ArrayList<Carro> carros, ArrayList<Moto> motos) {
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do veículo:");
        Veiculos veiculo = verificarMatriculaExistente(matricula, carros, motos, null);

        if (veiculo == null) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
            return;
        }

        if (veiculo.VerificarMotor()) {
            String tipoOleo = JOptionPane.showInputDialog("Digite o tipo de oleo:");
            String quantidade = JOptionPane.showInputDialog("Digite a quantidade de oleo:");
            double quantidadeOleo = Double.parseDouble(quantidade);
            veiculo.trocarOleo(tipoOleo, quantidadeOleo);
            JOptionPane.showMessageDialog(null, "Oleo do motor trocado.");
        }else{
            JOptionPane.showMessageDialog(null, "Veículo Sem motor.");
        }
    }

    public void gerirManutencao(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        String[] opcoes = { "Manutenção Geral", "Trocar Oleo", "Calibrar Pneu" };
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        int resposta = JOptionPane.showConfirmDialog(null, comboBox, "Gerenciar Manutenção",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (resposta == JOptionPane.OK_OPTION) {
            String opcaoSelecionada = (String) comboBox.getSelectedItem();
            switch (opcaoSelecionada) {
                case "Manutenção Geral":
                    ManutencaoVeiculo(carros, motos);
                    break;
                case "Trocar Oleo":
                    TrocarOleo(carros, motos);
                    break;
                case "Calibrar Pneu":
                    CalibrarPneu(carros, motos, bicicletas);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

}