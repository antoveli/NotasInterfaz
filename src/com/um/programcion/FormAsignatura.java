package com.um.programcion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class FormAsignatura extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel panelMain;
    private JTable table1;
    private JTextField txtNota;
    private JTextField txtNombre;
    private JButton btnAgregar;
    DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
    public FormAsignatura() {

        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });



        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAsignatura();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FormAsignatura dialog = new FormAsignatura();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void agregarAsignatura()
    {
        DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
        Object[] fila = new Object[2];
        fila[0] = txtNombre.getText();
        fila[1] = Integer.parseInt( txtNota.getText());
        modelo.addRow(fila);
    }
}
