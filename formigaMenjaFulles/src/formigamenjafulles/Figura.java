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
public class Figura {

    private String fitxerImatge;
    private BufferedImage imatge;

    public Figura(String fitxerImatge) {
        this.fitxerImatge = fitxerImatge;
        this.imatge = agafarImatge();
    }

    public String getFitxerImatge() {
        return fitxerImatge;
    }

    public void setFitxerImatge(String fitxerImatge) {
        this.fitxerImatge = fitxerImatge;
        this.imatge = agafarImatge();

    }

    void paintComponent(Graphics g, float x, float y) {
        g.drawImage(imatge, (int) x + 10, (int) y + 10, null);
    }

    private BufferedImage agafarImatge() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fitxerImatge));
        } catch (IOException e) {
            System.out.println(e);
        }
        return img;
    }

}
