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

    public void canviarDireccióFormiga(String direccio) {
        switch (direccio) {
            case "amunt":
                super.setFitxerImatge("img/hormiga_n.png");
                
                break;
            case "abaix":
                super.setFitxerImatge("img/hormiga_s.png");
                break;
            case "dreta":
                super.setFitxerImatge("img/hormiga_e.png");
                break;
            case "esquerra":
                super.setFitxerImatge("img/hormiga_o.png");
                break;
        }
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
