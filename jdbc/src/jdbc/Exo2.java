package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Exo2 {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/Ecole";
            String user = "postgres";
            String passwd = "manolo";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement state = conn.createStatement();

            String query = "SELECT prof_nom, prof_prenom, mat_nom FROM professeur";
            query += " INNER JOIN j_mat_prof ON jmp_prof_k = prof_id";
            query += " INNER JOIN matiere ON jmp_mat_k = mat_id ORDER BY prof_nom";

            ResultSet result = state.executeQuery(query);
            String nom = "";

            while(result.next()){            
              if(!nom.equals(result.getString("prof_nom"))){
                nom = result.getString("prof_nom");
                System.out.println(nom + " " + result.getString("prof_prenom") + " enseigne : ");
              }
              System.out.println("\t\t\t - " +  result.getString("mat_nom"));
            }

            result.close();
            state.close();

          } catch (Exception e) {
            e.printStackTrace();
          }      
        }
      }