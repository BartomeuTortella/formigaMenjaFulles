/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formigamenjafulles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author bartomeu
 */
public class Cella {

    private boolean teFulla;
    private boolean teFormiga;
    private Figura figura;
    private Rectangle2D.Float rectangle;

    public Cella(Rectangle2D.Float r) {
        this.rectangle = r;
        this.figura = new Fulla();
    }

    private void canviarImatge() {
        if (teFormiga && (figura instanceof Formiga)) {
            Formiga formigaTmp = (Formiga) figura;
            formigaTmp.canviarDireccióFormiga();
        } else if (teFulla && (figura instanceof Fulla)) {
            this.figura.setFitxerImatge("img/hoja.png");
        } else {
            this.figura = new Figura("img/nada.png");
        }

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(this.rectangle);
        this.figura.paintComponent(g, this.rectangle.x, this.rectangle.y);

    }
}
