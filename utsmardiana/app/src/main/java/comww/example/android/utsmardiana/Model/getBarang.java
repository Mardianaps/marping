package comww.example.android.utsmardiana.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class getBarang {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<Barang> listBarang;
    @SerializedName("message")
    private String massage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Barang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(List<Barang> listBarang) {
        this.listBarang = listBarang;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
