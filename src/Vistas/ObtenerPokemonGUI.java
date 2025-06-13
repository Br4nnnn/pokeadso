package Vistas;

import Controladores.ObtenerPokemonDAO;
import Modelos.ObtenerPokemon;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ObtenerPokemonGUI extends JFrame {
    private final ObtenerPokemonDAO controller;
    private ObtenerPokemon pokemon1;
    private ObtenerPokemon pokemon2;
    private JTextArea battleLog;
    private JButton iniciarBatallaButton;
    private JLabel SpritePokemon2;
    private JLabel SpritePokemon1;
    private JTextField hpPokemon2;
    private JTextField atkPokemon2;
    private JTextField hpTextField;
    private JTextField atkTextField;

    public ObtenerPokemonGUI() {
        controller = new ObtenerPokemonDAO();
        /*initComponent();*/
        setupListeners();
    }

    private void setupListeners() {
        iniciarBatallaButton.addActionListener(e -> iniciarBatalla());
    }

    private void iniciarBatalla() {
        pokemon1 = controller.obtenerPokemonAleatorio();
        pokemon2 = controller.obtenerPokemonAleatorio();

        if (pokemon1 != null && pokemon2 != null) {
            // Actualizar stats de Pokémon 1
            hpTextField.setText("HP: " + pokemon1.getHp());
            atkTextField.setText("ATK: " + pokemon1.getAtaque());
            
            // Actualizar stats de Pokémon 2
            hpPokemon2.setText("HP: " + pokemon2.getHp());
            atkPokemon2.setText("ATK: " + pokemon2.getAtaque());

            // Cargar sprites
            try {
                ImageIcon sprite1 = new ImageIcon(new URL(pokemon1.getSprite()));
                ImageIcon sprite2 = new ImageIcon(new URL(pokemon2.getSprite()));
                SpritePokemon1.setIcon(sprite1);
                SpritePokemon2.setIcon(sprite2);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // Simular batalla
            String resultado = controller.simularBatalla(pokemon1, pokemon2);
            JOptionPane.showMessageDialog(this, resultado, "Resultado de la Batalla", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error al obtener los Pokémon", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ObtenerPokemonGUI frame = new ObtenerPokemonGUI();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setSize(800, 600);
            frame.setResizable(false);
        });
    }
}