/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formigamenjafulles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author bartomeu
 */
public class Tauler extends JPanel implements KeyListener {

    private static final int MAXIM = 820;
    private static final int COSTAT = 40;
    int randomX = ThreadLocalRandom.current().nextInt(0, 20);
    int randomY = ThreadLocalRandom.current().nextInt(0, 20);
    private Cella[][] tauler;
    private Formiga formiga = new Formiga();

    public Tauler() {
        this.tauler = new Cella[20][20];
        this.setFocusable(true);
        this.addKeyListener(this);
        int y = 0;
        for (int i = 0; i < this.tauler.length; i++) {
            int x = 0;
            for (int j = 0; j < this.tauler[i].length; j++) {
                Rectangle2D.Float casella = new Rectangle2D.Float(x, y, COSTAT, COSTAT);
                x += COSTAT;
                Figura figura;
                if (i == randomX && j == randomY) {
                    figura = formiga;
                    formiga.setPosicioX(i);
                    formiga.setPosicioY(j);
                    tauler[i][j] = new Cella(casella, figura);
                } else {
                    figura = new Fulla();
                    tauler[i][j] = new Cella(casella, figura);
                }

            }
            y += COSTAT;
        }
    }

    public void moureFormiga() {

    }

    @Override
    public void paintComponent(Graphics g) {
        for (Cella[] tauler1 : tauler) {
            for (Cella tauler11 : tauler1) {
                tauler11.paintComponent(g);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MAXIM, MAXIM);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case 37:
                formiga.canviarDireccióFormiga("esquerra");
                break;
            case 38:
                formiga.canviarDireccióFormiga("amunt");
                break;
            case 39:
                formiga.canviarDireccióFormiga("dreta");

                break;
            case 40:
                formiga.canviarDireccióFormiga("abaix");
                break;
        }
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //no s'utilitza
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //no s'utilitza
    }

}
