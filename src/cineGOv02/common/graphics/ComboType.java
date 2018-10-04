/*
 * ComboType.java                                7 févr. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.common.graphics;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class ComboType extends JComboBox {

    /**
     * TODO commenter le role du Constructeur
     */
    public ComboType() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * TODO commenter le role du Constructeur
     * @param aModel
     */
    public ComboType(ComboBoxModel aModel) {
        super(aModel);
        // TODO Auto-generated constructor stub
    }

    /**
     * TODO commenter le role du Constructeur
     * @param items
     */
    public ComboType(Object[] items) {
        super(items);
        // TODO Auto-generated constructor stub
    }

    /**
     * TODO commenter le role du Constructeur
     * @param items
     */
    public ComboType(Vector items) {
        super(items);
        // TODO Auto-generated constructor stub
    }

}
