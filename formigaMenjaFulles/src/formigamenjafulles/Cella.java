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
    private Figura figura;
    private Rectangle2D.Float rectangle;

    public Cella(Rectangle2D.Float r, Figura figura) {
        this.rectangle = r;
        this.figura = figura;
    }

    public void paintComponent(Graphics g) {
        this.figura.paintComponent(g, this.rectangle.x, this.rectangle.y);
    }

    public boolean TeFulla() {
        return teFulla;
    }

    public void setTeFulla(boolean teFulla) {
        this.teFulla = teFulla;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public Rectangle2D.Float getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle2D.Float rectangle) {
        this.rectangle = rectangle;
    }

}
