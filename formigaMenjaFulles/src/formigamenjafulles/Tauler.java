/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formigamenjafulles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author bartomeu
 */
public class Tauler extends JPanel {

    private static final int MAXIM = 1000;
    private static final int COSTAT = 50;

    private Cella[][] tauler;

    public Tauler() {
        this.tauler = new Cella[20][20];
        int y = 0;
        for (int i = 0; i < this.tauler.length; i++) {
            int x = 0;
            for (int j = 0; j < this.tauler[i].length; j++) {
                Rectangle2D.Float casella = new Rectangle2D.Float(x, y, COSTAT, COSTAT);
                x += COSTAT;
                Color color;
                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    color = Color.WHITE;
                } else {
                    color = Color.BLACK;
                }
                tauler[i][j] = new Cella(casella);

            }
            y += COSTAT;
        }
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

}
