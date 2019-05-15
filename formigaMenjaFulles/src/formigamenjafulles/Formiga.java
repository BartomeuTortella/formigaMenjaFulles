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
enum Direccio {
    SUD, NORT, EST, OEST
}

public class Formiga extends Figura {

    private int posicioX;
    private int posicioY;
    private Direccio direccio;

    public Formiga(int posicioX, int posicioY) {
        super("img/hormiga_s.png");
        direccio = Direccio.SUD;
        this.posicioX = posicioX;
        this.posicioY = posicioY;
    }

    public void canviarDireccióFormiga(String direccio) {
        switch (direccio) {
            case "amunt":
                super.setFitxerImatge("img/hormiga_n.png");
                this.direccio = Direccio.NORT;
                break;
            case "abaix":
                super.setFitxerImatge("img/hormiga_s.png");
                this.direccio = Direccio.SUD;
                break;
            case "dreta":
                super.setFitxerImatge("img/hormiga_e.png");
                this.direccio = Direccio.EST;
                break;
            case "esquerra":
                super.setFitxerImatge("img/hormiga_o.png");
                this.direccio = Direccio.OEST;
                break;
        }
    }

    public Direccio getDireccio() {
        return direccio;
    }

    public void setDireccio(Direccio direccio) {
        this.direccio = direccio;
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
