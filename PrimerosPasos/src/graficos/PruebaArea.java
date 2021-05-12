package graficos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PruebaArea {
    public static void main(String[] args) {
        MarcoPruebaArea mimarco = new MarcoPruebaArea();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class MarcoPruebaArea extends JFrame {

    public MarcoPruebaArea() {

        setTitle("Probando Area de texto");
        setBounds(500, 300, 500, 350);

        setLayout(new BorderLayout());
        laminaBotones = new JPanel();
        botonInsertar = new JButton("Insertar");
        laminaBotones.add(botonInsertar);
        botonInsertar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                areaTexto.append("En un lugar de la mancha de cuyo nombre no quiero acordarme");

            }

        });
        botonSaltoLinea = new JButton("Salto Línea");
        botonSaltoLinea.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // aqui con el signo =! niega lo que se obtiene es decir que si saltar=!true
                // saltar es realemnte false
                // le metodo me dice si hay saltos de linea .getlinewarp()
                boolean saltar = !areaTexto.getLineWrap();
                areaTexto.setLineWrap(saltar);
              /*  if (saltar) {
                    botonSaltoLinea.setText("Quitar salto");
                } else {
                    botonSaltoLinea.setText("Salto Línea");
                }*/
                //es un operador ternario que funciona igual como un if, ya que hace la respectiva evaluación como arriba
                botonSaltoLinea.setText(saltar ? "Quitar salto" : "Salto Línea");
            }

        });
        laminaBotones.add(botonSaltoLinea);
        add(laminaBotones, BorderLayout.SOUTH);
        areaTexto = new JTextArea(8, 20);
        laminaConBarras = new JScrollPane(areaTexto);
        add(laminaConBarras, BorderLayout.CENTER);
    }

    private JTextArea areaTexto;
    private JPanel laminaBotones;
    private JButton botonInsertar, botonSaltoLinea;
    private JScrollPane laminaConBarras;
}
