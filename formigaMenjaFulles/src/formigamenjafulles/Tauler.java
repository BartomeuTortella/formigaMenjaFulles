/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formigamenjafulles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author bartomeu
 */
public class Tauler extends JPanel implements KeyListener {

    //definim una constant per saber la mida màxima del tauler
    private static final int MAXIM = 820;
    // definim una constant per saber la mida de cada cel·la
    private static final int COSTAT = 40;
    //cream una posició aleatoria de X per la formiga, és final perquè no s'ha de modificar 
    private final int randomX = ThreadLocalRandom.current().nextInt(0, 20);
    //cream una posició aleatoria de Y per la formiga, és final perquè no s'ha de modificar 
    private final int randomY = ThreadLocalRandom.current().nextInt(0, 20);
    //Declaram el tauler com una conjunt de cel·les, final ja que no volem que es pugui canviar la configuració del tauler
    private final Cella[][] tauler;
    //declaram un contador de fulles per saber quan s'ha d'acabar
    private int contadorFulles;
    // declaram un objecte Formiga que serà  final ja que no volem que es pugui canviar d'objecte en cap moment 
    private final Formiga formiga = new Formiga(randomX, randomY);
    //variable que ens diu el nombre de fulles que hi ha
    private final int nombreFulles;

    public Tauler() {
        //inicialitzam el tauler
        this.tauler = new Cella[20][20];
        //inicialitzam el valor de nombre fulles
        nombreFulles = tauler.length * tauler[0].length;
        System.out.println(nombreFulles);
        //posam el contador de fulles a 0
        contadorFulles = 0;
        //feim que tengui el focus per poder usar el keylistener
        this.setFocusable(true);
        //afegeim el keyListener
        this.addKeyListener(this);
        //cridam al mètode que inicialitza el tauler
        inicialitzarTauler();
    }

    public void avancarFormiga() {
        //metode que fa avançar la formiga 
        //agafam la direcció de la formiga
        String direccio = this.formiga.getDireccio().toString();
        //agafam la posició de X i Y de la formiga
        int posicioX = this.formiga.getPosicioX();
        int posicioY = this.formiga.getPosicioY();
        //miram que val la direcció
        switch (direccio) {
            //en cas de que sigui NORT
            case "NORT":
                //miram que sigui més gran que 0, per estar sempre dins els limits
                if (posicioX > 0) {
                    //si es així llevam 1 a la posició actual de la formiga
                    this.formiga.setPosicioX(posicioX - 1);
                    //llevam la fulla de la posció per la que ha passat
                    this.tauler[posicioX][posicioY].setTeFulla(false);
                }
                break;
            //en cas de que sigui EST
            case "EST":
                //miram que sigui més petita que 19, per estar sempre dins els limits
                if (posicioY < 19) {
                    // si és així afegim 1 a la posició actual de la formiga
                    this.formiga.setPosicioY(posicioY + 1);
                    //llevam la fulla de la posció per la que ha passat
                    this.tauler[posicioX][posicioY].setTeFulla(false);
                }
                break;
            //en cas de que sigui SUD
            case "SUD":
                //miram que sigui més petita que 19, per estar sempre dins els limits
                if (posicioX < 19) {
                    // si és així afegim 1 a la posició actual de la formiga
                    this.formiga.setPosicioX(posicioX + 1);
                    //llevam la fulla de la posció per la que ha passat
                    this.tauler[posicioX][posicioY].setTeFulla(false);
                }
                break;
            //en cas de que sigui OEST
            case "OEST":
                //miram que sigui més gran que 0, per estar sempre dins els limits
                if (posicioY > 0) {
                    // si és així afegim 1 a la posició actual de la formiga
                    this.formiga.setPosicioY(posicioY - 1);
                    //llevam la fulla de la posció per la que ha passat
                    this.tauler[posicioX][posicioY].setTeFulla(false);
                }
                break;
        }
        //cirdam al metode que ens recalcula en tauler
        recalcularTauler();

    }

    private void aturarExecucio() {
        //metode que mostra un missatge de que l'usuari ha acabat i atura l'execució del programa 
        // es mostra el missatge a l'usuari
        int input = JOptionPane
                .showOptionDialog(null,
                        "ENHORABONA\n" + " ¡¡¡has completat el joc!!!\n" + " LA FORMIGA S'HA MENJAT TOTES LES FULLES",
                        "Has completat el joc",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, null, null);
        // atura l'execució del programa
        System.exit(0);
    }

    private void inicialitzarTauler() {
        //metode per inicialitzar el tauler el primer pic
        //declaram aquesta variable per poder posar cada cassella a la seva posició
        int y = 0;
        for (int i = 0; i < this.tauler.length; i++) {
            //declaram aquesta variable per poder posar cada cassella a la seva posició
            int x = 0;
            for (int j = 0; j < this.tauler[i].length; j++) {
                //declaram el rectangle casella
                Rectangle2D.Float casella = new Rectangle2D.Float(x, y, COSTAT, COSTAT);
                // afegim el tamany de la casella que s'ha creat a X perquè la pròxima estigui al seu costat
                x += COSTAT;
                //declaram un objecte figura fora inicialitzar
                Figura figura;
                //miram si és la posció de la formiga
                if (i == formiga.getPosicioX() && j == formiga.getPosicioY()) {
                    //en cas de que ho sigui ficam la formiga fins l'objecte Figura que acabam de crear
                    figura = formiga;
                    // posam la posició de la formiga a aquestes cordenades
                    formiga.setPosicioX(i);
                    formiga.setPosicioY(j);
                    //ficam un nou objecte casella amb les propietat que hem creat
                    tauler[i][j] = new Cella(casella, figura);
                } else {
                    //ficam un nou objecte fulla dins l'objecte figura que hem creat
                    figura = new Fulla();
                    //ficam un nou objecte casella amb les propietat que hem creat
                    tauler[i][j] = new Cella(casella, figura);
                    //canviam el valor de si teFulla a true
                    tauler[i][j].setTeFulla(true);
                }
            }
            // afegim el tamany de la casella que s'ha creat a Y perquè la pròxima estigui al seu costat
            y += COSTAT;
        }
    }

    private void recalcularTauler() {
        //metode per recalcular el tauler
        //declaram aquesta variable per poder posar cada cassella a la seva posició
        int y = 0;
        for (int i = 0; i < this.tauler.length; i++) {
            //declaram aquesta variable per poder posar cada cassella a la seva posició
            int x = 0;
            for (int j = 0; j < this.tauler[i].length; j++) {
                //declaram el rectangle casella
                Rectangle2D.Float casella = new Rectangle2D.Float(x, y, COSTAT, COSTAT);
                // afegim el tamany de la casella que s'ha creat a X perquè la pròxima estigui al seu costat
                x += COSTAT;
                //declaram un objecte figura fora inicialitzar
                Figura figura;
                //miram si és la posció de la formiga
                if (i == formiga.getPosicioX() && j == formiga.getPosicioY()) {
                    //en cas de que ho sigui ficam la formiga fins l'objecte Figura que acabam de crear
                    figura = formiga;
                    // posam la posició de la formiga a aquestes cordenades
                    formiga.setPosicioX(i);
                    formiga.setPosicioY(j);
                    //ficam un nou objecte casella amb les propietat que hem creat
                    tauler[i][j] = new Cella(casella, figura);
                    //miram que la posició tengui fulla
                } else if (tauler[i][j].TeFulla()) {
                    // en cas de que aixi siguificam un nou objecte fulla dins l'objecte figura que hem creat
                    figura = new Fulla();
                    //ficam un nou objecte casella amb les propietat que hem creat
                    tauler[i][j] = new Cella(casella, figura);
                    //canviam el valor de si teFulla a true
                    tauler[i][j].setTeFulla(true);
                } else {
                    //si no compleix cap de les dues condicions ha de ser un buit 
                    //ficam un nou objecte Buit a figura
                    figura = new Buit();
                    //ficam un nou objecte casella amb les propietat que hem creat
                    tauler[i][j] = new Cella(casella, figura);
                }

            }
            // afegim el tamany de la casella que s'ha creat a Y perquè la pròxima estigui al seu costat
            y += COSTAT;
        }
        //actualitzam el nombre de fulles que s'han menjat
        this.contadorFulles = getNumFullesMenjades();
    }

    private int getNumFullesMenjades() {
        //metode que ens retorna el numero de fulles que s'ha menjat la formiga
        //inicialitzam aquesta variable temporal a 0
        int numFullesMenjades = 0;
        //recorrem el tauler
        for (int i = 0; i < this.tauler.length; i++) {
            for (int j = 0; j < this.tauler[i].length; j++) {
                if (!tauler[i][j].TeFulla()) {
                    //en cas de que la posició i j no tengui fulla incrementam en un la variable temporal
                    numFullesMenjades++;
                }
            }
        }
        //retornam el valor de la variable temporal 
        return numFullesMenjades;
    }

    @Override
    public void paintComponent(Graphics g) {
        //metode sobrescrit per pintar les cel·les 
        for (Cella[] tauler1 : tauler) {
            for (Cella tauler11 : tauler1) {
                //cridam al metode paintComponent de cada cel·la
                tauler11.paintComponent(g);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        //metode que retorna la dimensió de tauler
        return new Dimension(MAXIM, MAXIM);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //metode sobreescrit que es crida quan es pitja una tecla
        //miram el codi de la tecla i ho ficam dins una variable key
        int key = e.getKeyCode();
        switch (key) {
            //en cas de que sigui 37 (esquerra)
            case 37:
                //canviam la direcció de la formiga
                formiga.canviarDireccióFormiga("esquerra");
                break;
            //en cas de que sigui 38 (amunt)
            case 38:
                //canviam la direcció de la formiga
                formiga.canviarDireccióFormiga("amunt");
                break;
            //en cas de que sigui 39 (dreta)
            case 39:
                //canviam la direcció de la formiga
                formiga.canviarDireccióFormiga("dreta");
                break;
            //en cas de que sigui 40 (abaix)
            case 40:
                //canviam la direcció de la formiga
                formiga.canviarDireccióFormiga("abaix");
                break;
            //en cas de que sigui 32 (espai)
            case 32:
                //cridam al mètode per fer avançar la formiga
                avancarFormiga();
                break;
        }
        //tornam a repintar el tauler
        this.repaint();
        //reviam que el contador no sigui el nombre màxim de fulles
        if (this.contadorFulles == nombreFulles) {
            //en cas de que ho sigui cridam a aturarExeccució
            aturarExecucio();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //no s'utilitza
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //no s'utilitza
    }

}
