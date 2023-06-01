/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Implement_Lomba;
import java.util.List;
import Model_Lomba.Model_Lomba;
/**
 *
 * @author PC PRAKTIKUM
 */
public interface Implement_Lomba {
    public void insert(Model_Lomba b);
    public void update(Model_Lomba b);
    public void delete(String judul);
  
    public java.util.List<Model_Lomba> getALL();
    public java.util.List<Model_Lomba> getCariJudul(String judul);
 
}
