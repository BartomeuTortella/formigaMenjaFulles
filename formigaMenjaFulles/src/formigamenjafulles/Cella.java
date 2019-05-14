/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formigamenjafulles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author bartomeu
 */
public class Cella {

    private boolean teFulla;
    private boolean teFormiga;
    private String fitxerImatge;
    private BufferedImage imatge;

    public Cella(boolean teFulla, boolean teFormiga, String fitxerImatge) {
        this.teFulla = teFulla;
        this.teFormiga = teFormiga;
        this.fitxerImatge = fitxerImatge;
        try {
            imatge = ImageIO.read(new File(fitxerImatge));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
