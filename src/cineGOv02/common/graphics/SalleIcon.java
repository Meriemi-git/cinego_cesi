/*
 * SalleIcon.java                                12 févr. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.common.graphics;

import javax.swing.JLabel;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class SalleIcon extends JLabel {
    /** TODO commenter le Champ */
    private int x;
    /** TODO commenter le Champ */
    private int y;
    /** TODO commenter le Champ */
    private boolean set;
    
    private boolean ecran;
    /**
     * @return le x
     */
    public int getAnX() {
        return x;
    }
    /**
     * @param x le x to set
     */
    public void setAnX(int x) {
        this.x = x;
    }
    /**
     * @return le y
     */
    public int getAnY() {
        return y;
    }
    /**
     * @param y le y to set
     */
    public void setAnY(int y) {
        this.y = y;
    }
    /**
     * @return le set
     */
    public boolean isSet() {
        return set;
    }
    /**
     * @param set le set to set
     */
    public void setSet(boolean set) {
        this.set = set;
    }
    /**
     * @return le ecran
     */
    public boolean isEcran() {
        return ecran;
    }
    /**
     * @param ecran le ecran to set
     */
    public void setEcran(boolean ecran) {
        this.ecran = ecran;
    }

}
