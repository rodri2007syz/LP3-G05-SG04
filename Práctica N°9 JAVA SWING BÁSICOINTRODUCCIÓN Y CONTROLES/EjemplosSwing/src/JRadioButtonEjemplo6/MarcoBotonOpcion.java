package JRadioButtonEjemplo6;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MarcoBotonOpcion extends JFrame
{
    private final JTextField campoTexto; // mostrar los cambios 
    private final Font tipoLetraSimple; //  texto simple
    private final Font tipoLetraNegrita; // texto en negrita
    private final Font tipoLetraCursiva; // texto en cursiva
    private final Font tipoLetraNegritaCursiva; //  texto en negrita y cursiva
    private final JRadioButton simpleJRadioButton; //  simple
    private final JRadioButton negritaJRadioButton; //  negrita
    private final JRadioButton cursivaJRadioButton; //  cursiva
    private final JRadioButton negritaCursivaJRadioButton; // negrita y cursiva
    private ButtonGroup grupoOpciones; // contiene los botones 
    

    public MarcoBotonOpcion()
    {
        super("Huanqui , Rodrigo prueba de RadioButton");
        setLayout(new FlowLayout());
        
        campoTexto = new JTextField(" Observe el cambio en el estilo del tipo de letra", 25);
        add(campoTexto);

        simpleJRadioButton = new JRadioButton("Simple", true);
        negritaJRadioButton = new JRadioButton("Negrita", false);
        cursivaJRadioButton = new JRadioButton("Cursiva", false);
        negritaCursivaJRadioButton = new JRadioButton("Negrita/Cursiva", false);
        add(simpleJRadioButton); // boton simple
        add(negritaJRadioButton); // boton negrita
        add(cursivaJRadioButton); //  boton cursiva 
        add(negritaCursivaJRadioButton); //boton negrita y cursiva
        

        grupoOpciones = new ButtonGroup();
        grupoOpciones.add(simpleJRadioButton); // agrega simple al grupo
        grupoOpciones.add(negritaJRadioButton); // agrega negrita al grupo
        grupoOpciones.add(cursivaJRadioButton); // agrega cursiva al grupo
        grupoOpciones.add(negritaCursivaJRadioButton); // agrega negrita y cursiva
        

        tipoLetraSimple = new Font("Serif", Font.PLAIN, 14);
        tipoLetraNegrita = new Font("Serif", Font.BOLD, 14);
        tipoLetraCursiva = new Font("Serif", Font.ITALIC, 14);
        tipoLetraNegritaCursiva = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        campoTexto.setFont(tipoLetraSimple);
        

        simpleJRadioButton.addItemListener(
            new ManejadorBotonOpcion(tipoLetraSimple));
        negritaJRadioButton.addItemListener(
            new ManejadorBotonOpcion(tipoLetraNegrita));
        cursivaJRadioButton.addItemListener(
            new ManejadorBotonOpcion(tipoLetraCursiva));
        negritaCursivaJRadioButton.addItemListener(
            new ManejadorBotonOpcion(tipoLetraNegritaCursiva));
    }
    

    private class ManejadorBotonOpcion implements ItemListener
    {
        private Font tipoLetra;
        
        public ManejadorBotonOpcion(Font f)
        {
            tipoLetra = f;
        }
        

        @Override
        public void itemStateChanged(ItemEvent evento)
        {
            campoTexto.setFont(tipoLetra);
        }
    }
} // fin de la clase MarcoBotonOpcion