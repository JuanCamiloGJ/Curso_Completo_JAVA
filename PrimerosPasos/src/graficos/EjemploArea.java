package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EjemploArea {
    public static void main(String[] args) {
        MarcoArea mimarco = new MarcoArea();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoArea extends JFrame {
    public MarcoArea() {

        setBounds(500, 300, 500, 350);
        LaminaArea milamina = new LaminaArea();
        add(milamina);
        setVisible(true);
    }

}

class LaminaArea extends JPanel {

    public LaminaArea() {
        JTextArea tarea = new JTextArea(8, 20);
        JScrollPane paneltarea = new JScrollPane(tarea);// agrega scroll al text area
        add(paneltarea);
        tarea.setLineWrap(true);// rergula el salto de linea si llega al borde del cuadro
        JButton miboton = new JButton("Dale");
        miboton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.out.println(tarea.getText());
            }

        });

        add(miboton);
    }

}