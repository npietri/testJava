package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonConnection  {

	  private static String url = "jdbc:postgresql://localhost:5432/Ecole";
	  private static String user = "postgres";
	  private static String passwd = "manolo";
	  private static Connection connect;
	   
	  public static Connection getInstance(){
	    if(connect == null){
	      try {
	        connect = DriverManager.getConnection(url, user, passwd);
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }      
	    return connect;
	  }   
	}