package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Exo3 {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/Ecole";
            String user = "postgres";
            String passwd = "manolo";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement state = conn.createStatement();
               
            String query = "SELECT prof_nom, prof_prenom, mat_nom, cls_nom FROM professeur";
            query += " INNER JOIN j_mat_prof ON jmp_prof_k = prof_id";
            query += " INNER JOIN matiere ON jmp_mat_k = mat_id";
            query += " INNER JOIN j_cls_jmp ON jcm_jmp_k = jmp_id";
            query += " INNER JOIN classe ON jcm_cls_k = cls_id AND cls_id IN(1, 7)";
            query += " ORDER BY cls_nom DESC, prof_nom";
               
            ResultSet result = state.executeQuery(query);
            String nom = "";
            String nomClass = "";
               
            while(result.next()){            
              if(!nomClass.equals(result.getString("cls_nom"))){
                nomClass = result.getString("cls_nom");
                System.out.println("Classe de " + nomClass + " :");               
              }

              if(!nom.equals(result.getString("prof_nom"))){
                nom = result.getString("prof_nom");
                System.out.println("\t * " + nom + " " + result.getString("prof_prenom") + " enseigne : ");
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