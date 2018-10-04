/*
 * Filter.java                                21 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package customSQLFormer;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 */
public class Filter {
    /** Opérande gauche */
    private String leftOperand;
    /** Opérande droite */
    private Object rightOperand;
    /** Opéraeur */
    private String operator;
    
    /**
     * Condition de filtrage d'une requête SQL par comparaison
     * Un filtre est composé d'une opérande gauche, d'une opérande droite 
     * et d'un opérateur parmis ceux disponible dans la syntaxe SQL
     * ( =, <, >, <> )
     * @param leftOperand Opérande gauche
     * @param rightOperand Opérande droite
     * @param operateur Opéraeur
     */
    public Filter(String leftOperand, Object rightOperand, String operateur) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operateur;
    }
    
    /**
     * Condition de filtrage d'une requête SQL par comparaison
     * Un filtre est composé d'une opérande gauche, d'une opérande droite 
     * et d'un opérateur parmis ceux disponible dans la syntaxe SQL
     * ( =, <, >, <> )
     * @param args tableau d'argument contenant 
     * args[0] left operand
     * args[1] right operand
     * args[2] operator
     */
    public Filter(String[] args) {
        this.leftOperand = args[0];
        this.rightOperand = args[1];
        this.operator = args[2];
    }
    
    /**
     * Condition de filtrage d'une requête SQL par comparaison
     * Un filtrre est composé d'une opérande gauche, d'une opérande droite 
     * et d'un opérateur parmis ceux disponible dans la syntaxe SQL
     * ( =, <, >, <> ). 
     * Ici l'opérateur est implicite il repésente le égale
     * soit : leftOperand = rightOperand
     * @param leftOperand Opérande gauche
     * @param rightOperand Opérande droite
     */
    public Filter(String leftOperand, String rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = "=";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() { 
        if(this.rightOperand instanceof String){
            return this.leftOperand + " " + this.operator + " '" + rightOperand+"'";
        }else if(this.rightOperand == null){
            return this.leftOperand + " " + this.operator + " null";
        }else{
            return this.leftOperand + " " + this.operator + " " + rightOperand; 
        }     
    }
}
