package GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBconnection {
    public static Connection dConnection(){
        Connection con =null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://COT-CIS3365-02:1433;database=SakuraNailSalon;user=SakuraTest;password=Testing123!";
            con = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex ) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

}
