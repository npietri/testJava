package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Resultset {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/Ecole";
            String user = "postgres";
            String passwd = "manolo";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               
            String query = "SELECT prof_nom, prof_prenom FROM professeur";         
            ResultSet res = state.executeQuery(query);
            int i = 1;         
               
            System.out.println("\n\t---------------------------------------");
            System.out.println("\tLECTURE STANDARD.");
            System.out.println("\t---------------------------------------");
               
            while(res.next()){
              System.out.println("\tNom : "+res.getString("prof_nom") +" \t pr�nom : "+res.getString("prof_prenom"));
              //On regarde si on se trouve sur la derni�re ligne du r�sultat
              if(res.isLast())
                System.out.println("\t\t* DERNIER RESULTAT !\n");
              i++;
            }
               
            //Une fois la lecture termin�e, on contr�le si on se trouve bien � l'ext�rieur des lignes de r�sultat
            if(res.isAfterLast())
              System.out.println("\tNous venons de terminer !\n");
               
            System.out.println("\t---------------------------------------");
            System.out.println("\tLecture en sens contraire.");
            System.out.println("\t---------------------------------------");
               
            //On se trouve alors � la fin
            //On peut parcourir le r�sultat en sens contraire
            while(res.previous()){
              System.out.println("\tNom : "+res.getString("prof_nom") +" \t pr�nom : "+res.getString("prof_prenom"));

              //On regarde si on se trouve sur la premi�re ligne du r�sultat
              if(res.isFirst())
                System.out.println("\t\t* RETOUR AU DEBUT !\n");
            }
               
            //On regarde si on se trouve avant la premi�re ligne du r�sultat
            if(res.isBeforeFirst())
              System.out.println("\tNous venons de revenir au d�but !\n");
               
            System.out.println("\t---------------------------------------");
            System.out.println("\tApr�s positionnement absolu du curseur � la place N� "+ i/2 + ".");
            System.out.println("\t---------------------------------------");
            //On positionne le curseur sur la ligne i/2
            //Peu importe o� on se trouve
            res.absolute(i/2);
            while(res.next())
              System.out.println("\tNom : "+res.getString("prof_nom") +" \t pr�nom : "+ res.getString("prof_prenom"));
               
            System.out.println("\t---------------------------------------");
            System.out.println("\tApr�s positionnement relatif du curseur � la place N� "+(i-(i-2)) + ".");
            System.out.println("\t---------------------------------------");
            //On place le curseur � la ligne actuelle moins i-2
            //Si on n'avait pas mis de signe moins, on aurait avanc� de i-2 lignes 
            res.relative(-(i-2));
            while(res.next())
              System.out.println("\tNom : "+res.getString("prof_nom") +" \t pr�nom : "+res.getString("prof_prenom"));
               
            res.close();
            state.close();

          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }