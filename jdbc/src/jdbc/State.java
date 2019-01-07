package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class State {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/Ecole";
            String user = "postgres";
            String passwd = "manolo";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            //On autorise la mise � jour des donn�es 
            //Et la mise � jour de l'affichage
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            PreparedStatement prepare = conn.prepareStatement("UPDATE professeur set prof_prenom = ? "+"WHERE prof_nom = 'MAMOU'");

            //On va chercher une ligne dans la base de donn�es
            String query = "SELECT prof_nom, prof_prenom FROM professeur "+"WHERE prof_nom ='MAMOU'";         

            //On ex�cute la requ�te
            ResultSet res = state.executeQuery(query);
            res.first();
            //On affiche
            System.out.println("\n\tDONNEES D'ORIGINE : ");
            System.out.println("\t-------------------");
            System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " +  res.getString("prof_prenom"));

            //On param�tre notre requ�te pr�par�e
            prepare.setString(1, "G�rard");
            //On ex�cute
            prepare.executeUpdate();

            res = state.executeQuery(query);
            res.first();
            //On affiche � nouveau
            System.out.println("\n\t\t APRES MAJ : ");
            System.out.println("\t\t * NOM : " + res.getString("prof_nom") + " - PRENOM :" + res.getString("prof_prenom"));
                        
            //On effectue une mise � jour
            prepare.setString(1, "Daniel");
            prepare.executeUpdate();
               
            res = state.executeQuery(query);
            res.first();
            //On affiche une nouvelle fois
            System.out.println("\n\t\t REMISE A ZERO : ");
            System.out.println("\t\t * NOM : " + res.getString("prof_nom") + " - PRENOM :" + res.getString("prof_prenom"));

            prepare.close();
            res.close();
            state.close();         
          } catch (ClassNotFoundException e) {
            e.printStackTrace();
          } catch (SQLException e) {
            e.printStackTrace();
          }      
        }
      }