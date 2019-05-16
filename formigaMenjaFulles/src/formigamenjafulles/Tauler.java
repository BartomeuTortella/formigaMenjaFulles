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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author bartomeu
 */
public class Tauler extends JPanel implements KeyListener {

    private static final int MAXIM = 820;
    private static final int COSTAT = 40;
    private int randomX = ThreadLocalRandom.current().nextInt(0, 20);
    private int randomY = ThreadLocalRandom.current().nextInt(0, 20);
    private Cella[][] tauler;
    private int contadorFulles;
    private Formiga formiga = new Formiga(randomX, randomY);

    public Tauler() {
        this.tauler = new Cella[20][20];
        contadorFulles = 0;
        this.setFocusable(true);
        this.addKeyListener(this);
        inicialitzarTauler();
    }

    public void avancarFormiga() {
        String direccio = this.formiga.getDireccio().toString();
        int posicioX = this.formiga.getPosicioX();
        int posicioY = this.formiga.getPosicioY();

        switch (direccio) {
            case "NORT":
                if (posicioX > 0) {
                    this.formiga.setPosicioX(posicioX - 1);
                    this.tauler[posicioX][posicioY].setTeFulla(false);
                }
                break;
            case "EST":
                if (posicioY < 19) {
                    this.formiga.setPosicioY(posicioY + 1);
                    this.tauler[posicioX][posicioY].setTeFulla(false);
                }
                break;
            case "SUD":
                if (posicioX < 19) {
                    this.formiga.setPosicioX(posicioX + 1);
                    this.tauler[posicioX][posicioY].setTeFulla(false);
                }
                break;
            case "OEST":
                if (posicioY > 0) {
                    this.formiga.setPosicioY(posicioY - 1);
                    this.tauler[posicioX][posicioY].setTeFulla(false);
                }
                break;
        }
        recalcularTauler();

    }

    private void aturarExecució() {
        int input = JOptionPane
                .showOptionDialog(null,
                        "ENHORABONA\n" + " ¡¡¡has completat el joc!!!\n" + " LA FORMIGA S'HA MENJAT TOTES LES FULLES",
                        "Has completat el joc",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (input == 0) {
            System.exit(0);
        }
    }

    private void inicialitzarTauler() {
        int y = 0;
        for (int i = 0; i < this.tauler.length; i++) {
            int x = 0;
            for (int j = 0; j < this.tauler[i].length; j++) {
                Rectangle2D.Float casella = new Rectangle2D.Float(x, y, COSTAT, COSTAT);
                x += COSTAT;
                Figura figura;
                if (i == formiga.getPosicioX() && j == formiga.getPosicioY()) {
                    figura = formiga;
                    formiga.setPosicioX(i);
                    formiga.setPosicioY(j);
                    tauler[i][j] = new Cella(casella, figura);
                } else {
                    figura = new Fulla();
                    tauler[i][j] = new Cella(casella, figura);
                    tauler[i][j].setTeFulla(true);
                }

            }
            y += COSTAT;
        }
    }

    private void recalcularTauler() {
        int y = 0;
        for (int i = 0; i < this.tauler.length; i++) {
            int x = 0;
            for (int j = 0; j < this.tauler[i].length; j++) {
                Rectangle2D.Float casella = new Rectangle2D.Float(x, y, COSTAT, COSTAT);
                x += COSTAT;
                Figura figura;
                if (i == formiga.getPosicioX() && j == formiga.getPosicioY()) {
                    figura = formiga;
                    formiga.setPosicioX(i);
                    formiga.setPosicioY(j);
                    tauler[i][j] = new Cella(casella, figura);
                } else if (tauler[i][j].TeFulla()) {
                    figura = new Fulla();
                    tauler[i][j] = new Cella(casella, figura);
                    tauler[i][j].setTeFulla(true);
                } else {
                    figura = new Buit();
                    tauler[i][j] = new Cella(casella, figura);
                }

            }
            y += COSTAT;
        }
        this.contadorFulles = getNumFullesMenjades();
    }

    private int getNumFullesMenjades() {
        int numFullesMenjades = 0;
        for (int i = 0; i < this.tauler.length; i++) {
            for (int j = 0; j < this.tauler[i].length; j++) {
                if (!tauler[i][j].TeFulla()) {
                    numFullesMenjades++;
                }
            }
        }
        return numFullesMenjades;
    }

    @Override
    public void paintComponent(Graphics g) {
        for (Cella[] tauler1 : tauler) {
            for (Cella tauler11 : tauler1) {
                tauler11.paintComponent(g);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MAXIM, MAXIM);
    }

    @Override
    public void keyPressed(KeyEvent e
    ) {
        int key = e.getKeyCode();
        switch (key) {
            case 37:
                formiga.canviarDireccióFormiga("esquerra");
                break;
            case 38:
                formiga.canviarDireccióFormiga("amunt");
                break;
            case 39:
                formiga.canviarDireccióFormiga("dreta");
                break;
            case 40:
                formiga.canviarDireccióFormiga("abaix");
                break;
            case 32:
                avancarFormiga();

                break;
        }
        this.repaint();
        if (this.contadorFulles == 400) {
            aturarExecució();
        }
    }

    @Override
    public void keyTyped(KeyEvent e
    ) {
        //no s'utilitza
    }

    @Override
    public void keyReleased(KeyEvent e
    ) {
        //no s'utilitza
    }

}
