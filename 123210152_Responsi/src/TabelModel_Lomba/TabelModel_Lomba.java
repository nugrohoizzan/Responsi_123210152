/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TabelModel_Lomba;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model_Lomba.Model_Lomba;

/**
 *
 * @author PC PRAKTIKUM
 */
public class TabelModel_Lomba extends AbstractTableModel{
    java.util.List<Model_Lomba> list_lomba;
    
    public TabelModel_Lomba(java.util.List<Model_Lomba> list_lomba){
        this.list_lomba = list_lomba;
    }

    @Override
    public int getRowCount() {
       return list_lomba.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
     @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Orisinalitas";
            case 3:
                return "PemilihanKata";
            case 4:
                return "Nilai";
           
            default:
                return null;
             
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
               return list_lomba.get(row).getJudul();
            case 1:
                return list_lomba.get(row).getAlur();
            case 2:
                return list_lomba.get(row).getOrisinalitas();
            case 3:
                return list_lomba.get(row).getPemilihanKata();
            case 4:
                return list_lomba.get(row).getNilai();
            default:
                return null;
            
    }
    }
    
}
