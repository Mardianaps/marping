package comww.example.android.utsmardiana.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDellBarang {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private Barang mbarang;
    @SerializedName("message")
    private String massage;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Barang getMbarang() {
        return mbarang;
    }

    public void setMbarang(Barang mbarang) {
        this.mbarang = mbarang;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}

