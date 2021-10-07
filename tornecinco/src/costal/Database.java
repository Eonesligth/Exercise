
package costal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
    private static String db="clientes";
    private static String user="root";
    private static String pass="metal12.gear_A";
    private static String host="localhost:3306";
    private static String server="jdbc:mysql://"+host+"/"+db;
    
    public static Connection geConnection(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection(server,user,pass);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(String.valueOf(e));
        }
        return cn;
    }
    
    public static ResultSet getTabla(String Consulta){
        Connection cn=geConnection();
        Statement st;
        ResultSet datos=null;
        try {
            st=cn.createStatement();
            datos=st.executeQuery(Consulta);
        } catch (Exception e) {System.out.print(e.toString());
        }
        return datos;
    }
}
