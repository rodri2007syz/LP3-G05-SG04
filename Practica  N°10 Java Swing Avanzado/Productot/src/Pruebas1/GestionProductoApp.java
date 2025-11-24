package Pruebas1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionProductoApp extends JFrame {
	
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtCategoria;
    

    private JTextArea txtResultado;
    
    private Producto productoModelo;

    public GestionProductoApp() {
        setTitle("Gestión de Producto");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        productoModelo = new Producto();

        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelDatos.add(txtPrecio);

        panelDatos.add(new JLabel("Cantidad Stock:"));
        txtStock = new JTextField();
        panelDatos.add(txtStock);

        panelDatos.add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        panelDatos.add(txtCategoria);

        JPanel panelInferior = new JPanel(new BorderLayout(10, 10));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnActualizar = new JButton("Actualizar Producto");

        txtResultado = new JTextArea();
        txtResultado.setText("Aquí se mostrará la información estructurada...");
        txtResultado.setEditable(false);       
        txtResultado.setOpaque(false);         
        txtResultado.setBackground(new Color(238, 238, 238)); 
        txtResultado.setFont(new Font("Monospaced", Font.BOLD, 12)); 
        txtResultado.setBorder(BorderFactory.createTitledBorder("Información del Modelo"));

        
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatos();
            }
        });

        panelInferior.add(btnActualizar, BorderLayout.NORTH);
        panelInferior.add(txtResultado, BorderLayout.CENTER);

        
        add(panelDatos, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.CENTER);
    }

    private void actualizarDatos() {
        try {
            String nom = txtNombre.getText();
            String cat = txtCategoria.getText();
            double pre = Double.parseDouble(txtPrecio.getText());
            int st = Integer.parseInt(txtStock.getText());

            productoModelo.setNombre(nom);
            productoModelo.setPrecio(pre);
            productoModelo.setCantidadStock(st);
            productoModelo.setCategoria(cat);

            StringBuilder sb = new StringBuilder();
            sb.append("DATOS ACTUALIZADOS:\n");
            sb.append("----------------------------\n");
            sb.append("Nombre:    ").append(productoModelo.getNombre()).append("\n");
            sb.append("Categoría: ").append(productoModelo.getCategoria()).append("\n");
            sb.append("Precio:    ").append(productoModelo.getPrecio()).append("\n");
            sb.append("Stock:     ").append(productoModelo.getCantidadStock());

            txtResultado.setText(sb.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese números válidos en Precio y Stock.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestionProductoApp().setVisible(true));
    }
}