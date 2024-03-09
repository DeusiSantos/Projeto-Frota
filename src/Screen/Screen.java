package Screen;

import javax.swing.*;

import Maquinas.Bicicleta;
import Maquinas.Carro;
import Maquinas.Moto;
import Maquinas.Motor;
import Maquinas.Pneu;
import Pages.PaginaAdministrador;
import Pages.PaginaGestor;
import Pages.PaginaMecanico;
import Pages.PaginaMotorista;
import frota.GrafoCidades;
import funcionarios.Administrador;
import funcionarios.Gestores;
import funcionarios.Mecanico;
import funcionarios.Motorista;

import java.awt.*;
import java.util.ArrayList;

public class Screen {
    public Screen() {

        ArrayList<Administrador> administrador = new ArrayList<>();
        ArrayList<Gestores> GestoreS = new ArrayList<>();
        ArrayList<Mecanico> mecanicos = new ArrayList<>();
        ArrayList<Motorista> motoristas = new ArrayList<>();
        ArrayList<Carro> carro = new ArrayList<>();
        ArrayList<Moto> moto = new ArrayList<>();
        ArrayList<Bicicleta> bicicleta = new ArrayList<>();

        Motor motorCarro = new Motor("Original do veiculo", 100);
        Motor motorMoto = new Motor("Original da moto", 65);
        Pneu pneuCarro = new Pneu("Original do Veiculo", 19, "Normal");
        Pneu pneuMoto = new Pneu("Original do Veiculo", 14, "Normal");
        Pneu pneuBicicleta = new Pneu("Original do Veiculo", 14, "Normal");

        GestoreS.add(new Gestores("Paulo", "Joao", 30, "JoaoPaulo@frota.com", "1234"));
        GestoreS.add(new Gestores("Andreza", "Martins", 35, "AndrezaMar@frota.com", "1234"));
        GestoreS.add(new Gestores("Andreza", "Martins", 35, "v", "v"));


        administrador.add(new Administrador("Deusineusio", "Santos", 23, "deuSantos@frota.com", "1234"));
        administrador.add(new Administrador("Nancy", "Danila", 23, "nancyDanila@frota.com", "1234"));
        administrador.add(new Administrador("Suzete", "Canda", 21, "suzeteCanda@frota.com", "1234"));
        administrador.add(new Administrador("Melanie", "Melo", 21, "melanieMelo@frota.com", "1234"));

        administrador.add(new Administrador("Suzete", "Canda", 21, "n", "n"));

        mecanicos.add(new Mecanico("Paulo", "Andrade", 30, "Manutencao", "PauloAndrade@frota.com", "1234"));
        motoristas.add(new Motorista("Mateus", "Buila", 40, "45LK877", "Professional",
                " ", " "));
        motoristas.add(new Motorista("Mateus", "Buila", 40, "45LK877", "Professional",
                "mateusBuila@frota.com", "1234"));

        carro.add(new Carro("Ferrari", "GT445", "LD-77-09-09-OP", 2019, motorCarro, pneuCarro, 2));
        moto.add(new Moto("Dugati", "GT665", "LD-65-09-EP", motorMoto, pneuMoto, 2020, true));
        bicicleta.add(new Bicicleta("Tingi", "BT6", "677", 2010, null, pneuBicicleta, 1));

        // Adicionar cidades

        JFrame jFrame = new JFrame("Frota");
        jFrame.setSize(1100, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);

        // Cria um JPanel para adicionar a imagem
        JPanel panel = new JPanel();
        ImageIcon icon = new ImageIcon("src/img/undraw_enter_uhqk (1).png");
        JLabel image = new JLabel(icon);
        image.setBounds(0, -40, 450, 600);

        ImageIcon iconUser = new ImageIcon("src/img/user.png");
        JLabel user = new JLabel(iconUser);
        user.setBounds(680, -50, 550, 600);

        ImageIcon iconPass = new ImageIcon("src/img/pass.png");
        JLabel pass = new JLabel(iconPass);
        pass.setBounds(680, 20, 550, 600);

        // Campo para criar o formulário

        JLabel textLogin = new JLabel("LOGIN");
        textLogin.setBounds(750, 100, 140, 50);
        textLogin.setFont(new Font("Verdana", Font.BOLD, 36));

        JLabel lestGo = new JLabel("Seja Bem-vindo, vamos começar");
        lestGo.setBounds(615, 150, 450, 50);
        lestGo.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 25));

        // Adiciona o JLabel ao JPanel
        panel.add(image);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.add(user);
        panel.add(pass);

        // Adicionar formulário ao panel

        // Email
        JLabel textEmailLabel = new JLabel("Email:");
        textEmailLabel.setBounds(615, 240, 300, 10);
        textEmailLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        JTextField email = new JTextField();
        email.setBounds(615, 250, 300, 30);
        email.setBorder(null);
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(615, 280, 350, 13);
        separator.setBackground(Color.BLACK);
        separator.setForeground(new Color(0, 0, 0, 1));

        // Senha
        JLabel textSenhaLabel = new JLabel("Senha:");
        textSenhaLabel.setBounds(615, 310, 300, 10);
        textSenhaLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        JPasswordField senha = new JPasswordField(); // Use JPasswordField para senhas
        senha.setBounds(615, 320, 300, 30);
        senha.setBorder(null);
        JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
        separator2.setBounds(615, 350, 350, 13);
        separator2.setBackground(Color.BLACK);
        separator2.setForeground(new Color(0, 0, 0, 1));

        // BOTAO
        JButton button = new JButton("Entrar");
        button.setBounds(835, 380, 130, 50);
        button.setBorder(null);
        button.setBackground(new Color(5, 175, 242));
        button.setForeground(Color.WHITE);

        button.addActionListener(
                e -> verificaGerente(null,administrador, GestoreS, mecanicos, motoristas, carro, moto, bicicleta,
                        email.getText(),
                        new String(senha.getPassword())));

        // Adicionar formulário ao panel
        panel.add(textLogin);
        panel.add(lestGo);
        panel.add(textEmailLabel);
        panel.add(email);
        panel.add(separator);
        panel.add(textSenhaLabel);
        panel.add(senha);
        panel.add(separator2);
        panel.add(button);

        // Adiciona o JPanel ao JFrame
        jFrame.add(panel);

        // Define a operação padrão de fechamento
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Torna a janela visível
        jFrame.setVisible(true);
    }

    private void verificaGerente(GrafoCidades grafo, ArrayList<Administrador> lista,ArrayList<Gestores> gestores,
            ArrayList<Mecanico> listaMecanicos,
            ArrayList<Motorista> listaMotoristas, ArrayList<Carro> carro, ArrayList<Moto> moto,
            ArrayList<Bicicleta> bicicletas, String email, String senha) {
        boolean encontrado = false;


        grafo = new GrafoCidades();

        grafo.adicionarCidade("Luanda");
        grafo.adicionarCidade("Talatona");
        grafo.adicionarCidade("Viana");
        grafo.adicionarCidade("Cacuaco");

        // Adicionar estradas
        grafo.adicionarEstrada("Luanda", "Talatona", 25);
        grafo.adicionarEstrada("Luanda", "Cacuaco", 15);
        grafo.adicionarEstrada("Luanda", "Viana", 20);
        grafo.adicionarEstrada("Viana", "Cacuaco", 10);
        grafo.adicionarEstrada("Viana", "Talatona", 10);

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return;
        }

        for (Administrador Administrador : lista) {
            if (Administrador.getEmail().equals(email) && Administrador.getSenha().equals(senha)) {
                PaginaAdministrador paginaGerente = new PaginaAdministrador(Administrador,gestores ,lista, listaMotoristas, listaMecanicos,
                        carro, moto, bicicletas);
                paginaGerente.exibirPagina();

                encontrado = true;
                break;
            }
        }

        for (Mecanico mecanico : listaMecanicos) {
            if (mecanico.getEmail().equals(email) && mecanico.getSenha().equals(senha)) {
                encontrado = true;
                PaginaMecanico paginaMecanico = new PaginaMecanico(mecanico, listaMecanicos, carro, moto, bicicletas);
                paginaMecanico.ExibirPagina();
                break;
            }
        }

        for (Motorista motorista : listaMotoristas) {
            if (motorista.getEmail().equals(email) && motorista.getSenha().equals(senha)) {
                PaginaMotorista paginaMotorista = new PaginaMotorista(motorista, listaMotoristas, carro, moto,
                        bicicletas);
                paginaMotorista.exibirPagina(carro, moto, bicicletas);
                encontrado = true;
                break;
            }
        }

        for (Gestores gestor : gestores) {
            if (gestor.getEmail().equals(email) && gestor.getSenha().equals(senha)) {
                PaginaGestor paginaGestor = new PaginaGestor(grafo, gestor, listaMotoristas, carro, moto, bicicletas);
                paginaGestor.exibirPagina(carro, moto, bicicletas);;
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Conta inexistente \nConsulte um administrador de sistema para adicioná-lo");
        }
    }

}
