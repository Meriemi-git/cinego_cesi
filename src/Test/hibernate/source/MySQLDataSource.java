/*
 * MySQLDataSource.java                                19 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package Test.hibernate.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class MySQLDataSource {

    /** Sigleton */
    private static MySQLDataSource singleton;

    /** user mysql */
    public static final String USER = "ChUcKn0Rr15";
    /** pwd mysql */
    public static final String PWD ="5NNMN7Dxj7MHtLym";
    /** driver mysql */
    public static final String DATABASE = "Contact_base";

    /**
     * Constructeur privé de singleton
     */
    private MySQLDataSource(){

    }

    /**
     * Return single instance of singleton and if not exist create this instance
     * @return singleton
     */
    public static MySQLDataSource getInstance(){
        if(singleton == null){
            singleton = new MySQLDataSource();
        }
        return singleton;
    }

    /**
     * Retourne un objet de type connection
     * @return Connection
     */
    public Connection getConnection(){
        Connection connect;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact_Base", USER, PWD);
            return connect;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
