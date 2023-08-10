package Menu;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu {
    public void getMenuComida() throws SQLException {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane
                    .showInputDialog("Menu\n1. Desayuno\n2. Almuerzo\n3.Cena\n4. Menu producto\n5. Salir\n"));
            getOpciones(opcion);
        } while (opcion != 5);

    }

    public void getOpciones(int opcion) throws SQLException {
        switch (opcion) {
            case 1:
                getDesayuno();

                break;
            case 2:
                getAlmuerzo();
                break;
            case 3:
                getCena();
                break;
            case 4:
                getMenuCrud();
                break;
            case 5:
                getSalir();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    public void getDesayuno() throws SQLException {
        String desayuno = "";
        String query = "select Nombre from desayuno";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        ResultSet res = stm.executeQuery();
        int i = 0;
        String mensaje = "Desayuno Saludable: " + "\n";
        while (res.next()) {
            i++;
            desayuno += (i) + " - " + res.getString(1) + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje + desayuno);

    }

    public void getSalir() {
        JOptionPane.showMessageDialog(null, "Usted salio del sistema\nVuelva pronto");
    }

    public void getAlmuerzo() throws SQLException {
        String almuerzo = "";
        String query = "select Nombre from almuerzo";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        ResultSet res = stm.executeQuery();
        String mensaje = "Almuerzo Saludable: " + "\n";
        int i = 0;
        while (res.next()) {
            i++;
            almuerzo += (i) + " - " + res.getString(1) + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje + almuerzo);
    }

    public void getCena() throws SQLException {
        String cena = "";
        String query = "select Nombre from cena";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        ResultSet res = stm.executeQuery();
        String mensaje = "Cena Saludable: " + "\n";
        int i = 0;
        while (res.next()) {
            i++;
            cena += (i) + " - " + res.getString(1) + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje + cena);
    }

    public void getMenuCrud() throws SQLException {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Menu de Alimentos\n1. Agregar Desayuno\n2. Agregar Almuerzo\n3. Agregar Cena\n4. Actualizar Desayuno\n5. Actualizar Almuerzo\n6. Actualizar Cena\n7. Eliminar Desayuno\n8. Eliminar Almuerzo\n9. Eliminar Cena\n10. Regresar al Menu\n"));
            getOpcionesProducto(opcion);
        } while (opcion != 10);
    }

    public void getOpcionesProducto(int opcion) throws SQLException {
        switch (opcion) {
            case 1:
                String nombre_desayuno = JOptionPane.showInputDialog(null, "Ingrese el producto: ");
                getAgregarDesayuno(nombre_desayuno);
                break;
            case 2:
                String nombre_almuerzo = JOptionPane.showInputDialog(null, "Ingrese el producto: ");
                getAgregarAlmuerzo(nombre_almuerzo);
                break;
            case 3:
                String nombre_cena = JOptionPane.showInputDialog(null, "Ingrese el producto: ");
                getAgregarCena(nombre_cena);
                break;
            case 4:
                String nombre_actu_desayuno = JOptionPane.showInputDialog(null, "Ingrese el producto: ");
                int Id_desayuno = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el Id: "));
                getActualizarDesayuno(nombre_actu_desayuno, Id_desayuno);
                break;
            case 5:
                String nombre_actu_almuerzo = JOptionPane.showInputDialog(null, "Ingrese el producto: ");
                int Id_almuerzo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el Id: "));
                getActualizarAlmuerzo(nombre_actu_almuerzo, Id_almuerzo);
                break;
            case 6:
                String nombre_actu_cena = JOptionPane.showInputDialog(null, "Ingrese el producto: ");
                int Id_cena = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el Id: "));
                getActualizarCena(nombre_actu_cena, Id_cena);
                break;
            case 7:
                int eliminar_desayuno = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite id ha eliminar: "));
                getEliminarDesayuno(eliminar_desayuno);
                break;
            case 8:
                int eliminar_almuerzo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite id ha eliminar: "));
                getEliminarAlmuerzo(eliminar_almuerzo);
                break;
            case 9:
                int eliminar_cena = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite id ha eliminar: "));
                getEliminarCena(eliminar_cena);
                break;
            case 10:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida ");
                break;
        }
    }

    public void getAgregarDesayuno(String nombre) throws SQLException {
        String query = "insert into desayuno(Nombre)values(?)";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        stm.setString(1, nombre);
        stm.execute();
        JOptionPane.showMessageDialog(null, "El producto " + nombre + " se agrego ");
    }

    public void getAgregarAlmuerzo(String nombre) throws SQLException {
        String query = "insert into almuerzo(Nombre)values(?)";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        stm.setString(1, nombre);
        stm.execute();
        JOptionPane.showMessageDialog(null, "El producto " + nombre + " se agrego ");
    }

    public void getAgregarCena(String nombre) throws SQLException {
        String query = "insert into cena(Nombre)values(?)";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        stm.setString(1, nombre);
        stm.execute();
        JOptionPane.showMessageDialog(null, "El producto " + nombre + " se agrego ");
    }

    public void getActualizarDesayuno(String nombre, int id) throws SQLException {
        String query = "update desayuno set Nombre=? where Id_desayuno=?";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        stm.setString(1, nombre);
        stm.setInt(2, id);
        stm.execute();
        JOptionPane.showMessageDialog(null, "El producto " + nombre + " se actualizo ");
    }

    public void getActualizarAlmuerzo(String nombre, int id) throws SQLException {
        String query = "update almuerzo set Nombre=? where Id_almuerzo=?";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        stm.setString(1, nombre);
        stm.setInt(2, id);
        stm.execute();
        JOptionPane.showMessageDialog(null, "El producto " + nombre + " se actualizo ");
    }

    public void getActualizarCena(String nombre, int id) throws SQLException {
        String query = "update cena set Nombre=? where Id_cena=?";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        stm.setString(1, nombre);
        stm.setInt(2, id);
        stm.execute();
        JOptionPane.showMessageDialog(null, "El producto " + nombre + " se actualizo ");
    }

    public void getEliminarDesayuno(int id) throws SQLException {
        String query = "delete from desayuno where Id_desayuno=?";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        stm.setInt(1, id);
        stm.execute();
        JOptionPane.showMessageDialog(null, "El id " + id + " se elimino ");
    }

    public void getEliminarAlmuerzo(int id) throws SQLException {
        String query = "delete from almuerzo where Id_almuerzo=?";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        stm.setInt(1, id);
        stm.execute();
        JOptionPane.showMessageDialog(null, "El id " + id + " se elimino ");
    }

    public void getEliminarCena(int id) throws SQLException {
        String query = "delete from cena where Id_cena=?";
        PreparedStatement stm = Conexion.conectar().prepareStatement(query);
        stm.setInt(1, id);
        stm.execute();
        JOptionPane.showMessageDialog(null, "El id " + id + " se elimino ");
    }
}
