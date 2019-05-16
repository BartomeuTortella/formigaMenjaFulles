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
    //declaració del tauler
    private Tauler tauler;

    public FormigaMenjaFulles() {
        //posam el titol de la finestra
        super("Formiga menja fulles");
        //inicialitzam el tauler
        tauler = new Tauler();
        //afegim al tauler al JFrame
        this.getContentPane().add(tauler);
        //feim que la finestra tengui la mida del tauler
        this.setSize(tauler.getPreferredSize());
        this.pack();
        //feim que la finestra no es pugui canviar de mida
        this.setResizable(false);
        // feim que en cas de que l'usuari tanqui la finestra, l'execució acaba
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FormigaMenjaFulles().setVisible(true);

    }
}
