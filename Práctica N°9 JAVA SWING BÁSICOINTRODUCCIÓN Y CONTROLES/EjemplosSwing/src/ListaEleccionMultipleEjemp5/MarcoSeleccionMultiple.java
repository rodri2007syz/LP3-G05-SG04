package ListaEleccionMultipleEjemp5;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MarcoSeleccionMultiple extends JFrame
{
    private final JList listaJListColores; //lista de colores 
    private final JList listaJListCopia; // lista que copiara los colores 
    private JButton botonJButtonCopiar; // boton para copiar
    private static final String[] nombresColores = {"Negro", "Azul", "Cyan",
        "Gris oscuro", "Gris", "Verde", "Gris claro", "Magenta", "Naranja",
        "Rosa", "Rojo", "Blanco", "Amarillo"};
    

    public MarcoSeleccionMultiple()
    {
        super("Huanqui , Rodrigo seleccion multiple");
        setLayout(new FlowLayout());
        
        listaJListColores = new JList(nombresColores);
        listaJListColores.setVisibleRowCount(5); // muestra cinco filas
        listaJListColores.setSelectionMode(
            ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaJListColores)); // agrega lista con panel de desplazamiento
        
        botonJButtonCopiar = new JButton("Copiar >>>");
        botonJButtonCopiar.addActionListener(
            new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent evento)
                {

                    listaJListCopia.setListData(
                        listaJListColores.getSelectedValuesList().toArray(
                            new String[0]));
                }
            }
        );
        
        add(botonJButtonCopiar);
        
        listaJListCopia = new JList(); // lista para guardar nombres
        listaJListCopia.setVisibleRowCount(5); // muestra 5 filas
        listaJListCopia.setFixedCellWidth(100); // establece la anchura
        listaJListCopia.setFixedCellHeight(15); // establece la altura
        listaJListCopia.setSelectionMode(
            ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaJListCopia)); 
    }
}