
package costal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion 
{
    public static Connection getConnection()
    {
        Connection con = null;
        
        String bd = "clientes"; // la base de datos
        String url = "jdbc:mysql://localhost:3306/"+bd; 
        String user = "root";// el usuario que ustedes tienen
        String pass = "metal12.gear_A";// la clave que ustedes tienen
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection)DriverManager.getConnection(url, user, pass);
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        return con;
    }
        
}