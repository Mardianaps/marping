package comww.example.android.utsmardiana.Rest;

import comww.example.android.utsmardiana.Model.PostPutDellBarang;
import comww.example.android.utsmardiana.Model.PostPutDellUser;
import comww.example.android.utsmardiana.Model.getBarang;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    //get all barang
    @GET("barang/barangAll")
    Call<getBarang> getBarang();

    //    Post Kelas
    @Multipart
    @POST("Admin/barang")
    Call<PostPutDellBarang> postBarang(@Part MultipartBody.Part file,
                                      @Part("nama") RequestBody nama,
                                      @Part("harga") RequestBody harga,
                                      @Part("deskripsi")  RequestBody deskripsi);
    //Post User

    @FormUrlEncoded
    @POST("User")
    Call<PostPutDellUser> postUser (@Field("nama") String nama,
                                    @Field("level") String level,
                                    @Field("password") String password,
                                    @Field("email") String email);
}
