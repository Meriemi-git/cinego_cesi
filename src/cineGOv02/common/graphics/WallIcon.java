/*
 * WallIcon.java                                12 févr. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.common.graphics;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class WallIcon extends SalleIcon {
    /** TODO commenter le Champ */
    private boolean ecran;
    private boolean porte;
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
    /**
     * @return le porte
     */
    public boolean isPorte() {
        return porte;
    }
    /**
     * @param porte le porte to set
     */
    public void setPorte(boolean porte) {
        this.porte = porte;
    }
}
