/*
 * QueryImpl.java                                22 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package customSQLFormer;

import java.util.ArrayList;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class QueryImpl implements Query{

    /* (non-Javadoc)
     * @see CustomSQLFormer.Query#insert(java.lang.String, java.util.ArrayList)
     */
    @Override
    public String insert(String table, ArrayList values) {
        StringBuilder rqt = new StringBuilder();
        rqt.append("INSERT INTO " + table + " VALUES(");
        for (int i = 0 ; i < values.size(); i++) {
            if(values.get(i) instanceof String){
                rqt.append("'" + values.get(i) + "',");
            }else if(values.get(i) == null){
                rqt.append("null,");
            }else{
                rqt.append(values.get(i) + ",");
            }
        }
        rqt.deleteCharAt(rqt.length()-1);
        rqt.append(");");
        return rqt.toString();
    }

    /* (non-Javadoc)
     * @see CustomSQLFormer.Query#insert(java.lang.String, java.util.ArrayList, java.util.ArrayList)
     */
    @Override
    public String insert(String table, ArrayList<String> colomns, ArrayList values) {
        StringBuilder rqt = new StringBuilder();
        rqt.append("INSERT INTO " + table);
        for (String label : colomns) {
            rqt.append(" " + label);
        }
        rqt.append(" VALUES(");
        for (int i = 0 ; i < values.size(); i++) {
            if(values.get(i) instanceof String){
                rqt.append("'" + values.get(i) + "',");
            }else if(values.get(i) == null){
                rqt.append("null,");
            }else{
                rqt.append(values.get(i) + ",");
            }
        }
        rqt.deleteCharAt(rqt.length()-1);
        rqt.append(");");
        return rqt.toString();
    }

    /* (non-Javadoc)
     * @see CustomSQLFormer.Query#delete(java.lang.String, java.util.ArrayList)
     */
    @Override
    public String delete(String table, ArrayList<Filter> conditions) throws IllegalAccessException{
        StringBuilder rqt = new StringBuilder();
        rqt.append("DELETE FROM " + table + " WHERE ");
        if(conditions == null || conditions.size() == 0){
            throw new IllegalArgumentException("No condition find ! "
                    + "Cannot delete something without condition");
        }else if(conditions.size() == 1){
            rqt.append(conditions.get(0));
        }else{
            rqt.append(conditions.get(0));
            for (int i = 1; i<conditions.size();i++) {
                rqt.append(" AND " + conditions.get(i));
            }
        }
        rqt.append(";");


        return null;
    }

    /* (non-Javadoc)
     * @see CustomSQLFormer.Query#select(java.lang.String, java.util.ArrayList, java.util.ArrayList)
     */
    @Override
    public String select(String table, ArrayList<String> values, ArrayList<Filter> conditions) {
        StringBuilder rqt = new StringBuilder();
        rqt.append("SELECT ");
        if(values == null || values.size() == 0){
            rqt.append("* ");
        }
        rqt.append("FROM " + table);
        if(conditions == null || conditions.size() == 0){
            rqt.append(";");
            return rqt.toString();
        }else{
            rqt.append(" WHERE");
            if(conditions.size() == 1){
                rqt.append(conditions.get(0));
            }else{
                rqt.append(conditions.get(0));
                for (int i = 1; i<conditions.size();i++) {
                    rqt.append(" AND " + conditions.get(i));
                }
            }
            rqt.append(";");
        }
        return rqt.toString();
    }

}
