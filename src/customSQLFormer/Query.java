/*
 * Query.java                                21 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package customSQLFormer;

import java.util.ArrayList;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public interface Query {
    
    /**
     * Contruit une requête INSERT avec les attributs données
     * @param table Table cible de la requête
     * @param values valeur à insérer
     * @return la Chaine correspondant à la requête SQL
     */
    public String insert(String table, ArrayList values);
    
    /**
     * Contruit une requête INSERT avec les attributs données 
     * et le noms des colonnes
     * @param table Table cible de la requête
     * @param colomns liste des noms colonnes de la table
     * @param values valeur à insérer
     * @return la Chaine correspondant à la requête SQL
     */
    public String insert(String table, ArrayList<String> colomns, ArrayList values);
    
    /**
     * Contruit une requête DELETE avec les conditions passées en filtre
     * @param table Table cible de la requête
     * @param conditions Tableau de conditions
     * @param id identifier de l'entrée à supprimer
     * @return la chaine correspondant à la requête SQL
     * @throws IllegalAccessException si condition.size() = 0
     */
    public String delete(String table, ArrayList<Filter> conditions) throws IllegalAccessException;
    
    /**
     * Contruit une requête SELECT avec les attributs données
     * @param table la table ciblée par la requête
     * @param values les étiquettes des valeurs à sélectionner
     * @param conditions Tableau de conditions pour filter la requête
     * @return la chaine correspondant à la requête SQL
     */
    public String select(String table, ArrayList<String> values, ArrayList<Filter> conditions);
    
    

}
