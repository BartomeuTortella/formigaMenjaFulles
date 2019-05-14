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

    private Tauler tauler;

    public FormigaMenjaFulles() {
        super("Formiga menja fulles");
        tauler = new Tauler();
        this.getContentPane().add(tauler);
        this.setSize(tauler.getPreferredSize());
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FormigaMenjaFulles().setVisible(true);

    }

}
