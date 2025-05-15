package Controlador;

import Modelo.Pokemon;
import Persistencia.ConexionDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PokemonDAO
{
    /** Objeto para gestionar la conexión a la base de datos. */
    private ConexionDB conexionDB = new ConexionDB();

    /**
     * Crea un nuevo cliente en la base de datos.
     * @param pokemon Objeto Clientes con la información del nuevo cliente.
     */
    public void crear(Pokemon pokemon){
        Connection con = conexionDB.getConnection();
        String query = "INSERT INTO pokemon (nombre,tipo,peso,altura,descripcion,atk,def,foto) VALUES (?,?,?,?,?,?,?,?)";

        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, pokemon.getNombre());
            pst.setString(2, pokemon.getTipo());
            pst.setInt(3, pokemon.getPeso());
            pst.setInt(4, pokemon.getAltura());
            pst.setString(1, pokemon.getDescripcion());
            pst.setInt(1, pokemon.getAtk());
            pst.setInt(1, pokemon.getDEF());
            pst.setString(1, pokemon.getFoto());


            int resultado = pst.executeUpdate();
            if (resultado > 0){
                JOptionPane.showMessageDialog(null, "Pokemon creado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear al pokemon xd.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Elimina un cliente de la base de datos basado en su ID.
     * @param id_pokedex Identificador del cliente a eliminar.
     */
    public void eliminar(int id_pokedex){
        Connection con = conexionDB.getConnection();
        String query = "DELETE FROM clientes WHERE id_pokedex = ?"; // Corregida la consulta SQL

        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id_pokedex);

            int resultado = pst.executeUpdate();
            if (resultado > 0){
                JOptionPane.showMessageDialog(null, "El pokemon ha sido eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar al pokemon.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Actualiza los datos de un cliente en la base de datos.
     * @param pokemon Objeto Clientes con la información actualizada del cliente.
     */
    public void actualizar(Pokemon pokemon){
        Connection con = conexionDB.getConnection();
        String query = "UPDATE clientes SET nombre = ?, telefono = ?, direccion = ?, correo = ? WHERE id_cliente = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, pokemon.getNombre());
            pst.setString(2, pokemon.getTipo());
            pst.setInt(3, pokemon.getPeso());
            pst.setInt(4, pokemon.getAltura());
            pst.setString(1, pokemon.getDescripcion());
            pst.setInt(1, pokemon.getAtk());
            pst.setInt(1, pokemon.getDEF());
            pst.setString(1, pokemon.getFoto());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Éxito al actualizar al cliente.");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al cliente.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
