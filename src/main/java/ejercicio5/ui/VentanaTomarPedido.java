package ejercicio5.ui;

import ejercicio4.model.Sujeto;
import ejercicio5.database.EnDiscoRegistro;
import ejercicio5.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;


public class VentanaTomarPedido extends JFrame {
    private JComboBox<Integer> numMesaCbox;
    private JComboBox<Bebida> productoBebidaCbox;
    private JSpinner cantidadBebidaSpinner;
    private JButton cargarBebidaBtn;

    private JButton cargarPlatoBtn;
    private JTable tablaPedidos;
    private JButton cancelarBtn;
    private JButton pagarBtn;
    private JLabel MesaJLbl;
    private JPanel BebidasPanel;
    private JLabel productoBebidaLbl;
    private JLabel cantidadBebidaLbl;
    private JPanel PlatoPrincipalPanel;
    private JLabel productoPlatoLbl;
    private JLabel cantidadPlatoLbl;
    private JComboBox<PlatoPrincipal> productoPlatoCbox;
    private JSpinner cantidadPlatoSpinner;
    private JLabel propinaLbl;
    private JComboBox<Propina> propinaCbox;
    private JPanel mainPanel;
    private JTextField emailTxt;
    private JLabel emailLbl;
    private JLabel totalLbl;
    private Registro registro;
    private Notificacion cuenta;
    private ProveedorDeFechas fecha;
    private Tarjeta tarjeta;
    private String remitente;
    private String asunto;
    private String mensaje;

    private Mesa mesa;
    private Pedido nuevoPedido;

    public VentanaTomarPedido(Registro registro, Notificacion cuenta, ProveedorDeFechas proveedorDeFechasecha, Tarjeta tarjeta,List<Observador> observadores)  {
        this.registro = registro;
        this.cuenta = cuenta;
        this.fecha = proveedorDeFechasecha;
        this.remitente= "restaurante@gmail.com";
        this.asunto = "Restaurante de la Mesa"+ numMesaCbox.getSelectedItem();
        this.mensaje = "Hola, muchas gracias por su pedido. Estoy a su disposición para su atención.";
        cargarElementos();
        this.tarjeta = tarjeta;
        this.mesa= new Mesa((Integer) numMesaCbox.getSelectedItem(),emailTxt.getSelectedText(), observadores);
        this.nuevoPedido = new Pedido(mesa, registro, cuenta,remitente, asunto,mensaje,fecha);
    }


    private void cargarElementos() {
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
        Integer[] numerosDeMesa = {1, 2, 3, 4, 5};  // Ejemplo de números de mesa
        numMesaCbox.setModel(new DefaultComboBoxModel<>(numerosDeMesa));
        cargarBebidas(List.of(new Bebida("Cerveza",90.0),new Bebida("Gaseosa",70.0),new Bebida("Jugo",50.0)));
        cargarPlatoPrincipal(List.of(new PlatoPrincipal("Milanesa",100.0),new PlatoPrincipal("Empanadas",250.0),new PlatoPrincipal("Pastas",200.0)));
        cargarPropina(List.of(new Propina2porciento(),new Propina3porciento(),new Propina5porciento()));
        var columnasNames = new String[]{"Producto", "Cantidad", "Precio"};
        DefaultTableModel model = new DefaultTableModel(columnasNames,0);
        tablaPedidos.setModel(model);
        cantidadBebidaSpinner.addChangeListener(e -> accionPerformedCambiarVisibilidad(cantidadBebidaSpinner,cargarBebidaBtn) );
        cantidadPlatoSpinner.addChangeListener(e -> accionPerformedCambiarVisibilidad(cantidadPlatoSpinner,cargarPlatoBtn) );
        cargarBebidaBtn.addActionListener(e -> accionPerformedCargarBebidas((Bebida) Objects.requireNonNull(productoBebidaCbox.getSelectedItem()), (Integer) cantidadBebidaSpinner.getValue()));
        cargarPlatoBtn.addActionListener(e -> accionPerformedCargarPlato((PlatoPrincipal) Objects.requireNonNull(productoPlatoCbox.getSelectedItem()), (Integer) cantidadPlatoSpinner.getValue()));
        pagarBtn.addActionListener(e -> accionPerformedPagar());
    }

    private void accionPerformedModificarCorreo() {
        if (!emailTxt.getText().isEmpty()) {
            mesa.modificarCorreo(emailTxt.getText());
            pagarBtn.setEnabled(true);
        }

    }

    private void accionPerformedPagar() {
        var propina = (Propina) propinaCbox.getSelectedItem();
        mesa.pagarCuenta(nuevoPedido,tarjeta,propina);

    }

    private void accionPerformedCargarPlato(PlatoPrincipal platoPrincipal, Integer cantidad) {
        var model = (DefaultTableModel) tablaPedidos.getModel();
        model.addRow(new Object[]{platoPrincipal.nombre(),cantidad,platoPrincipal.precio()});
        tablaPedidos.repaint();
        IntStream.range(0, cantidad).forEach(i -> mesa.realizarPedido(this.nuevoPedido, platoPrincipal));
        calcularTotal();
        accionPerformedModificarCorreo();
    }

    private void accionPerformedCargarBebidas(Bebida bebida, int cantidad) {
        var model = (DefaultTableModel) tablaPedidos.getModel();
        model.addRow(new Object[]{bebida.nombre(),cantidad,bebida.precio()});
        tablaPedidos.repaint();
        IntStream.range(0, cantidad).forEach(i -> mesa.realizarPedido(this.nuevoPedido, bebida));
        calcularTotal();
        accionPerformedModificarCorreo();
    }

    private void calcularTotal() {
        totalLbl.setText(nuevoPedido.calcularTotal(tarjeta) +" $");
    }

    private void accionPerformedCambiarVisibilidad(JSpinner cantidad, JButton button) {
        if (((Integer) cantidad.getValue()) > 0) {
            button.setEnabled(true);
        }
        else {
            button.setEnabled(false);
        }
    }

    private void cargarBebidas(List<Bebida> bebidas) {
        productoBebidaCbox.removeAllItems();
        for (Bebida bebida : bebidas) {
            productoBebidaCbox.addItem(bebida);
        }
    }

    private void cargarPlatoPrincipal(List<PlatoPrincipal> platos) {
        productoPlatoCbox.removeAllItems();
        for (PlatoPrincipal plato : platos) {
            productoPlatoCbox.addItem(plato);
        }
    }

    private void cargarPropina(List<Propina> propinas) {
        propinaCbox.removeAllItems();
        for (Propina propina : propinas) {
            propinaCbox.addItem(propina);
        }
    }


}






