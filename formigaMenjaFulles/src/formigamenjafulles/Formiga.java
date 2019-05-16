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
//enum de les 4 direccions possibles
enum Direccio {
    SUD, NORT, EST, OEST
}

//classe formiga que exten la classe figura
public class Formiga extends Figura {

    //declaració de la posició X de la formiga
    private int posicioX;
    //declaració de la posició Y de la formiga
    private int posicioY;
    //declaració de la direcció de la formiga que és del tipus Direccio enum que hem creat abans
    private Direccio direccio;

    public Formiga(int posicioX, int posicioY) {
        // inicialitzam la seva imatge
        super("img/hormiga_s.png");
        // posam una direcció fixe
        direccio = Direccio.SUD;
        //inicialitzam les dues posicions que ens passen per parametre
        this.posicioX = posicioX;
        this.posicioY = posicioY;
    }

    public void canviarDireccióFormiga(String direccio) {
        //metode que ens canvia la direcció de la formiga
        switch (direccio) {
            //en cas de que sigui amunt 
            case "amunt":
                //canviam la imatge de la formiga a nort
                super.setNomFitxerImatge("img/hormiga_n.png");
                //actualitzam el valor de la direcció                
                this.direccio = Direccio.NORT;
                break;
            case "abaix":
                //canviam la imatge de la formiga a sud
                super.setNomFitxerImatge("img/hormiga_s.png");
                //actualitzam el valor de la direcció                
                this.direccio = Direccio.SUD;
                break;
            case "dreta":
                //canviam la imatge de la formiga a est
                super.setNomFitxerImatge("img/hormiga_e.png");
                //actualitzam el valor de la direcció                
                this.direccio = Direccio.EST;
                break;
            case "esquerra":
                //canviam la imatge de la formiga a oest
                super.setNomFitxerImatge("img/hormiga_o.png");
                //actualitzam el valor de la direcció                
                this.direccio = Direccio.OEST;
                break;
        }
    }

    public Direccio getDireccio() {
        //getter de la direcció
        return direccio;
    }

    public void setDireccio(Direccio direccio) {
        //setter de la direcció
        this.direccio = direccio;
    }

    public int getPosicioX() {
        //getter de la posició X
        return posicioX;
    }

    public void setPosicioX(int posicioX) {
        // setter de la posició X
        this.posicioX = posicioX;
    }

    public int getPosicioY() {
        //getter de la posició Y
        return posicioY;
    }

    public void setPosicioY(int posicioY) {
        // setter de la posició X
        this.posicioY = posicioY;
    }

}
