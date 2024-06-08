package ejercicio5.ui;

import ejercicio5.model.Observador;

import javax.swing.*;

public class VentanaGerenteObservador   extends JFrame implements Observador {
    private JLabel mesaLbl;
    private JLabel nroMesaLbl;
    private JLabel totalLbl;
    private JLabel precioTotalLbl;
    private JPanel panelDelGerente;
    public VentanaGerenteObservador() {
        cargarElementos();
    }
    private void cargarElementos() {
        this.setContentPane(panelDelGerente);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actualizar(int nroMesa, double nuevoValor) {
        nroMesaLbl.setText(" "+nroMesa);
        precioTotalLbl.setText(nuevoValor +" $");
    }

}
