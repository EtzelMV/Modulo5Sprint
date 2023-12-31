
package grupal.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grupal.modelo.Capacitacion;

/**
 * @author Etzel M. Valderrama
 *
 */
public class CapacitacionDAO {
	private Connection conexion;

    public CapacitacionDAO() {
    	// Obtener la conexión al crear una instancia de CapacitacionDAO
    	conexion = ConexionBD.getInstancia().getConexion();
    }
    
    // Métodos CRUD
    public List<Capacitacion> obtenerCapacitaciones() {
        List<Capacitacion> capacitaciones = new ArrayList<>();
        String consulta = "SELECT idcapacitacion, nombre, horario, fecha FROM capacitacion";

        try (PreparedStatement statement = conexion.prepareStatement(consulta);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Capacitacion capacitacion = new Capacitacion();
                capacitacion.setId(resultSet.getInt("idcapacitacion"));
                capacitacion.setNombre(resultSet.getString("nombre"));
                capacitacion.setHorario(resultSet.getString("horario"));
                capacitacion.setFecha(resultSet.getString("fecha"));
                capacitaciones.add(capacitacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return capacitaciones;
    }

    public Capacitacion obtenerCapacitacionPorId(int id) {
        Capacitacion capacitacion = null;
        String consulta = "SELECT idcapacitacion, nombre, horario, fecha FROM capacitacion WHERE idcapacitacion = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    capacitacion = new Capacitacion();
                    capacitacion.setId(resultSet.getInt("idcapacitacion"));
                    capacitacion.setNombre(resultSet.getString("nombre"));
                    capacitacion.setHorario(resultSet.getString("horario"));
                    capacitacion.setFecha(resultSet.getString("fecha"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return capacitacion;
    }

    public void agregarCapacitacion(Capacitacion capacitacion) {
        String consulta = "INSERT INTO capacitacion (nombre, horario, fecha) VALUES (?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, capacitacion.getNombre());
            statement.setString(2, capacitacion.getHorario());
            statement.setString(3, capacitacion.getFecha());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCapacitacion(Capacitacion capacitacion) {
        String consulta = "UPDATE capacitacion SET nombre = ?, horario = ?, fecha = ? WHERE idcapacitacion = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, capacitacion.getNombre());
            statement.setString(2, capacitacion.getHorario());
            statement.setString(3, capacitacion.getFecha());
            statement.setInt(4, capacitacion.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCapacitacion(int id) {
        String consulta = "DELETE FROM capacitacion WHERE idcapacitacion = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
