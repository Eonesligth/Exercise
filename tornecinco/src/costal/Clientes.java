
package costal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Clientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    }
    
    
    public boolean registrarCliente(int id, String nombres, String apellidos, String identificacion, String categoria)
    {
        String sql = "INSERT INTO clienteuno (id,nombres,apellidos,identificacion,categoria) VALUES (?,?,?,?,?)";
        
        Connection conectar;
        PreparedStatement pst;
        
        try
        {
            conectar = Conexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            pst.setInt(1,id);
            
            pst.setString(2, nombres);
            
            pst.setString(3, apellidos);
            
            pst.setString(4, identificacion);
            
            pst.setString(5, categoria);
            
            int i = pst.executeUpdate();
            
            if (i != 0)
            {
                JOptionPane.showMessageDialog(null,"Los datos se han guardado satisfactoriamente");
                
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                
                return false;
            }
            
        }
        catch(SQLException e)
        {            
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
            return false;
        }
    }
    
}