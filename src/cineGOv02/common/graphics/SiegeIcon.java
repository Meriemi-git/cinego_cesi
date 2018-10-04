/*
 * SiegeIcon.java                                10 févr. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.common.graphics;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class SiegeIcon extends SalleIcon {
    /** TODO commenter le Champ */
    private boolean normal = false;
    /** TODO commenter le Champ */
    private boolean hand = false;
    /** TODO commenter le Champ */
    private boolean allee = false;
    
    /** TODO commenter le Champ */
    private boolean occupe = false;
    /**
     * TODO commenter le role du Constructeur
     */
    public SiegeIcon(){
    }
   
    /**
     * @return le normal
     */
    public boolean isNormal() {
        return normal;
    }
    /**
     * @param normal le normal to set
     */
    public void setNormal(boolean normal) {
        this.normal = normal;
    }
    /**
     * @return le hand
     */
    public boolean isHand() {
        return hand;
    }
    /**
     * @param hand le hand to set
     */
    public void setHand(boolean hand) {
        this.hand = hand;
    }
    /**
     * @return le allee
     */
    public boolean isAllee() {
        return allee;
    }
    /**
     * @param allee le allee to set
     */
    public void setAllee(boolean allee) {
        this.allee = allee;
    }

    /**
     * @return le occupe
     */
    public boolean isOccupe() {
        return occupe;
    }

    /**
     * @param occupe le occupe to set
     */
    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }
 
}
