/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uaspbo;

/**
 *
 * @author ASUS
 */
public class Mobil {
    
    private String id;
    private String merk;
    private String model;
    private String noPlat;
    private int stok;
    private int harga;
    
    public Mobil(String id, String merk, String model, String noPlat, int stok, int harga){// harga ganti jadi float
        this.id = id;
        this.merk = merk;
        this.model = model;
        this.noPlat = noPlat;
        this.stok = stok;
        this.harga = harga;
    }

    public int getHarga() { //ganti jadi float
        return harga;
    }

    public String getId() {
        return id;
    }

    public String getMerk() {
        return merk;
    }

    public String getModel() {
        return model;
    }

    public String getNoPlat() {
        return noPlat;
    }

    public int getStok() {
        return stok;
    }
    
    
    
}
