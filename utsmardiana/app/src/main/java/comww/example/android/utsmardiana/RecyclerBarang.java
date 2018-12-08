package comww.example.android.utsmardiana;

public class RecyclerBarang {
    String namaBarang, namaHarga;
    int imageView;


    public RecyclerBarang(String namaBarang, String harga, int imageView) {
        this.namaBarang = namaBarang;
        this.namaHarga = harga;
        this.imageView = imageView;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }


    public String getNamaHarga() {
        return namaHarga;
    }

    public void setNamaHarga(String namaHarga) {
        this.namaHarga = namaHarga;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
