package Menu;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection conectar(){
        Connection cn =null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/menu","root","123456");
            //System.out.println("Conexion establecida");
        }catch(Exception e){
            System.out.println("Error");
        }

        return cn;
    }
}
