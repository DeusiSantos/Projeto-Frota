package Pages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Maquinas.Bicicleta;
import Maquinas.Carro;
import Maquinas.Moto;
import frota.GrafoCidades;
import funcionarios.Gestores;
import funcionarios.Motorista;
import veiculos.Veiculos;

public class PaginaGestor extends JFrame {


    public PaginaGestor(GrafoCidades grafo, Gestores gestores, ArrayList<Motorista> motoristas,
            ArrayList<Carro > carros,
            ArrayList<Moto> motos,
            ArrayList<Bicicleta> bicicletas) {

        String[] cidades = { "Luanda", "Talatona", "Viana", "Cacuaco" };

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
        panel2.setBounds(450, 290, 1000, 500);
        panel2.setLayout(null);

        JLabel labelNome = new JLabel("Bem-vindo, ".toUpperCase() + gestores.getNome().toUpperCase() + " "
                + gestores.getSobrenome().toUpperCase() + "!");
        labelNome.setFont(new Font("Verdana", Font.BOLD, 20));
        labelNome.setBounds(30, 20, 700, 50);
        panel.add(labelNome);
        panel.add(logoutIcon);

        // JLabel veiculoAConduzir = new JLabel("Selecione o veiculo: ");
        // veiculoAConduzir.setBounds(30, 100, 350, 50);
        // veiculoAConduzir.setFont(new Font("Verdana", Font.BOLD, 20));
        // panel2.add(veiculoAConduzir);

        // veiculosComboBox = new JComboBox<>();
        // veiculosComboBox.setBounds(370, 110, 350, 30);
        // panel2.add(veiculosComboBox);
        // veiculosComboBox = new JComboBox<>();

        // JButton selecionarVeiculoButton = new JButton("Selecionar Veículo");
        // selecionarVeiculoButton.setBounds(740, 110, 200, 30);
        // selecionarVeiculoButton.setBackground(new Color(2, 117, 216));
        // selecionarVeiculoButton.setForeground(Color.white);
        // panel2.add(selecionarVeiculoButton);

        JLabel caminhoMaisProximo = new JLabel("Calcular o caminho mais proximo: ");
        caminhoMaisProximo.setBounds(30, 200, 390, 50);
        caminhoMaisProximo.setFont(new Font("Verdana", Font.BOLD, 20));
        panel2.add(caminhoMaisProximo);

        JLabel origem = new JLabel("Origem: ");
        origem.setBounds(30, 300, 100, 50);
        origem.setFont(new Font("Verdana", Font.BOLD, 20));
        panel2.add(origem);

        JComboBox<String> origemComboBox = new JComboBox<>(cidades);
        origemComboBox.setBounds(130, 313, 170, 25);
        origemComboBox.setFont(new Font("Verdana", Font.BOLD, 20));
        panel2.add(origemComboBox);

        JComboBox<String> destinComboBox = new JComboBox<>(cidades);
        destinComboBox.setBounds(455, 313, 170, 25);
        destinComboBox.setFont(new Font("Verdana", Font.BOLD, 20));
        panel2.add(destinComboBox);

        JLabel destino = new JLabel("Destino: ");
        destino.setBounds(350, 300, 150, 50);
        destino.setFont(new Font("Verdana", Font.BOLD, 20));
        panel2.add(destino);

        JButton calcular = new JButton("Calcular");
        calcular.setBounds(660, 310, 200, 30);
        calcular.setBorder(null);
        calcular.setBackground(new Color(2, 117, 216));
        calcular.setForeground(Color.white);
        panel2.add(calcular);

        calcular.addActionListener(e -> {
            
                // Aqui, implemente a lógica para calcular o caminho mais curto
                GrafoCidades.CaminhoMaisCurto caminhoMaisCurto = grafo.caminhoMaisCurto(
                        (String) origemComboBox.getSelectedItem(), (String) destinComboBox.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Caminho mais curto: " + caminhoMaisCurto.getCaminho()
                        + "\nDistância total: " + caminhoMaisCurto.getDistanciaTotal() + " km");
        });

        add(panel2);
        add(panel);
        // veiculosComboBox.setBounds(370, 110, 350, 30);
        // panel2.add(veiculosComboBox);

        // JButton selecionarVeiculoButton = new JButton("Selecionar Veículo");
        // selecionarVeiculoButton.setBounds(740, 110, 200, 30);
        // panel.add(selecionarVeiculoButton);

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
        // atualizarVeiculos(carros, motos, bicicletas);
        setVisible(true);
    }

    // public void atualizarVeiculos(ArrayList<Carro> carros, ArrayList<Moto> motos,
    //         ArrayList<Bicicleta> bicicletas) {
    //     // Limpar a JComboBox

    //     // Adicionar veículos, motos e bicicletas
    //     veiculosComboBox.addItem("Nenhum");
    //     for (Carro carro : carros) {
    //         veiculosComboBox.addItem("Carro: " + carro.getMarca() + "-> Matricula: " + carro.getMatricula());
    //     }

    //     for (Moto moto : motos) {
    //         veiculosComboBox.addItem("Moto: " + moto.getMarca() + "-> Matricula: " + moto.getMatricula());
    //     }

    //     for (Bicicleta bicicleta : bicicletas) {
    //         veiculosComboBox
    //                 .addItem("Bicicleta: " + bicicleta.getMarca() + "-> Matricula: " + bicicleta.getMatricula());
    //     }
    // }
}
