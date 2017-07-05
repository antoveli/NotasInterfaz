package com.um.programcion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PC on 04/07/2017.
 */
public class FormEstudiante{
    private JTextField txtNombre;
    private JTextField txtNota;
    private JTable table1;
    private JPanel panelMain;
    private JButton btnAgregar;
    private JButton btnAsignatura;
    private JButton btnRemover;


    public FormEstudiante() {
        DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
        modelo.addColumn("nombre");
        modelo.addColumn("nota");
        modelo.addColumn("promedio");
        table1.setModel(modelo);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregar();

            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("FormEstudiante");
        frame.setContentPane(new FormEstudiante ().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void agregar()
    {
        DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
        Object[] fila = new Object[2];
        fila[0] = txtNombre.getText();
        fila[1] = Integer.parseInt( txtNota.getText());
        modelo.addRow(fila);

    }
}
