package Pages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Maquinas.Bicicleta;
import Maquinas.Carro;
import Maquinas.Moto;
import Maquinas.Motor;
import Maquinas.Pneu;
import funcionarios.Administrador;
import funcionarios.Gestores;
import funcionarios.Mecanico;
import funcionarios.Motorista;
import veiculos.Veiculos;

public class PaginaAdministrador extends JFrame {
    private JTextField email;
    private JLabel usersJLabel,labelNome, carroJLabel, totalVeiculosL, motosJLabel, bicicletLabel, gestores, mecanicos, motoristas,
            total;
    private int totalVeiculos, totalFuncionarios;
    private Panel editarUser;

    private Motor motorCarro = new Motor("Original do veiculo", 100);
    private Motor motorMoto = new Motor("Original da moto", 100);
    private Pneu pneuCarro = new Pneu("Original do Veiculo", 19, "Normal");
    private Pneu pneuMoto = new Pneu("Original do Veiculo", 14, "Normal");
    private Pneu pneuBicicleta = new Pneu("Original do Veiculo", 14, "Normal");

    public PaginaAdministrador(Administrador gerente,ArrayList<Gestores> user, ArrayList<Administrador> Gerentes, ArrayList<Motorista> Motoristas,
            ArrayList<Mecanico> Mecanico, ArrayList<Carro> carros, ArrayList<Moto> motos,
            ArrayList<Bicicleta> bicicletas) {
        setTitle("Pagina do gestor");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

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
                // Adicione aqui o código que deseja executar ao clicar no ícone de logout
                logout();
            }
        });

        labelNome = new JLabel("Bem-vindo, ".toUpperCase() + gerente.getNome().toUpperCase() + " "
                + gerente.getSobrenome().toUpperCase() + "!");
        labelNome.setFont(new Font("Verdana", Font.BOLD, 20));
        labelNome.setBounds(30, 20, 700, 50);
        panel.add(labelNome);
        panel.add(logoutIcon);

        Panel funcionariosPanel = new Panel();
        funcionariosPanel.setBackground(new Color(180, 200, 207));
        funcionariosPanel.setBounds(30, 100, 500, 300);

        funcionariosPanel.setLayout(new BoxLayout(funcionariosPanel, BoxLayout.Y_AXIS));

        ImageIcon iconFuncionarios = new ImageIcon("src/img/teamwork.png");
        JLabel funcionarioIcon = new JLabel(iconFuncionarios);
        funcionarioIcon.setAlignmentX(CENTER_ALIGNMENT);
        funcionarioIcon.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        gestores = new JLabel("Administradores: " + Gerentes.size());
        gestores.setAlignmentX(CENTER_ALIGNMENT);
        gestores.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        gestores.setFont(new Font("Verdana", Font.BOLD, 16));

        usersJLabel = new JLabel("Gestores: " + user.size());
        usersJLabel.setAlignmentX(CENTER_ALIGNMENT);
        usersJLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        usersJLabel.setFont(new Font("Verdana", Font.BOLD, 16));

        mecanicos = new JLabel("Mecânicos: " + Mecanico.size());
        mecanicos.setAlignmentX(CENTER_ALIGNMENT);
        mecanicos.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        mecanicos.setFont(new Font("Verdana", Font.BOLD, 16));
        motoristas = new JLabel("Motoristas: " + Motoristas.size());
        motoristas.setAlignmentX(CENTER_ALIGNMENT);
        motoristas.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        motoristas.setFont(new Font("Verdana", Font.BOLD, 16));
        totalFuncionarios = Gerentes.size() + Mecanico.size() + Motoristas.size()+user.size();
        total = new JLabel("Total: " + totalFuncionarios + " Funcionarios");
        total.setAlignmentX(CENTER_ALIGNMENT);
        total.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        total.setFont(new Font("Verdana", Font.BOLD, 16));

        Panel veiculoPanel = new Panel();
        veiculoPanel.setBackground(new Color(122, 185, 207));
        veiculoPanel.setBounds(560, 100, 500, 300);
        veiculoPanel.setLayout(new BoxLayout(veiculoPanel, BoxLayout.Y_AXIS));
        veiculoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        ImageIcon iconVehicle = new ImageIcon("src/img/vehicles.png");
        JLabel vehicleIcon = new JLabel(iconVehicle);
        vehicleIcon.setAlignmentX(CENTER_ALIGNMENT);
        vehicleIcon.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        carroJLabel = new JLabel("Carros: " + carros.size());
        carroJLabel.setAlignmentX(CENTER_ALIGNMENT);
        carroJLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        carroJLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        motosJLabel = new JLabel("Motos: " + motos.size());
        motosJLabel.setAlignmentX(CENTER_ALIGNMENT);
        motosJLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        motosJLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        bicicletLabel = new JLabel("Bicicletas: " + bicicletas.size());
        bicicletLabel.setAlignmentX(CENTER_ALIGNMENT);
        bicicletLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        bicicletLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        totalVeiculos = carros.size() + motos.size() + bicicletas.size();
        totalVeiculosL = new JLabel("Total: " + totalVeiculos + " Veiculos");
        totalVeiculosL.setAlignmentX(CENTER_ALIGNMENT);
        totalVeiculosL.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        totalVeiculosL.setFont(new Font("Verdana", Font.BOLD, 16));

        editarUser = new Panel();
        editarUser.setLayout(null);
        editarUser.setBounds(1090, 100, 800, 275);
        editarUser.setBackground(new Color(211, 214, 219));

        JButton addGestor = new JButton("Adicionar");
        addGestor.setBounds(10, 200, 130, 50);
        addGestor.setBorder(null);
        addGestor.setBackground(new Color(2, 117, 216));
        addGestor.setForeground(Color.white);

        JButton removeGestor = new JButton("Remover");
        removeGestor.setBounds(160, 200, 130, 50);
        removeGestor.setBorder(null);
        removeGestor.setBackground(new Color(217, 83, 79));
        removeGestor.setForeground(Color.white);

        JButton imprimir = new JButton("Imprimir Dados");
        imprimir.setBounds(310, 200, 130, 50);
        imprimir.setBorder(null);
        imprimir.setBackground(new Color(240, 173, 78));
        imprimir.setForeground(Color.white);

        JButton addVeiculoMotorista = new JButton("Adicinar veiculo ao Motorista");
        addVeiculoMotorista.setBounds(460, 200, 240, 50);
        addVeiculoMotorista.setBorder(null);
        addVeiculoMotorista.setBackground(new Color(240, 173, 78));
        addVeiculoMotorista.setForeground(Color.white);

        addVeiculoMotorista.addActionListener(e -> {
            gerenciarVeiculoMotorista(Motoristas, carros, motos, bicicletas);
        });

        imprimir.addActionListener(e -> {
            imprimirUsuarios(Gerentes, user, Mecanico, Motoristas, carros, motos, bicicletas);
        });

        JLabel JlabelUser = new JLabel("Adicionar ou remover Usuarios");
        JlabelUser.setBounds(10, 150, 400, 50);
        JlabelUser.setFont(new Font("arial", Font.BOLD, 16));
        removeGestor.addActionListener(e -> {
            removerUser(user,Gerentes, Mecanico, Motoristas);
        });

        addGestor.addActionListener(e -> {
            addUser(user,Gerentes, Mecanico, Motoristas);
        });

        // JLabel editLabel = new JLabel("Editar: ");
        // editLabel.setBounds(10, 10, 70, 30);
        // editLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        JLabel JlabelDados = new JLabel("Atualizar Dados dos Usuarios");
        JlabelDados.setBounds(10, 00, 400, 50);
        JlabelDados.setFont(new Font("arial", Font.BOLD, 16));

        JLabel emailLabel = new JLabel("Digite o email do usuario: ");
        emailLabel.setBounds(10, 70, 300, 50);
        emailLabel.setFont(new Font("arial", Font.BOLD, 16));

        email = new JTextField();
        email.setBounds(210, 70, 300, 50);
        email.setFont(new Font("Verdana", Font.BOLD, 12));
        email.setBorder(null);

        JButton buttonVerify = new JButton("Verificar");
        buttonVerify.setBounds(510, 70, 100, 50);
        buttonVerify.setBorder(null);
        buttonVerify.setBackground(new Color(5, 175, 242));
        buttonVerify.setForeground(Color.WHITE);

        buttonVerify.addActionListener(e -> {
            String inputEmail = email.getText().trim();

            if (inputEmail.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha com o teu email.");
            } else {
                verificarConta(email,user, Gerentes, Motoristas, Mecanico);
            }
        });

        Panel veiculos = new Panel();
        veiculos.setLayout(null);
        veiculos.setBounds(30, 425, 500, 350);
        veiculos.setBackground(new Color(211, 214, 219));

        // Add carro
        ImageIcon carroIcon = new ImageIcon("src/img/car (1).png");
        JLabel carroIconJLabel = new JLabel(carroIcon);
        carroIconJLabel.setBounds(10, 0, 100, 64);
        carroIconJLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        JButton addCarro = new JButton("Adicionar");
        addCarro.setBounds(10, 60, 130, 50);
        addCarro.setBorder(null);
        addCarro.setBackground(new Color(2, 117, 216));
        addCarro.setForeground(Color.white);

        JButton removerCarro = new JButton("Remover");
        removerCarro.setBounds(160, 60, 130, 50);
        removerCarro.setBorder(null);
        removerCarro.setBackground(new Color(217, 83, 79));
        removerCarro.setForeground(Color.white);

        JButton editarCarro = new JButton("Editar");
        editarCarro.setBounds(310, 60, 130, 50);
        editarCarro.setBorder(null);
        editarCarro.setBackground(new Color(240, 173, 78));
        editarCarro.setForeground(Color.white);

        addCarro.addActionListener(e -> {
            addCarro(carros, motos, bicicletas);
        });

        removerCarro.addActionListener(e -> {
            removerCarro(carros, motos, bicicletas);
        });

        editarCarro.addActionListener(e -> {
            editarCarro(carros, motos, bicicletas);
        });

        // Add Moto
        ImageIcon motoIcon = new ImageIcon("src/img/bycicle.png");
        JLabel motoJLabel = new JLabel(motoIcon);
        motoJLabel.setBounds(10, 110, 100, 64);
        motoJLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        JButton addMoto = new JButton("Adicionar");
        addMoto.setBounds(10, 170, 130, 50);
        addMoto.setBorder(null);
        addMoto.setBackground(new Color(2, 117, 216));
        addMoto.setForeground(Color.white);

        JButton removerMoto = new JButton("Remover");
        removerMoto.setBounds(160, 170, 130, 50);
        removerMoto.setBorder(null);
        removerMoto.setBackground(new Color(217, 83, 79));
        removerMoto.setForeground(Color.white);

        JButton editarMoto = new JButton("Editar");
        editarMoto.setBounds(310, 170, 130, 50);
        editarMoto.setBorder(null);
        editarMoto.setBackground(new Color(240, 173, 78));
        editarMoto.setForeground(Color.white);

        addMoto.addActionListener(e -> {
            addMoto(motos, carros, bicicletas);
        });

        removerMoto.addActionListener(e -> {
            removerMoto(motos, carros, bicicletas);
        });

        editarMoto.addActionListener(e -> {
            alterarMoto(motos);
        });

        // Add Biscicleta
        ImageIcon BikeIcon = new ImageIcon("src/img/bicycle.png");
        JLabel BikeJLabel = new JLabel(BikeIcon);
        BikeJLabel.setBounds(10, 220, 100, 64);
        BikeJLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        JButton addBiscicleta = new JButton("Adicionar");
        addBiscicleta.setBounds(10, 280, 130, 50);
        addBiscicleta.setBorder(null);
        addBiscicleta.setBackground(new Color(2, 117, 216));
        addBiscicleta.setForeground(Color.white);

        JButton removerBiscicleta = new JButton("Remover");
        removerBiscicleta.setBounds(160, 280, 130, 50);
        removerBiscicleta.setBorder(null);
        removerBiscicleta.setBackground(new Color(217, 83, 79));
        removerBiscicleta.setForeground(Color.white);

        JButton editarBiscicleta = new JButton("Editar");
        editarBiscicleta.setBounds(310, 280, 130, 50);
        editarBiscicleta.setBorder(null);
        editarBiscicleta.setBackground(new Color(240, 173, 78));
        editarBiscicleta.setForeground(Color.white);

        addBiscicleta.addActionListener(e -> {
            addBicicleta(carros, motos, bicicletas);
        });

        removerBiscicleta.addActionListener(e -> {
            removerBicicleta(carros, motos, bicicletas);
        });

        editarBiscicleta.addActionListener(e -> {
            editarBicicleta(carros, motos, bicicletas);
        });

        // String[] opcoes = {"Gestores", "Mecânicos","Motoristas"};
        // JComboBox<String> selectUsarBox = new JComboBox<>(opcoes);
        // selectUsarBox.setBounds(80, 10, 300, 30);

        funcionariosPanel.add(funcionarioIcon);
        funcionariosPanel.add(gestores);
        funcionariosPanel.add(usersJLabel);
        funcionariosPanel.add(mecanicos);
        funcionariosPanel.add(motoristas);
        funcionariosPanel.add(total);

        veiculoPanel.add(vehicleIcon);
        veiculoPanel.add(carroJLabel);
        veiculoPanel.add(motosJLabel);
        veiculoPanel.add(bicicletLabel);
        veiculoPanel.add(totalVeiculosL);

        panel.add(funcionariosPanel);
        panel.add(veiculoPanel);
        panel.add(editarUser);
        panel.add(veiculos);
        // editarUser.add(selectUsarBox);
        // editarUser.add(editLabel);
        editarUser.add(emailLabel);
        editarUser.add(email);
        editarUser.add(buttonVerify);
        editarUser.add(addGestor);
        editarUser.add(removeGestor);
        editarUser.add(JlabelDados);
        editarUser.add(JlabelUser);
        editarUser.add(imprimir);
        editarUser.add(addVeiculoMotorista);

        veiculos.add(carroIconJLabel);
        veiculos.add(addCarro);
        veiculos.add(removerCarro);
        veiculos.add(editarCarro);

        veiculos.add(motoJLabel);
        veiculos.add(addMoto);
        veiculos.add(removerMoto);
        veiculos.add(editarMoto);

        veiculos.add(BikeJLabel);
        veiculos.add(addBiscicleta);
        veiculos.add(removerBiscicleta);
        veiculos.add(editarBiscicleta);

        add(panel);
    }

    private void addUser(ArrayList<Gestores> user,ArrayList<Administrador> gestores, ArrayList<Mecanico> mecanicos,
            ArrayList<Motorista> motoristas) {
        JPanel panel = new JPanel();
        String[] tiposUsuarios = { "Gestor","Administrador", "Mecânico", "Motorista" };
        JComboBox<String> tipoUsuarioComboBox = new JComboBox<>(tiposUsuarios);
        tipoUsuarioComboBox.setSelectedIndex(0);

        Object[] message = { "Escolha o tipo de usuário:", tipoUsuarioComboBox };
        int resposta = JOptionPane.showConfirmDialog(panel, message, "Adicionar Usuário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.OK_OPTION) {
            String tipoUsuarioSelecionado = (String) tipoUsuarioComboBox.getSelectedItem();

            // Cria um painel personalizado para coletar informações do usuário
            JPanel customPanel = new JPanel();
            customPanel.setLayout(new BoxLayout(customPanel, BoxLayout.Y_AXIS));

            JTextField nomeField = new JTextField(15);
            JTextField sobrenomeField = new JTextField(15);
            JTextField idadeField = new JTextField(15);
            JTextField emailField = new JTextField(15);
            JPasswordField senhaField = new JPasswordField(15);

            customPanel.add(new JLabel("Nome:"));
            customPanel.add(nomeField);
            customPanel.add(new JLabel("Sobrenome:"));
            customPanel.add(sobrenomeField);
            customPanel.add(new JLabel("Idade:"));
            customPanel.add(idadeField);
            customPanel.add(new JLabel("Email:"));
            customPanel.add(emailField);
            customPanel.add(new JLabel("Senha:"));
            customPanel.add(senhaField);

            switch (tipoUsuarioSelecionado) {
                case "Administrador":
                    // Adiciona um novo gestor à lista
                    int resultGestor = JOptionPane.showConfirmDialog(null, customPanel, "Informações do Gestor",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (resultGestor == JOptionPane.OK_OPTION) {
                        String nome = nomeField.getText();
                        String sobrenome = sobrenomeField.getText();
                        int idade = Integer.parseInt(idadeField.getText());
                        String email = emailField.getText();
                        char[] senhaChars = senhaField.getPassword();
                        String senha = new String(senhaChars);

                        // Verifica se o e-mail já pertence a alguma conta
                        if (verificarEmailExistente(email,user, gestores, motoristas, mecanicos)) {
                            JOptionPane.showMessageDialog(null, "E-mail já cadastrado. Por favor, escolha outro.");
                            return;
                        }

                        Administrador novoGestor = new Administrador(nome, sobrenome, idade, email, senha);
                        gestores.add(novoGestor);

                        // Exibe uma mensagem informando que o gestor foi adicionado com sucesso
                        JOptionPane.showMessageDialog(panel, "Administrador adicionado com sucesso!");

                        // Atualiza a label com o novo número de gestores
                        atualizarLabelsFuncionarios(user,gestores, motoristas, mecanicos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação Cancelada");
                    }
                    break;

                case "Mecânico":
                    // Adiciona um novo mecânico à lista
                    String especialidade = JOptionPane.showInputDialog(customPanel, "Especialidade:");
                    int resultMecanico = JOptionPane.showConfirmDialog(null, customPanel, "Informações do Mecânico",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (resultMecanico == JOptionPane.OK_OPTION) {
                        String nome = nomeField.getText();
                        String sobrenome = sobrenomeField.getText();
                        int idade = Integer.parseInt(idadeField.getText());
                        String email = emailField.getText();
                        char[] senhaChars = senhaField.getPassword();
                        String senha = new String(senhaChars);

                        if (verificarEmailExistente(email,user, gestores, motoristas, mecanicos)) {
                            JOptionPane.showMessageDialog(null, "E-mail já cadastrado. Por favor, escolha outro.");
                            return;
                        }

                        Mecanico novoMecanico = new Mecanico(nome, sobrenome, idade, email, senha, especialidade);
                        mecanicos.add(novoMecanico);

                        // Exibe uma mensagem informando que o mecânico foi adicionado com sucesso
                        JOptionPane.showMessageDialog(panel, "Mecânico adicionado com sucesso!");

                        // Atualiza a label com o novo número de mecânicos
                        atualizarLabelsFuncionarios(user,gestores, motoristas, mecanicos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação Cancelada");
                    }
                    break;

                case "Motorista":
                    // Adiciona um novo motorista à lista
                    JTextField numeroCarteiraField = new JTextField(15);

                    // Adicionando radio buttons para o tipo de motorista
                    JRadioButton amadorRadioButton = new JRadioButton("Amador");
                    JRadioButton profissionalRadioButton = new JRadioButton("Profissional");

                    // Cria um grupo para os radio buttons
                    ButtonGroup tipoMotoristaGroup = new ButtonGroup();
                    tipoMotoristaGroup.add(amadorRadioButton);
                    tipoMotoristaGroup.add(profissionalRadioButton);

                    customPanel.add(new JLabel("Número da Carteira:"));
                    customPanel.add(numeroCarteiraField);
                    customPanel.add(new JLabel("Tipo de Motorista:"));
                    customPanel.add(amadorRadioButton);
                    customPanel.add(profissionalRadioButton);

                    int resultMotorista = JOptionPane.showConfirmDialog(null, customPanel, "Informações do Motorista",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (resultMotorista == JOptionPane.OK_OPTION) {
                        String nome = nomeField.getText();
                        String sobrenome = sobrenomeField.getText();
                        int idade = Integer.parseInt(idadeField.getText());
                        String email = emailField.getText();
                        char[] senhaChars = senhaField.getPassword();
                        String senha = new String(senhaChars);
                        String numeroCarteira = numeroCarteiraField.getText().trim();

                        // Verifica se o número da carteira já pertence a algum motorista
                        if (verificarNumeroCarteiraExistente(numeroCarteira, motoristas)) {
                            JOptionPane.showMessageDialog(null,
                                    "Número da Carteira já cadastrado. Por favor, escolha outro.");
                            return;
                        }

                        // Obtém o tipo de motorista selecionado
                        String tipoMotorista = amadorRadioButton.isSelected() ? "Amador" : "Profissional";

                        Motorista novoMotorista = new Motorista(nome, sobrenome, idade, numeroCarteira, tipoMotorista,
                                email, senha);
                        motoristas.add(novoMotorista);

                        // Exibe uma mensagem informando que o motorista foi adicionado com sucesso
                        JOptionPane.showMessageDialog(panel, "Motorista adicionado com sucesso!");

                        // Atualiza a label com o novo número de motoristas
                        atualizarLabelsFuncionarios(user,gestores, motoristas, mecanicos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação Cancelada");
                    }
                    break;

                    case "Gestor":
                    // Adiciona um novo gestor à lista
                    int resultUser = JOptionPane.showConfirmDialog(null, customPanel, "Informações do Gestor",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (resultUser == JOptionPane.OK_OPTION) {
                        String nome = nomeField.getText();
                        String sobrenome = sobrenomeField.getText();
                        int idade = Integer.parseInt(idadeField.getText());
                        String email = emailField.getText();
                        char[] senhaChars = senhaField.getPassword();
                        String senha = new String(senhaChars);

                        // Verifica se o e-mail já pertence a alguma conta
                        if (verificarEmailExistente(email,user, gestores, motoristas, mecanicos)) {
                            JOptionPane.showMessageDialog(null, "E-mail já cadastrado. Por favor, escolha outro.");
                            return;
                        }

                        Gestores novoGestor = new Gestores(nome, sobrenome, idade, email, senha);
                        user.add(novoGestor);

                        // Exibe uma mensagem informando que o gestor foi adicionado com sucesso
                        JOptionPane.showMessageDialog(panel, "Gestor adicionado com sucesso!");

                        // Atualiza a label com o novo número de gestores
                        atualizarLabelsFuncionarios(user,gestores, motoristas, mecanicos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação Cancelada");
                    }
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    private void removerUser(ArrayList<Gestores> users ,ArrayList<Administrador> gestores, ArrayList<Mecanico> mecanicos,
            ArrayList<Motorista> motoristas) {
        JPanel panel = new JPanel();
        String[] tiposUsuarios = { "Administrador", "Gestor","Mecânico", "Motorista" };
        JComboBox<String> tipoUsuarioComboBox = new JComboBox<>(tiposUsuarios);
        tipoUsuarioComboBox.setSelectedIndex(0);

        Object[] message = { "Escolha o tipo de usuário:", tipoUsuarioComboBox };
        int resposta = JOptionPane.showConfirmDialog(panel, message, "Remover Usuário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.OK_OPTION) {
            String tipoUsuarioSelecionado = (String) tipoUsuarioComboBox.getSelectedItem();

            // Cria um painel personalizado para coletar informações do usuário
            JPanel customPanel = new JPanel();
            customPanel.setLayout(new BoxLayout(customPanel, BoxLayout.Y_AXIS));

            JTextField emailField = new JTextField(15);

            customPanel.add(new JLabel("Email:"));
            customPanel.add(emailField);

            int result = JOptionPane.showConfirmDialog(null, customPanel, "Remover Usuário",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String email = emailField.getText().trim();

                // Verifica se o e-mail já pertence a alguma conta
                if (verificarEmailExistente(email,users, gestores, motoristas, mecanicos)) {
                    int confirmacao = JOptionPane.showConfirmDialog(null,
                            "Tem certeza que deseja remover o usuário com o email: " + email,
                            "Confirmação de Remoção", JOptionPane.YES_NO_OPTION);

                    if (confirmacao == JOptionPane.YES_OPTION) {
                        // Tenta encontrar e remover o usuário pelo e-mail
                        switch (tipoUsuarioSelecionado) {
                            case "Administrador":
                                Administrador gestorRemover = gestores.stream()
                                        .filter(g -> g.getEmail().equals(email))
                                        .findFirst().orElse(null);

                                if (gestorRemover != null) {
                                    gestores.remove(gestorRemover);
                                    JOptionPane.showMessageDialog(null, "Administrador removido com sucesso!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Erro ao remover o Administrador. Administrador não encontrado.");
                                }
                                break;

                            case "Mecânico":
                                Mecanico mecanicoRemover = mecanicos.stream()
                                        .filter(m -> m.getEmail().equals(email))
                                        .findFirst().orElse(null);

                                if (mecanicoRemover != null) {
                                    mecanicos.remove(mecanicoRemover);
                                    JOptionPane.showMessageDialog(null, "Mecânico removido com sucesso!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Erro ao remover o mecânico. Mecânico não encontrado.");
                                }
                                break;

                                case "Gestor":
                                Gestores userRemover = users.stream()
                                        .filter(g -> g.getEmail().equals(email))
                                        .findFirst().orElse(null);

                                if (userRemover != null) {
                                    users.remove(userRemover);
                                    JOptionPane.showMessageDialog(null, "Gestor removido com sucesso!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Erro ao remover o gestor. Gestor não encontrado.");
                                }
                                break;

                            case "Motorista":
                                Motorista motoristaRemover = motoristas.stream()
                                        .filter(m -> m.getEmail().equals(email))
                                        .findFirst().orElse(null);

                                if (motoristaRemover != null) {
                                    motoristas.remove(motoristaRemover);
                                    JOptionPane.showMessageDialog(null, "Motorista removido com sucesso!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Erro ao remover o motorista. Motorista não encontrado.");
                                }
                                break;
                        }

                        // Atualiza a label com o novo número de usuários
                        atualizarLabelsFuncionarios(users,gestores, motoristas, mecanicos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação Cancelada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Conta não existe!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operação Cancelada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    public void exibirPagina() {
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

    private void verificarConta(JTextField inputEmail,ArrayList<Gestores> users, ArrayList<Administrador> Gerentes,
            ArrayList<Motorista> Motoristas, ArrayList<Mecanico> Mecanicos) {
        String email = inputEmail.getText().trim();
        boolean encontrado = false;
        for (Administrador Administrador : Gerentes) {
            if (Administrador.getEmail().equals(email)) {
                encontrado = true;
                exibirJanelaAlteracao(email,users, Gerentes, Mecanicos, Motoristas);
                break;
            }
        }
        for (Motorista motorista : Motoristas) {
            if (motorista.getEmail().equals(email)) {
                encontrado = true;
                exibirJanelaAlteracao(email, users,Gerentes, Mecanicos, Motoristas);

                break;
            }
        }

        for (Mecanico mecanico : Mecanicos) {
            if (mecanico.getEmail().equals(email)) {
                encontrado = true;
                exibirJanelaAlteracao(email,users, Gerentes, Mecanicos, Motoristas);

                break;
            }
        }
        for (Gestores user : users) {
            if (user.getEmail().equals(email)) {
                encontrado = true;
                exibirJanelaAlteracao(email, users,Gerentes, Mecanicos, Motoristas);

                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Conta não Existe");
        }
    }

    private void exibirJanelaAlteracao(String email,ArrayList<Gestores> users, ArrayList<Administrador> Gerentes, ArrayList<Mecanico> mecanicos,
            ArrayList<Motorista> motoristas) {
        for (Administrador usuario : Gerentes) {
            JPanel panel = new JPanel();
            if (usuario.getEmail().equals(email)) {
                int resposta = JOptionPane.showConfirmDialog(panel,
                        "Dados do Usuario:\nnome: " + usuario.getNome() + "\nSobrenome: " + usuario.getSobrenome()
                                + "\n Idade: " + usuario.getIdade() + "\n" + "Deseja Atualizar ?",
                        "Encontrado", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (resposta == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(panel, "Cancelado!");
                    break;
                } else {
                    String novoNome = JOptionPane.showInputDialog(panel, "Novo Nome:");
                    String novoSobrenome = JOptionPane.showInputDialog(panel, "Novo Sobrenome:");

                    JPasswordField senhaField = new JPasswordField();
                    int option = JOptionPane.showOptionDialog(panel, senhaField, "Nova Senha:",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                    if (option == JOptionPane.OK_OPTION) {
                        char[] senhaChars = senhaField.getPassword();
                        String novaSenha = new String(senhaChars);

                        if (!novaSenha.isEmpty()) {
                            // Se o usuário pressionou OK e forneceu uma senha não vazia
                            // Atualize as informações do usuário
                            usuario.setNome(novoNome);
                            usuario.setSobrenome(novoSobrenome);
                            usuario.setSenha(novaSenha);

                            JOptionPane.showMessageDialog(panel, "Informações atualizadas com sucesso!");
                            break;
                        } else {
                            // Senha vazia
                            JOptionPane.showMessageDialog(panel, "A senha não pode estar vazia.", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }

            }
        }

        for (Mecanico usuario : mecanicos) {
            JPanel panel = new JPanel();
            if (usuario.getEmail().equals(email)) {
                int resposta = JOptionPane.showConfirmDialog(panel,
                        "Dados do Usuario:\nnome: " + usuario.getNome() + "\nSobrenome: " + usuario.getSobrenome()
                                + "\n Idade: " + usuario.getIdade() + "\n" + "Especialidade: "
                                + usuario.getEspecialidade() + "\n" + "Deseja Atualizar ?",
                        "Erro", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (resposta == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(panel, "Cancelado!");
                    break;
                } else {
                    String novoNome = JOptionPane.showInputDialog(panel, "Novo Nome:");
                    String novoSobrenome = JOptionPane.showInputDialog(panel, "Novo Sobrenome:");

                    JPasswordField senhaField = new JPasswordField();
                    int option = JOptionPane.showOptionDialog(panel, senhaField, "Nova Senha:",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                    if (option == JOptionPane.OK_OPTION) {
                        char[] senhaChars = senhaField.getPassword();
                        String novaSenha = new String(senhaChars);

                        if (!novaSenha.isEmpty()) {
                            // Se o usuário pressionou OK e forneceu uma senha não vazia
                            // Atualize as informações do usuário
                            usuario.setNome(novoNome);
                            usuario.setSobrenome(novoSobrenome);
                            usuario.setSenha(novaSenha);

                            JOptionPane.showMessageDialog(panel, "Informações atualizadas com sucesso!");
                            break;
                        } else {
                            // Senha vazia
                            JOptionPane.showMessageDialog(panel, "A senha não pode estar vazia.", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }

            }
        }

        for (Motorista usuario : motoristas) {
            JPanel panel = new JPanel();
            if (usuario.getEmail().equals(email)) {
                int resposta = JOptionPane.showConfirmDialog(panel,
                        "Dados do Usuario:\nnome: " + usuario.getNome() + "\nSobrenome: " + usuario.getSobrenome()
                                + "\n Idade: " + usuario.getIdade() + "\n" + "Numero Carteira: "
                                + usuario.getNumeroCarteira() + "\n" + "Tipo: " + usuario.getTipoMotorista() + "\n"
                                + "Deseja Atualizar ?",
                        "Erro", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (resposta == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(panel, "Cancelado!");
                    break;
                } else {
                    String novoNome = JOptionPane.showInputDialog(panel, "Novo Nome:");
                    String novoSobrenome = JOptionPane.showInputDialog(panel, "Novo Sobrenome:");

                    JPasswordField senhaField = new JPasswordField();
                    int option = JOptionPane.showOptionDialog(panel, senhaField, "Nova Senha:",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                    if (option == JOptionPane.OK_OPTION) {
                        char[] senhaChars = senhaField.getPassword();
                        String novaSenha = new String(senhaChars);

                        if (!novaSenha.isEmpty()) {
                            // Se o usuário pressionou OK e forneceu uma senha não vazia
                            // Atualize as informações do usuário
                            usuario.setNome(novoNome);
                            usuario.setSobrenome(novoSobrenome);
                            usuario.setSenha(novaSenha);

                            JOptionPane.showMessageDialog(panel, "Informações atualizadas com sucesso!");
                            break;
                        } else {
                            // Senha vazia
                            JOptionPane.showMessageDialog(panel, "A senha não pode estar vazia.", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }

            }
        }

        for (Gestores usuario : users) {
            JPanel panel = new JPanel();
            if (usuario.getEmail().equals(email)) {
                int resposta = JOptionPane.showConfirmDialog(panel,
                        "Dados do Usuario:\nnome: " + usuario.getNome() + "\nSobrenome: " + usuario.getSobrenome()
                                + "\n Idade: " + usuario.getIdade() + "\n" + "Deseja Atualizar ?",
                        "Encontrado", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                if (resposta == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(panel, "Cancelado!");
                    break;
                } else {
                    String novoNome = JOptionPane.showInputDialog(panel, "Novo Nome:");
                    String novoSobrenome = JOptionPane.showInputDialog(panel, "Novo Sobrenome:");

                    JPasswordField senhaField = new JPasswordField();
                    int option = JOptionPane.showOptionDialog(panel, senhaField, "Nova Senha:",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                    if (option == JOptionPane.OK_OPTION) {
                        char[] senhaChars = senhaField.getPassword();
                        String novaSenha = new String(senhaChars);

                        if (!novaSenha.isEmpty()) {
                            // Se o usuário pressionou OK e forneceu uma senha não vazia
                            // Atualize as informações do usuário
                            usuario.setNome(novoNome);
                            usuario.setSobrenome(novoSobrenome);
                            usuario.setSenha(novaSenha);

                            JOptionPane.showMessageDialog(panel, "Informações atualizadas com sucesso!");
                            break;
                        } else {
                            // Senha vazia
                            JOptionPane.showMessageDialog(panel, "A senha não pode estar vazia.", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }

            }
        }

    }

    private void addCarro(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        JPanel panel = new JPanel();
        int resposta = JOptionPane.showConfirmDialog(panel,
                "Deseja Adicionar um carro?", "Adicionar Carro", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            // Cria um painel personalizado para coletar informações do carro
            JPanel customPanel = new JPanel();
            customPanel.setLayout(new GridLayout(5, 2)); // Ajuste o número de linhas e colunas conforme necessário

            JTextField marcaField = new JTextField();
            JTextField modeloField = new JTextField();
            JTextField matriculaField = new JTextField();
            JTextField anoField = new JTextField();
            JTextField numeroPortasField = new JTextField();

            customPanel.add(new JLabel("Marca:"));
            customPanel.add(marcaField);
            customPanel.add(new JLabel("Modelo:"));
            customPanel.add(modeloField);
            customPanel.add(new JLabel("Matrícula:"));
            customPanel.add(matriculaField);
            customPanel.add(new JLabel("Ano:"));
            customPanel.add(anoField);
            customPanel.add(new JLabel("Número de Portas:"));
            customPanel.add(numeroPortasField);

            int result = JOptionPane.showConfirmDialog(null, customPanel,
                    "Informações do Carro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                // Processa os dados fornecidos pelo usuário
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                String matriculaString = matriculaField.getText();
                int ano = Integer.parseInt(anoField.getText());
                int numeroPortas = Integer.parseInt(numeroPortasField.getText());

                // Verifica se a matrícula já existe na lista de carros
                if (verificarMatriculaExistente(matriculaString, carros, motos, bicicletas)) {
                    JOptionPane.showMessageDialog(null, "Já existe um carro com essa matrícula.");
                } else {
                    // Adiciona um novo carro à lista
                    Carro novoCarro = new Carro(marca, modelo, matriculaString, ano,motorCarro,pneuCarro,numeroPortas);
                    carros.add(novoCarro);

                    // Exibe uma mensagem informando que o carro foi adicionado com sucesso
                    JOptionPane.showMessageDialog(panel, "Carro adicionado com sucesso!");

                    // Atualiza a label com o novo número de carros
                    carroJLabel.setText("Carros: " + carros.size());

                    // Atualiza a label com o novo total de veículos
                    int totalVeiculos = carros.size() + motos.size() + bicicletas.size();
                    totalVeiculosL.setText("Total: " + totalVeiculos + " Veículos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operação Cancelada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    private void removerCarro(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        if (carros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de carros está vazia.");
            return;
        }

        JPanel panel = new JPanel();
        int resposta = JOptionPane.showConfirmDialog(panel,
                "Deseja Eliminar um carro?", "Remover", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            String matricula = JOptionPane.showInputDialog(panel, "Matrícula do Veículo a remover:");

            boolean encontrado = false;

            // Copia a lista para evitar ConcurrentModificationException
            List<Carro> copiaCarros = new ArrayList<>(carros);

            for (Carro carro : copiaCarros) {
                if (carro.getMatricula().equals(matricula)) {
                    carros.remove(carro);
                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "Carro eliminado");
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Carro não encontrado");
            }

            carroJLabel.setText("Carros: " + carros.size());
            int totalVeiculos = carros.size() + motos.size() + bicicletas.size();
            totalVeiculosL.setText("Total: " + totalVeiculos + " Veículos");

        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    private void editarCarro(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        if (carros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de carros está vazia.");
            return;
        }

        JPanel panel = new JPanel();
        int resposta = JOptionPane.showConfirmDialog(panel,
                "Deseja editar um carro?", "Editar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            String matricula = JOptionPane.showInputDialog(panel, "Matrícula do Veículo a editar:");

            // Verifica se a matrícula já existe na lista de carros
            Carro carroParaEditar = encontrarCarroPorMatricula(matricula, carros);

            if (carroParaEditar != null) {
                JPanel customPanel = criarPainelEdicaoCarro(carroParaEditar);

                int result = JOptionPane.showConfirmDialog(null, customPanel,
                        "Editar Informações do Carro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    // Atualiza as informações do carro com base nos campos do painel
                    carroParaEditar.setMarca(((JTextField) customPanel.getComponent(1)).getText());
                    carroParaEditar.setModelo(((JTextField) customPanel.getComponent(3)).getText());
                    carroParaEditar.setMatricula(((JTextField) customPanel.getComponent(5)).getText());
                    carroParaEditar.setAno(Integer.parseInt(((JTextField) customPanel.getComponent(7)).getText()));
                    carroParaEditar
                            .setNumeroPortas(Integer.parseInt(((JTextField) customPanel.getComponent(9)).getText()));

                    JOptionPane.showMessageDialog(null, "Carro editado com sucesso!");

                    // Atualiza as labels com o novo número de carros e o novo total de veículos
                    atualizarLabels(carros, motos, bicicletas);
                } else {
                    JOptionPane.showMessageDialog(null, "Operação Cancelada");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Carro não encontrado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    // Encontra um carro por matrícula na lista de carros
    private Carro encontrarCarroPorMatricula(String matricula, ArrayList<Carro> carros) {
        for (Carro carro : carros) {
            if (carro.getMatricula().equals(matricula)) {
                return carro;
            }
        }
        return null; // Carro não encontrado
    }

    // Cria um painel para editar as informações do carro
    private JPanel criarPainelEdicaoCarro(Carro carro) {
        JPanel customPanel = new JPanel();
        customPanel.setLayout(new GridLayout(5, 2));

        JTextField marcaField = new JTextField(carro.getMarca());
        JTextField modeloField = new JTextField(carro.getModelo());
        JTextField matriculaField = new JTextField(carro.getMatricula());
        JTextField anoField = new JTextField(String.valueOf(carro.getAno()));
        JTextField numeroPortasField = new JTextField(String.valueOf(carro.getNumeroPortas()));

        customPanel.add(new JLabel("Marca:"));
        customPanel.add(marcaField);
        customPanel.add(new JLabel("Modelo:"));
        customPanel.add(modeloField);
        customPanel.add(new JLabel("Matrícula:"));
        customPanel.add(matriculaField);
        customPanel.add(new JLabel("Ano:"));
        customPanel.add(anoField);
        customPanel.add(new JLabel("Número de Portas:"));
        customPanel.add(numeroPortasField);

        return customPanel;
    }

    // Motos

    private void addMoto(ArrayList<Moto> motos, ArrayList<Carro> carros, ArrayList<Bicicleta> bicicletas) {
        JPanel panel = new JPanel();
        int resposta = JOptionPane.showConfirmDialog(panel,
                "Deseja Adicionar uma moto?", "Adicionar Moto", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            // Cria um painel personalizado para coletar informações da moto
            JPanel customPanel = new JPanel();
            customPanel.setLayout(new GridLayout(6, 2)); // Ajuste o número de linhas e colunas conforme necessário

            JTextField marcaField = new JTextField();
            JTextField modeloField = new JTextField();
            JTextField matriculaField = new JTextField();
            JTextField anoField = new JTextField();
            JCheckBox partidaEletricaCheckbox = new JCheckBox("Possui Partida Elétrica");

            customPanel.add(new JLabel("Marca:"));
            customPanel.add(marcaField);
            customPanel.add(new JLabel("Modelo:"));
            customPanel.add(modeloField);
            customPanel.add(new JLabel("Matrícula:"));
            customPanel.add(matriculaField);
            customPanel.add(new JLabel("Ano:"));
            customPanel.add(anoField);
            customPanel.add(new JLabel("Partida Elétrica:"));
            customPanel.add(partidaEletricaCheckbox);

            int result = JOptionPane.showConfirmDialog(null, customPanel,
                    "Informações da Moto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                // Processa os dados fornecidos pelo usuário
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                String matricula = matriculaField.getText();
                int ano = Integer.parseInt(anoField.getText());
                boolean possuiPartidaEletrica = partidaEletricaCheckbox.isSelected();

                // Verifica se a matrícula já existe na lista de veículos
                if (verificarMatriculaExistente(matricula, carros, motos, bicicletas)) {
                    JOptionPane.showMessageDialog(panel, "Matrícula já existe na lista.");
                } else {
                    // Adiciona uma nova moto à lista
                    Moto novaMoto = new Moto(marca, modelo, matricula,motorMoto,pneuMoto, ano, possuiPartidaEletrica);
                    motos.add(novaMoto);
                    atualizarLabels(carros, motos, bicicletas);
                    // Exibe uma mensagem informando que a moto foi adicionada com sucesso
                    JOptionPane.showMessageDialog(panel, "Moto adicionada com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operação Cancelada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    private void removerMoto(ArrayList<Moto> motos, ArrayList<Carro> carros, ArrayList<Bicicleta> bicicletas) {
        if (motos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de motos está vazia.");
            return;
        }

        JPanel panel = new JPanel();
        int resposta = JOptionPane.showConfirmDialog(panel,
                "Deseja Remover uma moto?", "Remover Moto", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            String matricula = JOptionPane.showInputDialog(panel, "Matrícula da Moto a remover:");

            boolean encontrado = false;

            for (Moto moto : motos) {
                if (moto.getMatricula().equals(matricula)) {
                    motos.remove(moto);
                    JOptionPane.showMessageDialog(null, "Moto removida com sucesso!");
                    encontrado = true;
                    atualizarLabels(carros, motos, bicicletas);
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Moto não encontrada na lista.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    private void alterarMoto(ArrayList<Moto> motos) {
        if (motos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de motos está vazia.");
            return;
        }

        JPanel panel = new JPanel();
        int resposta = JOptionPane.showConfirmDialog(panel,
                "Deseja Alterar uma moto?", "Alterar Moto", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            String matricula = JOptionPane.showInputDialog(panel, "Matrícula da Moto a alterar:");

            boolean encontrado = false;
            JPanel customPanel = new JPanel();
            customPanel.setLayout(new GridLayout(5, 2)); // Ajuste o número de linhas e colunas conforme necessário

            JTextField marcaField = new JTextField();
            JTextField modeloField = new JTextField();
            JTextField matriculaField = new JTextField();
            JTextField anoField = new JTextField();
            JTextField partidaEletricaField = new JTextField();

            customPanel.add(new JLabel("Marca:"));
            customPanel.add(marcaField);
            customPanel.add(new JLabel("Modelo:"));
            customPanel.add(modeloField);
            customPanel.add(new JLabel("Matrícula:"));
            customPanel.add(matriculaField);
            customPanel.add(new JLabel("Ano:"));
            customPanel.add(anoField);
            customPanel.add(new JLabel("Possui Partida Elétrica:"));
            customPanel.add(partidaEletricaField);

            // Copia a lista para evitar ConcurrentModificationException
            List<Moto> copiaMotos = new ArrayList<>(motos);

            for (Moto moto : copiaMotos) {
                if (moto.getMatricula().equals(matricula)) {
                    marcaField.setText(moto.getMarca());
                    modeloField.setText(moto.getModelo());
                    matriculaField.setText(moto.getMatricula());
                    anoField.setText(String.valueOf(moto.getAno()));
                    partidaEletricaField.setText(String.valueOf(moto.isPossuiPartidaEletrica()));

                    int result = JOptionPane.showConfirmDialog(null, customPanel,
                            "Informações da Moto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        // Processa os dados fornecidos pelo usuário
                        moto.setMarca(marcaField.getText());
                        moto.setModelo(modeloField.getText());
                        moto.setMatricula(matriculaField.getText());
                        moto.setAno(Integer.parseInt(anoField.getText()));
                        moto.setPossuiPartidaEletrica(Boolean.parseBoolean(partidaEletricaField.getText()));

                        encontrado = true;
                        JOptionPane.showMessageDialog(null, "Moto alterada com sucesso!");
                        break;
                    }
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Moto não encontrada na lista.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    // Bicicleta

    private void addBicicleta(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        JPanel panel = new JPanel();
        int resposta = JOptionPane.showConfirmDialog(panel,
                "Deseja Adicionar uma bicicleta?", "Adicionar Bicicleta", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            // Cria um painel personalizado para coletar informações da bicicleta
            JPanel customPanel = new JPanel();
            customPanel.setLayout(new BoxLayout(customPanel, BoxLayout.Y_AXIS));

            JTextField marcaField = new JTextField(15);
            JTextField modeloField = new JTextField(15);
            JTextField matriculaField = new JTextField(15);
            JTextField anoField = new JTextField(15);
            JTextField numeroMarchasField = new JTextField(15);

            customPanel.add(new JLabel("Marca:"));
            customPanel.add(marcaField);
            customPanel.add(new JLabel("Modelo:"));
            customPanel.add(modeloField);
            customPanel.add(new JLabel("Matrícula:"));
            customPanel.add(matriculaField);
            customPanel.add(new JLabel("Ano:"));
            customPanel.add(anoField);
            customPanel.add(new JLabel("Número de Marchas:"));
            customPanel.add(numeroMarchasField);

            int result = JOptionPane.showConfirmDialog(null, customPanel,
                    "Informações da Bicicleta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                // Processa os dados fornecidos pelo usuário
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                String matriculaString = matriculaField.getText();
                int ano = Integer.parseInt(anoField.getText());
                int numeroMarchas = Integer.parseInt(numeroMarchasField.getText());

                if (verificarMatriculaExistente(matriculaString, carros, motos, bicicletas)) {
                    JOptionPane.showMessageDialog(panel, "Matrícula já existe na lista.");
                } else {
                    // Adiciona uma nova bicicleta à lista
                    Bicicleta novaBicicleta = new Bicicleta(marca, modelo, matriculaString, ano,null,pneuBicicleta, numeroMarchas);
                    bicicletas.add(novaBicicleta);

                    // Exibe uma mensagem informando que a bicicleta foi adicionada com sucesso
                    JOptionPane.showMessageDialog(panel, "Bicicleta adicionada com sucesso!");

                    // Atualiza a label com o novo número de bicicletas
                    atualizarLabels(carros, motos, bicicletas);

                    // Atualiza a label com o novo total de veículos
                    int totalVeiculos = carros.size() + motos.size() + bicicletas.size();
                    totalVeiculosL.setText("Total: " + totalVeiculos + " Veículos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operação Cancelada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    private void removerBicicleta(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        if (bicicletas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de bicicletas está vazia.");
            return;
        }

        JPanel panel = new JPanel();
        int resposta = JOptionPane.showConfirmDialog(panel,
                "Deseja remover uma bicicleta?", "Remover Bicicleta", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            String matricula = JOptionPane.showInputDialog(panel, "Matrícula da Bicicleta a remover:");

            boolean encontrado = false;

            // Copia a lista para evitar ConcurrentModificationException
            List<Bicicleta> copiaBicicletas = new ArrayList<>(bicicletas);

            for (Bicicleta bicicleta : copiaBicicletas) {
                if (bicicleta.getMatricula().equals(matricula)) {
                    bicicletas.remove(bicicleta);
                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "Bicicleta removida");
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Bicicleta não encontrada");
            }

            atualizarLabels(carros, motos, bicicletas);

            // Atualiza a label com o novo total de veículos
            int totalVeiculos = carros.size() + motos.size() + bicicletas.size();
            totalVeiculosL.setText("Total: " + totalVeiculos + " Veículos");
        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    private void editarBicicleta(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        if (bicicletas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista de bicicletas está vazia.");
            return;
        }

        JPanel panel = new JPanel();
        int resposta = JOptionPane.showConfirmDialog(panel,
                "Deseja editar uma bicicleta?", "Editar Bicicleta", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            String matricula = JOptionPane.showInputDialog(panel, "Matrícula da Bicicleta a editar:");

            boolean encontrado = false;

            // Copia a lista para evitar ConcurrentModificationException
            List<Bicicleta> copiaBicicletas = new ArrayList<>(bicicletas);

            for (Bicicleta bicicleta : copiaBicicletas) {
                if (bicicleta.getMatricula().equals(matricula)) {
                    // Cria um painel personalizado para coletar informações da bicicleta
                    JPanel customPanel = criarPainelBicicleta(bicicleta);

                    int result = JOptionPane.showConfirmDialog(null, customPanel,
                            "Informações da Bicicleta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        // Atualiza os dados da bicicleta com base no que o usuário forneceu
                        bicicleta.setMarca(((JTextField) customPanel.getComponent(1)).getText());
                        bicicleta.setModelo(((JTextField) customPanel.getComponent(3)).getText());
                        bicicleta.setMatricula(((JTextField) customPanel.getComponent(5)).getText());
                        bicicleta.setAno(Integer.parseInt(((JTextField) customPanel.getComponent(7)).getText()));
                        bicicleta.setNumeroMarchas(
                                Integer.parseInt(((JTextField) customPanel.getComponent(9)).getText()));

                        encontrado = true;
                        JOptionPane.showMessageDialog(null, "Bicicleta editada com sucesso");
                        break;
                    }
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Bicicleta não encontrada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação Cancelada");
        }
    }

    // Função auxiliar para criar um painel com os campos de uma bicicleta
    private JPanel criarPainelBicicleta(Bicicleta bicicleta) {
        JPanel customPanel = new JPanel();
        customPanel.setLayout(new GridLayout(5, 2));

        JTextField marcaField = new JTextField(bicicleta.getMarca());
        JTextField modeloField = new JTextField(bicicleta.getModelo());
        JTextField matriculaField = new JTextField(bicicleta.getMatricula());
        JTextField anoField = new JTextField(String.valueOf(bicicleta.getAno()));
        JTextField numeroMarchasField = new JTextField(String.valueOf(bicicleta.getNumeroMarchas()));

        customPanel.add(new JLabel("Marca:"));
        customPanel.add(marcaField);
        customPanel.add(new JLabel("Modelo:"));
        customPanel.add(modeloField);
        customPanel.add(new JLabel("Matrícula:"));
        customPanel.add(matriculaField);
        customPanel.add(new JLabel("Ano:"));
        customPanel.add(anoField);
        customPanel.add(new JLabel("Número de Marchas:"));
        customPanel.add(numeroMarchasField);

        return customPanel;
    }

    // Atualiza as labels com o novo número de carros e o novo total de veículos
    private void atualizarLabels(ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        carroJLabel.setText("Carros: " + carros.size());
        motosJLabel.setText("Motos: " + motos.size());
        bicicletLabel.setText("Bicicletas: " + bicicletas.size());
        int totalVeiculos = carros.size() + motos.size() + bicicletas.size();
        totalVeiculosL.setText("Total: " + totalVeiculos + " Veículos");

    }

    private void atualizarLabelsFuncionarios(ArrayList<Gestores> users ,ArrayList<Administrador> gestor, ArrayList<Motorista> motorista,
            ArrayList<Mecanico> mecanico) {
        gestores.setText("Administradores: " + gestor.size());
        usersJLabel.setText("Gestores: " + users.size());
        mecanicos.setText("Mecânicos: " + mecanico.size());
        motoristas.setText("Motoristas: " + motorista.size());

        int totalFuncionarios = gestor.size() + mecanico.size() + motorista.size()+users.size();
        total.setText("Total: " + totalFuncionarios + " Funcionários");
    }

    // Verificar email
    private boolean verificarEmailExistente(String novoEmail,ArrayList<Gestores> user, ArrayList<Administrador> gestores,
            ArrayList<Motorista> motoristas,
            ArrayList<Mecanico> mecanicos) {
        for (Administrador gestor : gestores) {
            if (gestor.getEmail().equals(novoEmail)) {
                return true; // E-mail já existe na lista
            }
        }
        for (Mecanico mecanico : mecanicos) {
            if (mecanico.getEmail().equals(novoEmail)) {
                return true; // E-mail já existe na lista
            }
        }
        for (Motorista motorista : motoristas) {
            if (motorista.getEmail().equals(novoEmail)) {
                return true; // E-mail já existe na lista
            }
        }

        for (Gestores gestores2 : user) {
            if (gestores2.getEmail().equals(novoEmail)) {
                return true; // E-mail já existe na lista
            }
        }

        return false; // E-mail não encontrado na lista
    }

    // Verifica se a matrícula já existe na lista de carros
    private boolean verificarMatriculaExistente(String novaMatricula, ArrayList<Carro> carros, ArrayList<Moto> motos,
            ArrayList<Bicicleta> bicicletas) {
        for (Carro carro : carros) {
            if (carro.getMatricula().equals(novaMatricula)) {
                return true;
            }
        }

        for (Moto moto : motos) {
            if (moto.getMatricula().equals(novaMatricula)) {
                return true;
            }
        }

        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getMatricula().equals(novaMatricula)) {
                return true;
            }
        }

        return false;

    }

    private boolean verificarNumeroCarteiraExistente(String numeroCarteira, ArrayList<Motorista> motoristas) {
        for (Motorista motorista : motoristas) {
            if (motorista.getNumeroCarteira().equals(numeroCarteira)) {
                return true;
            }
        }
        return false;
    }

    
    private void gerenciarVeiculoMotorista(ArrayList<Motorista> motoristas, ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        String email = JOptionPane.showInputDialog("Digite o e-mail do motorista:");
        Motorista motoristaEncontrado = null;
    
        // Encontrar o motorista pelo e-mail
        for (Motorista motorista : motoristas) {
            if (motorista.getEmail().equals(email)) {
                motoristaEncontrado = motorista;
                break;
            }
        }
    
        if (motoristaEncontrado == null) {
            JOptionPane.showMessageDialog(null, "Motorista não encontrado!");
            return;
        }
    
        String[] opcoes = {"Adicionar Veículo", "Remover Veículo"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        int resposta = JOptionPane.showConfirmDialog(null, comboBox, "Escolha uma ação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    
        if (resposta == JOptionPane.OK_OPTION) {
            String acaoSelecionada = (String) comboBox.getSelectedItem();
            if ("Adicionar Veículo".equals(acaoSelecionada)) {
                adicionarVeiculoMotorista(motoristaEncontrado, carros, motos, bicicletas);
            } else if ("Remover Veículo".equals(acaoSelecionada)) {
                removerVeiculoMotorista(motoristaEncontrado);
            }
        }
    }
    
    private void adicionarVeiculoMotorista(Motorista motorista, ArrayList<Carro> carros, ArrayList<Moto> motos, ArrayList<Bicicleta> bicicletas) {
        if (motorista.verificaVeiculo()) {
            String matricula = JOptionPane.showInputDialog("Digite a matrícula do veículo:");
    
            // Procura o veículo pela matrícula e o associa ao motorista
            boolean veiculoEncontrado = false;
            for (Carro carro : carros) {
                if (carro.getMatricula().equals(matricula)) {
                    carro.setMotorista(motorista);
                    motorista.setVeiculos(carro);
                    veiculoEncontrado = true;
                    break;
                }
            }
    
            for (Moto moto : motos) {
                if (!veiculoEncontrado && moto.getMatricula().equals(matricula)) {
                    moto.setMotorista(motorista);
                    motorista.setVeiculos(moto);
                    veiculoEncontrado = true;
                    break;
                }
            }
    
            for (Bicicleta bicicleta : bicicletas) {
                if (!veiculoEncontrado && bicicleta.getMatricula().equals(matricula)) {
                    bicicleta.setMotorista(motorista);
                    motorista.setVeiculos(bicicleta);
                    break;
                }
            }
    
            if (veiculoEncontrado) {
                JOptionPane.showMessageDialog(null, "Veículo vinculado ao motorista com a carta " + motorista.getNumeroCarteira());
            } else {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "O motorista já possui um veículo associado!");
        }
    }
    
    private void removerVeiculoMotorista(Motorista motorista) {
        if (!motorista.verificaVeiculo()) {
            // Desassocia o veículo do motorista
            Veiculos veiculo = motorista.getVeiculos();
            veiculo.setMotorista(null);
            motorista.setVeiculos(null);
            JOptionPane.showMessageDialog(null, "Veículo removido do motorista com a carta " + motorista.getNumeroCarteira());
        } else {
            JOptionPane.showMessageDialog(null, "O motorista não tem um veículo associado para remover!");
        }
    }
    

    private Veiculos encontrarVeiculoPelaMatricula(String matricula, ArrayList<Carro> carros, ArrayList<Moto> motos,
            ArrayList<Bicicleta> bicicletas) {
        for (Carro carro : carros) {
            if (carro.getMatricula().equals(matricula)) {
                return carro;
            }
        }
        for (Moto moto : motos) {
            if (moto.getMatricula().equals(matricula)) {
                return moto;
            }
        }
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getMatricula().equals(matricula)) {
                return bicicleta;
            }
        }
        return null;
    }

    private void imprimirUsuarios(ArrayList<Administrador> gestores, ArrayList<Gestores> user ,ArrayList<Mecanico> mecanicos,
            ArrayList<Motorista> motoristas, ArrayList<Carro> carros, ArrayList<Moto> motos,
            ArrayList<Bicicleta> bicicletas) {
        // Nome do arquivo onde serão salvas as informações
        String fileName = "dadosFrota.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Escreve as informações de gestores no arquivo
            writer.println("-------- Administradores --------");
            for (Administrador gestor : gestores) {
                writer.println(gestor.toString());
                writer.println("--------");
            }

            writer.println("-------- Gestores --------");
            for (Gestores gestor : user) {
                writer.println(gestor.toString());
                writer.println("--------");
            }

            // Escreve as informações de mecânicos no arquivo
            writer.println("-------- Mecânicos --------");
            for (Mecanico mecanico : mecanicos) {
                writer.println(mecanico.toString());
                writer.println("--------");
            }

            // Escreve as informações de motoristas no arquivo
            writer.println("-------- Motoristas --------");
            for (Motorista motorista : motoristas) {
                writer.println(motorista.toString());
                writer.println("--------");
            }

            writer.println("-------- Carros --------");
            for (Carro carro : carros) {
                writer.println(carro.toString());
                writer.println("--------");
            }

            writer.println("-------- Motos --------");
            for (Moto moto : motos) {
                writer.println(moto.toString());
                writer.println("--------");
            }

            writer.println("-------- Bicicletas --------");
            for (Bicicleta bicicleta : bicicletas) {
                writer.println(bicicleta.toString());
                writer.println("--------");
            }
            JOptionPane.showMessageDialog(null, "Informações dos usuários foram salvas no arquivo: " + fileName,
                    fileName, JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
