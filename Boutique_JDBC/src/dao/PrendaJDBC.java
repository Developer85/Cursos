
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.ListaPrendas;
import modelo.Prenda;

/**
 *
 * @author usu21
 */
public class PrendaJDBC {
    private Connection conexion;
    
    private void conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/boutique";
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
    
    public boolean insertarPrenda(Prenda p) {
        conectar();
        if (conexion != null) {
            try {
                String sentencia = "insert into prenda values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                ps.setString(1, p.getCodigo());
                ps.setString(2, p.getDescripcion());
                ps.setString(3, p.getTalla());
                ps.setString(4, p.getColor());
                ps.setDouble(5, p.getPrecioCoste());
                ps.setDouble(6, p.getPrecioVenta());
                ps.setInt(7, p.getStock());
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
    
    public boolean existePrenda(String codigo) {
        conectar();
        if (conexion != null) {
            try {
                String query = "select * from prenda where codigo = '" + codigo + "'";
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
    
    public ListaPrendas selectPrendasTodas() {
        ListaPrendas prendas = new ListaPrendas();
        
        conectar();
        if (conexion != null) {
            try {
                String query = "select * from prenda";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next()) {
                    Prenda p = new Prenda();
                    p.setCodigo(rs.getString("codigo"));
                    p.setDescripcion(rs.getString("descripcion"));
                    p.setTalla(rs.getString("talla"));
                    p.setColor(rs.getString("color"));
                    p.setPrecioCoste(rs.getDouble("precioCoste"));
                    p.setPrecioVenta(rs.getDouble("precioVenta"));
                    p.setStock(rs.getInt("stock"));
                    prendas.altaPrenda(p);
                }
                
                rs.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }
        
        return prendas;
    }
    
    public ListaPrendas selectPrendasPorColor(String color) {
        ListaPrendas prendas = new ListaPrendas();
        
        conectar();
        if (conexion != null) {
            try {
                String query = "select * from prenda where color = '" + color + "'";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next()) {
                    Prenda p = new Prenda();
                    p.setCodigo(rs.getString("codigo"));
                    p.setDescripcion(rs.getString("descripcion"));
                    p.setTalla(rs.getString("talla"));
                    p.setColor(rs.getString("color"));
                    p.setPrecioCoste(rs.getDouble("precioCoste"));
                    p.setPrecioVenta(rs.getDouble("precioVenta"));
                    p.setStock(rs.getInt("stock"));
                    prendas.altaPrenda(p);
                }
                
                rs.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }
        
        return prendas;
    }
    
    public int totalPrendas() {
        int total = 0;
        
        conectar();
        if (conexion != null) {
            try {
                String query = "select count(*) as total from prenda";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                if (rs.next()) {
                    total = rs.getInt("total");
                }
            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }
        
        return total;
    }
    
    public int cantidadStock() {
        int cantidad = 0;
        
        conectar();
        if (conexion != null) {
            try {
                String query = "select sum(stock) as cantidad from prenda";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                if (rs.next()) {
                    cantidad = rs.getInt("cantidad");
                }
                
                rs.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }
        
        return cantidad;
    }
    
    public double valoracionStock() {
        int valoracion = 0;
        conectar();
        
        if (conexion != null) {
            try {
                String query = "select sum(precioCoste*stock) as valoracion from prenda";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                if (rs.next()) {
                    valoracion = rs.getInt("valoracion");
                }
            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }
        
        return valoracion;
    }
    
    public int cantidadPrendasPorColor(String color) {
        int cantidad = 0;
        conectar();
        
        if (conexion != null) {
            try {
                String query = "select count(*) as cantidad from prenda where color='" + color + "'";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                if (rs.next()) {
                    cantidad = rs.getInt("cantidad");
                }
                
                rs.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }
        
        return cantidad;
    }
    
    public boolean actualizarPrenda(Prenda p) {
        conectar();
        if (conexion != null) {
            try {
                String sentencia = "update prenda set stock = " + p.getStock() +
                        " where codigo = '" + p.getCodigo() + "'";
                Statement st = conexion.createStatement();
                st.executeUpdate(sentencia);
                
                st.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
                return false;
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }
}
