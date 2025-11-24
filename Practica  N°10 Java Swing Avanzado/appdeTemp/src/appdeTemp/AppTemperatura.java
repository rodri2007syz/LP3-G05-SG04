package appdeTemp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppTemperatura extends JFrame {


    private JTextField[] txtTemperaturas;
    private PanelGrafico panelGrafico;
    private final String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    public AppTemperatura() {

        setTitle("Registro de Temperaturas Semanal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelEntradas = new JPanel(new GridLayout(2, 7, 5, 5)); 
        panelEntradas.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        txtTemperaturas = new JTextField[7];
        
        for (String dia : dias) {
            panelEntradas.add(new JLabel(dia, SwingConstants.CENTER));
        }


        for (int i = 0; i < 7; i++) {
            txtTemperaturas[i] = new JTextField("0"); 
            txtTemperaturas[i].setHorizontalAlignment(JTextField.CENTER);
            panelEntradas.add(txtTemperaturas[i]);
        }


        panelGrafico = new PanelGrafico();
        panelGrafico.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelGrafico.setBackground(Color.WHITE);


        JPanel panelBoton = new JPanel();
        JButton btnGraficar = new JButton("Mostrar Gráfico");
        btnGraficar.setFont(new Font("Arial", Font.BOLD, 14));
        
        btnGraficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatosGrafico();
            }
        });
        panelBoton.add(btnGraficar);

        add(panelEntradas, BorderLayout.NORTH);
        add(panelGrafico, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }


    private void actualizarDatosGrafico() {
        double[] temps = new double[7];
        try {
            for (int i = 0; i < 7; i++) {
                String texto = txtTemperaturas[i].getText();
                temps[i] = Double.parseDouble(texto);
            }

            panelGrafico.setTemperaturas(temps);
            panelGrafico.repaint(); 
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error: Ingrese solo números válidos en las temperaturas.", 
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppTemperatura().setVisible(true));
    }
}


class PanelGrafico extends JPanel {
    private double[] temperaturas;
    private final int MARGEN = 50; 

    public PanelGrafico() {

        this.temperaturas = new double[]{0, 0, 0, 0, 0, 0, 0};
    }


    public void setTemperaturas(double[] nuevasTemperaturas) {
        this.temperaturas = nuevasTemperaturas;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();

        g2.setColor(Color.BLACK);
        g2.drawLine(MARGEN, alto - MARGEN, ancho - MARGEN, alto - MARGEN); 
        g2.drawLine(MARGEN, MARGEN, MARGEN, alto - MARGEN); 

        double maxTemp = 0;
        for (double t : temperaturas) {
            if (t > maxTemp) maxTemp = t;
        }
        if (maxTemp <= 0) maxTemp = 10; 
        maxTemp = maxTemp * 1.2; 

        int pasoX = (ancho - (2 * MARGEN)) / (temperaturas.length - 1);
        double escalaY = (double) (alto - (2 * MARGEN)) / maxTemp;
        g2.setStroke(new BasicStroke(2)); 
        
        int xAnt = -1;
        int yAnt = -1;

        for (int i = 0; i < temperaturas.length; i++) {

            int x = MARGEN + (i * pasoX);
            
            int y = alto - MARGEN - (int)(temperaturas[i] * escalaY);

            if (i > 0) {
                g2.setColor(Color.BLUE);
                g2.drawLine(xAnt, yAnt, x, y);
            }

            g2.setColor(Color.RED);
            int radio = 8;
            g2.fillOval(x - (radio/2), y - (radio/2), radio, radio);

            g2.setColor(Color.DARK_GRAY);
            g2.drawString(String.valueOf(temperaturas[i]), x - 10, y - 10);
            
            String[] letrasDias = {"L", "M", "M", "J", "V", "S", "D"};
            g2.drawString(letrasDias[i], x - 5, alto - MARGEN + 20);

            xAnt = x;
            yAnt = y;
        }
    }
}