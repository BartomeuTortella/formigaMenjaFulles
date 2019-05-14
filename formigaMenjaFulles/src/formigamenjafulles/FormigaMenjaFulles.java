/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formigamenjafulles;

import javax.swing.JFrame;

/**
 *
 * @author bartomeu
 */
public class FormigaMenjaFulles extends JFrame {

    public FormigaMenjaFulles() {
        this.setTitle("Formiga menja fulles");
        this.setSize(700, 700);
        this.setResizable(false);
        initComponents();
    }

    private void initComponents() {
        addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
    }

    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FormigaMenjaFulles().setVisible(true);

    }

}
