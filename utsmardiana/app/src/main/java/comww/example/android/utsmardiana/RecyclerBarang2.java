package comww.example.android.utsmardiana;

public class RecyclerBarang2 {
    String namaBarang2, namaHarga2;
    int imageView2;


    public RecyclerBarang2(String namaBarang2, String harga2, int imageView2) {
        this.namaBarang2 = namaBarang2;
        this.namaHarga2 = harga2;
        this.imageView2 = imageView2;
    }

    public String getNamaBarang2() {
        return namaBarang2;
    }

    public void setNamaBarang2(String namaBarang2) {
        this.namaBarang2 = namaBarang2;
    }


    public String getNamaHarga2() {
        return namaHarga2;
    }

    public void setNamaHarga2(String namaHarga2) {
        this.namaHarga2 = namaHarga2;
    }

    public int getImageView2() {
        return imageView2;
    }

    public void setImageView2(int imageView2) {
        this.imageView2 = imageView2;
    }
}
