package Pruebas1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;
import java.util.Arrays;

public class CompraPasajesGUI extends JFrame implements ActionListener {

    private JTextField txtNombre, txtDNI, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbPiso1, rbPiso2;
    private JComboBox<String> cmbOrigen, cmbDestino;
    private JList<String> listServicio;
    private JButton btnMostrar, btnReiniciar;

    public CompraPasajesGUI() {
        super("Compra de Pasajes Bus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); 


        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(8, 2, 10, 10)); 
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        txtNombre = new JTextField(20);
        txtDNI = new JTextField(20);
        txtFecha = new JTextField(20);

        String[] ciudades = {"Lima", "Arequipa", "Cusco", "Trujillo"};
        cmbOrigen = new JComboBox<>(ciudades);
        cmbDestino = new JComboBox<>(ciudades);

        String[] servicios = {"Económico", "Standard", "VIP"};
        listServicio = new JList<>(servicios);
        listServicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listServicio.setSelectedIndex(1); 

        
        panelEntrada.add(new JLabel("Nombre:"));
        panelEntrada.add(txtNombre);
        
        panelEntrada.add(new JLabel("DNI:"));
        panelEntrada.add(txtDNI);
        
        panelEntrada.add(new JLabel("Fecha de Viaje (dd/mm/aaaa):"));
        panelEntrada.add(txtFecha);
        
        panelEntrada.add(new JLabel("Origen:"));
        panelEntrada.add(cmbOrigen);
        
        panelEntrada.add(new JLabel("Destino:"));
        panelEntrada.add(cmbDestino);

        JPanel panelPiso = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbPiso1 = new JRadioButton("1er Piso");
        rbPiso2 = new JRadioButton("2do Piso", true); 
        ButtonGroup grupoPiso = new ButtonGroup();
        grupoPiso.add(rbPiso1);
        grupoPiso.add(rbPiso2);
        panelPiso.add(rbPiso1);
        panelPiso.add(rbPiso2);
        
        panelEntrada.add(new JLabel("Piso:"));
        panelEntrada.add(panelPiso);

        panelEntrada.add(new JLabel("Calidad de Servicio:"));
        JScrollPane scrollServicio = new JScrollPane(listServicio);
        scrollServicio.setPreferredSize(new Dimension(200, 60)); 
        panelEntrada.add(scrollServicio);

        JPanel panelOpcional = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        panelOpcional.add(chkAudifonos);
        panelOpcional.add(chkManta);
        panelOpcional.add(chkRevistas);
        
        panelEntrada.add(new JLabel("Servicios Opcionales:"));
        panelEntrada.add(panelOpcional);


        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnMostrar = new JButton("Mostrar Resumen");
        btnReiniciar = new JButton("Reiniciar Campos");
        
        btnMostrar.addActionListener(this);
        btnReiniciar.addActionListener(this);
        
        panelBotones.add(btnMostrar);
        panelBotones.add(btnReiniciar);


        add(panelEntrada, BorderLayout.CENTER); 
        add(panelBotones, BorderLayout.SOUTH);  


        pack(); 
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMostrar) {
            mostrarResumen();
        } else if (e.getSource() == btnReiniciar) {
            reiniciarCampos();
        }
    }


    private void mostrarResumen() {

        String nombre = txtNombre.getText();
        String dni = txtDNI.getText();
        String fecha = txtFecha.getText();
        
        String origen = (String) cmbOrigen.getSelectedItem();
        String destino = (String) cmbDestino.getSelectedItem();
        
        String piso = rbPiso1.isSelected() ? "1er Piso" : "2do Piso";
        
        String servicio = listServicio.getSelectedValue();


        String opcionales = "";
        if (chkAudifonos.isSelected()) opcionales += "Audífonos, ";
        if (chkManta.isSelected()) opcionales += "Manta, ";
        if (chkRevistas.isSelected()) opcionales += "Revistas, ";
        
        if (opcionales.isEmpty()) {
            opcionales = "Ninguno";
        } else {

            opcionales = opcionales.substring(0, opcionales.length() - 2);
        }


        String resumen = "--- Resumen de Compra ---\n\n"
                       + "Pasajero: " + nombre + " (DNI: " + dni + ")\n"
                       + "Fecha de Viaje: " + fecha + "\n"
                       + "Ruta: " + origen + " -> " + destino + "\n"
                       + "Piso Seleccionado: " + piso + "\n"
                       + "Calidad de Servicio: " + servicio + "\n"
                       + "Servicios Opcionales: " + opcionales;


        JOptionPane.showMessageDialog(this, resumen, "Datos del Pasajero", JOptionPane.INFORMATION_MESSAGE);
    }
    

    private void reiniciarCampos() {
        txtNombre.setText("");
        txtDNI.setText("");
        txtFecha.setText("");
        
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
        
        rbPiso2.setSelected(true); 
        
        cmbOrigen.setSelectedIndex(0);
        cmbDestino.setSelectedIndex(0);
        
        listServicio.setSelectedIndex(1); 
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CompraPasajesGUI());
    }
}