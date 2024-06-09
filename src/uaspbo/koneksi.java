package uaspbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class koneksi {
    public static Connection con;
    public static Statement stm;
    
    public Connection getKoneksi(){
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//        }catch(ClassNotFoundException ex){
//            
//        }
        try{
            String url = "jdbc:mysql://localhost/registrasi";
            String user = "root";                                   
            String pass = "";
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.print("Berhasil Koneksi");
            }
        }catch(SQLException ex){
            System.out.print("Koneksi Gagal");
        }
        return con;
    }

    public static void connect() {
        try {
            String url = "jdbc:mysql://localhost/registrasi";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
            System.out.println("Koneksi berhasil");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
                System.out.println("Koneksi ditutup");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menutup koneksi: " + e.getMessage());
        }
    }

    static Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}