/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_Lomba;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Koneksi.Koneksi;
import Model_Lomba.Model_Lomba;
import Implement_Lomba.Implement_Lomba;
/**
 *
 * @author PC PRAKTIKUM
 */
public class DAO_Lomba implements Implement_Lomba{
    Connection connection;
   
   final String select = "SELECT * FROM lomba;";
   final String insert = "INSERT INTO lomba (judul, alur, orisinalitas, pemilihanKata, nilai) VALUES (?,?,?,?,?);";
   final String delete = "DELETE FROM lomba WHERE judul=?;";
   final String update = "UPDATE lomba set alur=?, orisinalitas=?, pemilihanKata=?, nilai=? WHERE judul=?;";
   
   public DAO_Lomba(){
        connection = Koneksi.connection();
}
    @Override
    public void insert(Model_Lomba b) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getJudul());
            statement.setDouble(2, b.getAlur());
            statement.setDouble(3, b.getOrisinalitas());
            statement.setDouble(4, b.getPemilihanKata());
            statement.setDouble(5, b.getNilai());
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                b.setJudul(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
       } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Model_Lomba b) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getJudul());
            statement.setDouble(2, b.getAlur());
            statement.setDouble(3, b.getOrisinalitas());
            statement.setDouble(4, b.getPemilihanKata());
            statement.setDouble(5, b.getNilai());
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                b.setJudul(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
       } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
       
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
       } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public java.util.List<Model_Lomba> getALL() {
        java.util.List<Model_Lomba> lb = null;
        try{
            lb = new ArrayList<Model_Lomba>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                Model_Lomba b = new Model_Lomba();
                b.setJudul(rs.getString("judul"));
                b.setAlur(rs.getDouble("alur"));
                b.setOrisinalitas(rs.getDouble("orisinalitas"));
                b.setPemilihanKata(rs.getDouble("pemilihankata"));
                b.setNilai(rs.getDouble("nilai"));
                
                lb.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Lomba.class.getName()).log(Level.SEVERE, null, ex);
       } 
        return lb;
    }

    @Override
    public java.util.List<Model_Lomba> getCariJudul(String judul) {
        java.util.List<Model_Lomba> lb = null;
        String sql = "SELECT * FROM lomba WHERE judul LIKE '%"+judul+"%' OR nama LIKE '%"+judul+"%'";
         lb = new ArrayList<Model_Lomba>();
         
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Model_Lomba b = new Model_Lomba();
                b.setJudul(rs.getString("judul"));
                b.setAlur(rs.getDouble("alur"));
                b.setOrisinalitas(rs.getDouble("orisinalitas"));
                b.setPemilihanKata(rs.getDouble("pemilihankata"));
                b.setNilai(rs.getDouble("nilai"));
               
                lb.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Lomba.class.getName()).log(Level.SEVERE, null, ex);
       } 
        return lb;
    }
    
}
