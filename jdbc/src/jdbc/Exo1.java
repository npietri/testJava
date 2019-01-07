package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Exo1 {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/Ecole";
            String user = "postgres";
            String passwd = "manolo";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement state = conn.createStatement();
               
            ResultSet result = state.executeQuery("SELECT * FROM professeur");
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("- Il y a " + resultMeta.getColumnCount() + " colonnes dans cette table");
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
              System.out.println("\t *" + resultMeta.getColumnName(i));        

            System.out.println("Voici les noms et prénoms : ");
            System.out.println("\n---------------------------------");

            while(result.next()){
              System.out.print("\t" + result.getString("prof_nom") + "\t |");
              System.out.print("\t" + result.getString("prof_prenom") + "\t |");
              System.out.println("\n---------------------------------");
            }

            result.close();
            state.close();
               
          } catch (Exception e) {
            e.printStackTrace();
          }      
        }   
      }