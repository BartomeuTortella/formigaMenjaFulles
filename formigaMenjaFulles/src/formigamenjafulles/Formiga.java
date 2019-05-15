/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formigamenjafulles;

/**
 *
 * @author bartomeu
 */
public class Formiga extends Figura {

    private int posicioX;
    private int posicioY;

    public Formiga() {
        super("img/hormiga_s.png");
        this.posicioX = 0;
        this.posicioY = 0;
    }

    public void canviarDireccióFormiga() {

    }

    public int getPosicioX() {
        return posicioX;
    }

    public void setPosicioX(int posicioX) {
        this.posicioX = posicioX;
    }

    public int getPosicioY() {
        return posicioY;
    }

    public void setPosicioY(int posicioY) {
        this.posicioY = posicioY;
    }

}
