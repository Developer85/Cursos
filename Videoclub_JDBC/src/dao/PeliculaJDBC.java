
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.ListaPeliculas;
import modelo.Pelicula;

/**
 *
 * @author usu21
 */
public class PeliculaJDBC {
    private Connection conexion;
    
    private void conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/videoclub";
            String usr = "root";
            String pass = "jeveris";
            conexion = DriverManager.getConnection(url, usr, pass);
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex.getMessage());
            conexion = null;
        }
    }
    
    private void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar: " + ex.getMessage());
        }
    }
    
    public boolean insertarPelicula(Pelicula p) {
        conectar();
        if (conexion != null) {
            try {
                String sentencia = "insert into pelicula values (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                ps.setString(1, p.getCodigo());
                ps.setString(2, p.getTitulo());
                ps.setInt(3, p.getDuracion());
                ps.setString(4, p.getGenero());
                ps.setInt(5, p.getValoracion());
                ps.setBoolean(6, p.isVisto());
                ps.executeUpdate();
                ps.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error al insertar: " + ex.getMessage());
                return false;
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }
    
    public boolean existePelicula(String codigo) {
        conectar();
        if (conexion != null) {
            try {
                String query = "select * from pelicula where codigo = '" + codigo + "'";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                boolean existe = false;
                if (rs.next()) {
                    existe = true;
                }
                rs.close();
                st.close();
                return existe;
            } catch (SQLException ex) {
                System.out.println("Error al consultar " + ex.getMessage());
                return false;
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }
    
    public ListaPeliculas selectAllPeliculas() {
        ListaPeliculas listaPeliculas = new ListaPeliculas();
        conectar();
        
        if (conexion != null) {
            try {
                String query = "select * from pelicula";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula();
                    pelicula.setCodigo(rs.getString("codigo"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDuracion(rs.getInt("duracion"));
                    pelicula.setGenero(rs.getString("genero"));
                    pelicula.setValoracion(rs.getInt("valoracion"));
                    pelicula.setVisto(rs.getBoolean("visto"));
                    listaPeliculas.altaPelicula(pelicula);
                }
                
                rs.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }
        
        return listaPeliculas;
    }
}
