package comww.example.android.utsmardiana.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDellUser {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private User muser;
    @SerializedName("message")
    private String massage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getMuser() {
        return muser;
    }

    public void setMuser(User muser) {
        this.muser = muser;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
