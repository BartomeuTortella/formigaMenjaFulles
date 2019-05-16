/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formigamenjafulles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author bartomeu
 */
//Classe Figura que es la classe pare de totes les altres figures
public class Figura {
    //declaració de la variable per tenir el nom del fitxer de la imatge
    private String nomFitxerImatge;
    //buffer per podere tenir la imatge i poder pintar-la
    private BufferedImage imatge;

    public Figura(String fitxerImatge) {
        //inicialitzam les variables
        this.nomFitxerImatge = fitxerImatge;
        this.imatge = agafarImatge();
    }

    public String getNomFitxerImatge() {
        //ens retorna el nom del fitxer de la imatge
        return nomFitxerImatge;
    }

    public void setNomFitxerImatge(String nomFitxerImatge) {
        // metode per canviar el fitxer de la imatge
        this.nomFitxerImatge = nomFitxerImatge;
        //un cop s'ha canviat el nom del fitxer s'ha de refrescar el buffer
        //amb la nova imatge i per això cridam a aquest metode 
        this.imatge = agafarImatge();

    }

    void paintComponent(Graphics g, float x, float y) {
        //ens pinta la imatge amb les dimensions correctes
        g.drawImage(imatge, (int) x + 10, (int) y + 10, null);
    }

    private BufferedImage agafarImatge() {
        // metode per regrescar el buffer de la imatge
        //cream un buffer temporal, s'ha creat aquest buffer per evitar que en 
        //cas de que hi hagi un error ens llevi la imatge anterior
        BufferedImage img = null;
        try {
            //intentam llegit la imatge que està a la direcció de nomFitxerImatge
            img = ImageIO.read(new File(nomFitxerImatge));
        } catch (IOException e) {
            System.out.println(e);
        }
        //retorna el buffer de la imatge per poder usar-ho al buffer de la classe
        return img;
    }

}
