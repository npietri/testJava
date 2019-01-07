package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Prepare {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/Ecole";
            String user = "postgres";
            String passwd = "manolo";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
               
            //On cr�e la requ�te
            String query = "SELECT prof_nom, prof_prenom FROM professeur";
            //Premier trou pour le nom du professeur
            query += " WHERE prof_nom = ?";
            //Deuxi�me trou pour l'identifiant du professeur
            query += " OR prof_id = ?";
               
            //On cr�e l'objet avec la requ�te en param�tre
            PreparedStatement prepare = conn.prepareStatement(query);
            //On remplace le premier trou par le nom du professeur
            prepare.setString(1, "MAMOU");
            //On remplace le deuxi�me trou par l'identifiant du professeur
            prepare.setInt(2, 2);
            //On affiche la requ�te ex�cut�e
            System.out.println(prepare.toString());
            //On modifie le premier trou
            prepare.setString(1, "TOTO");
            //On affiche � nouveau la requ�te ex�cut�e
            System.out.println(prepare.toString());
            //On modifie le deuxi�me trou
            prepare.setInt(2, 159753);
            //On affiche une nouvelle fois la requ�te ex�cut�e
            System.out.println(prepare.toString());
               
            prepare.close();
            state.close();

          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }