/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formigamenjafulles;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author bartomeu
 */
public class Cella {

    //declaracions de variables
    //declaració de teFulla que es un boolea per poder comprovar si s'ha de pintar un buit o una fulla
    private boolean teFulla;
    //variable figura de la classe Figura
    private Figura figura;
    //declaraicó del rectangle de la cel·la i es final ja que no s'ha de modificar
    private final Rectangle2D.Float rectangle;

    public Cella(Rectangle2D.Float r, Figura figura) {
        //inicialitzam el rectangle 
        this.rectangle = r;
        //inicialitzam la figura
        this.figura = figura;
    }

    public void paintComponent(Graphics g) {
        //metode per pintar el component i crida al paintComponent de la figura
        this.figura.paintComponent(g, this.rectangle.x, this.rectangle.y);
    }

    public boolean TeFulla() {
        //metode que ens mira si la cel·la té fulla o no
        return teFulla;
    }

    public void setTeFulla(boolean teFulla) {
        //metode per poder posar si una cel·la ha de tenir fulla o no
        this.teFulla = teFulla;
    }

    public Figura getFigura() {
        //metode que retorna la figura de la cel·la
        return figura;
    }

    public void setFigura(Figura figura) {
        //metode per poder canviar la figura de la cel·la
        this.figura = figura;
    }

}
