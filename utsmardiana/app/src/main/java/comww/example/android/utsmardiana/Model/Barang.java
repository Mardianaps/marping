package comww.example.android.utsmardiana.Model;

import com.google.gson.annotations.SerializedName;

public class Barang {
    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("harga")
    private String harga;
    @SerializedName("diskripsi")
    private String diskripsi;
    @SerializedName("gambar")
    private String gambar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDiskripsi() {
        return diskripsi;
    }

    public void setDiskripsi(String diskripsi) {
        this.diskripsi = diskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Barang(String id, String nama, String harga, String diskripsi, String gambar) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.diskripsi = diskripsi;
        this.gambar = gambar;
    }
}


