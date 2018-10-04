package cineGOv02;

import javax.swing.JFrame;

import org.hibernate.SessionFactory;

import cineGOv02.admin.controller.RoomCreatorController;
import cineGOv02.common.hibernate.MySQLDataSource;

/*
 * Test.java                                27 janv. 2016
 * CESI RILA 2015/2017
 */

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 */
public class Test {

    private static SessionFactory factory;
    
    public static void main(String[] args){
        factory = MySQLDataSource.getInstance().getFactory(); 
        JFrame frame = new JFrame();
        RoomCreatorController controller = new RoomCreatorController(frame, factory);
        frame.setContentPane(controller.getRoomView());
        frame.setVisible(true);
        frame.pack();
    }
}
