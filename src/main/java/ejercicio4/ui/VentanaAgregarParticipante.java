package ejercicio4.ui;

import ejercicio4.model.SistemaParticipantes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaAgregarParticipante extends JFrame {
    private final SistemaParticipantes unSistema;
    private JTextField nombre;
    private JTextField telefono;
    private JComboBox<String>  region;
    private JTextField email;
    private JButton botonCargar;
    private JPanel PanelAgregarParticipante;

    public VentanaAgregarParticipante(SistemaParticipantes sistemaParticipantes) {
        unSistema = sistemaParticipantes;
        cargarComponentesUI();
    }

    private void cargarComponentesUI() {
        this.setContentPane(PanelAgregarParticipante);
        this.pack();
        this.setVisible(true);
        botonCargar.addActionListener(e -> {
            actionPerformed();
        });

    }

    private void actionPerformed() {
        try {
            unSistema.altaParticipante(nombre.getText(), telefono.getText(),email.getText(), region.getSelectedItem().toString());
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e);
            this.setVisible(true);
        }


    }


}
