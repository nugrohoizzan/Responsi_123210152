/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Lomba;
import javax.swing.JOptionPane;
import java.util.List;
import DAO_Lomba.DAO_Lomba;
import Model_Lomba.Model_Lomba;
import TabelModel_Lomba.TabelModel_Lomba;
import View_Lomba.View_Lomba;
import Implement_Lomba.Implement_Lomba;
/**
 *
 * @author PC PRAKTIKUM
 */
public class Controller_Lomba {
    View_Lomba frame_lomba;
     Implement_Lomba implemet_lomba;
    List<Model_Lomba> list_lomba;
    
    public Controller_Lomba(View_Lomba frame_lomba){
        this.frame_lomba = frame_lomba;
        implemet_lomba = new DAO_Lomba();
        list_lomba = implemet_lomba.getALL();
        TabelModel_Lomba tmb = new TabelModel_Lomba(list_lomba);
        
    }
    
    //Tombol Reset
    public void reset(){
        frame_lomba.getTxtjudul().setText("");
        frame_lomba.getTxtalur().setText("");
        frame_lomba.getTxtorisinilitas().setText("");
        frame_lomba.getTxtkata().setText("");
        
    }
    
    //Tampil Data Ke Tabel
    public void isiTable(){
        list_lomba = implemet_lomba.getALL();
        TabelModel_Lomba tmb = new TabelModel_Lomba(list_lomba);
        frame_lomba.getTabeldata().setModel(tmb);
    }
    
    //isi field ketika update
    public void isiField(int row){
        frame_lomba.getTxtjudul().setText(list_lomba.get(row).getJudul());
        frame_lomba.getTxtalur().setText(list_lomba.get(row).getAlur().toString());
        frame_lomba.getTxtorisinilitas().setText(list_lomba.get(row).getPemilihanKata().toString());
        frame_lomba.getTxtkata().setText(list_lomba.get(row).getPemilihanKata().toString());
        
        
    }
    
    //input data baru ke database
    public void insert(){
        if(!frame_lomba.getTxtjudul().getText().trim().isEmpty()& !frame_lomba.getTxtalur().getText().trim().isEmpty()& !frame_lomba.getTxtorisinilitas().getText().trim().isEmpty()& !frame_lomba.getTxtkata().getText().trim().isEmpty()){
            Model_Lomba b = new Model_Lomba();
            
            
            b.setJudul(frame_lomba.getTxtjudul().getText());
            b.setAlur(Double.valueOf(frame_lomba.getTxtalur().getText()));
            b.setOrisinalitas(Double.valueOf(frame_lomba.getTxtorisinilitas().getText()));
            b.setPemilihanKata(Double.valueOf(frame_lomba.getTxtkata().getText()));
            b.setNilai(Double.valueOf(((frame_lomba.getTxtalur().getText())+(frame_lomba.getTxtorisinilitas().getText())+(frame_lomba.getTxtkata().getText())))); 
           
            implemet_lomba.insert(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } else {
            JOptionPane.showMessageDialog(frame_lomba, "Data Tidak Boleh Kosong");
        }
    }
    
    //Update Data Dari Tabel Ke Database
    public void update(){
        if(!frame_lomba.getTxtjudul().getText().trim().isEmpty()){
            Model_Lomba b = new Model_Lomba();
            b.setAlur(Double.valueOf(frame_lomba.getTxtalur().getText()));
            b.setOrisinalitas(Double.valueOf(frame_lomba.getTxtorisinilitas().getText()));
            b.setPemilihanKata(Double.valueOf(frame_lomba.getTxtkata().getText()));
            b.setNilai(Double.valueOf(((frame_lomba.getTxtalur().getText())+(frame_lomba.getTxtorisinilitas().getText())+(frame_lomba.getTxtkata().getText())))); 
            
            implemet_lomba.update(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_lomba, "Silahkan Pilih Data Yang Akan Di Update");
        }
    }
    
    //Hapus Data Pada Tabel
    public void delete(){
        if(!frame_lomba.getTxtjudul().getText().trim().isEmpty()){
            String kode = frame_lomba.getTxtjudul().getText();
            implemet_lomba.delete(kode);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame_lomba, "Silahkan Pilih Data Yang Akan Di Hapus");
        }
    }
    
    //Cari Data
    public void isiTableCariJudul(){
        list_lomba = implemet_lomba.getCariJudul(frame_lomba.getTxtcari().getText());
        TabelModel_Lomba tmb = new TabelModel_Lomba(list_lomba);
        frame_lomba.getTabeldata().setModel(tmb);
    }
    
    public void carijudul(){
        if(!frame_lomba.getTxtcari().getText().trim().isEmpty()){
            implemet_lomba.getCariJudul(frame_lomba.getTxtcari().getText());
            isiTableCariJudul();
        } else {
            JOptionPane.showMessageDialog(frame_lomba, "Silahkan Pilih Data !!!");
        }
    }
}
