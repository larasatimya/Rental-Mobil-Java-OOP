/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uaspbo;

public class Driver {
    private String id_supir;
    private String nama; // alt +shift +panah bawah
    private String nmr_telp;
    private String alamat;
    private int biaya;
    
    public Driver(String id_supir, String nama, String nmr_telp, String alamat, int biaya){
        this.id_supir = id_supir;
        this.nama = nama;
        this.nmr_telp = nmr_telp;
        this.alamat = alamat;
        this.biaya = biaya;
    }

    public String getId_supir() {
        return id_supir;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getBiaya() {
        return biaya;
    }

    public String getNmr_telp() {
        return nmr_telp;
    }
    
    
}
