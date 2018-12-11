package comww.example.android.utsmardiana;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

import comww.example.android.utsmardiana.Model.PostPutDellBarang;
import comww.example.android.utsmardiana.Rest.ApiClient;
import comww.example.android.utsmardiana.Rest.ApiInterface;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class new_barang extends AppCompatActivity {

    EditText nama, harga, deskripsi;
    ImageView gambar;
    FloatingActionButton btn_camera;
    String imagePath = " ";
    Button btn_save;
    ApiInterface mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_barang);
        init_layout();
        init_listener();

    }

    private  void init_layout(){
        mApi = ApiClient.getClient().create(ApiInterface.class);
        nama = findViewById(R.id.editTextNama);
        harga = findViewById(R.id.editTextharga);
        deskripsi = findViewById(R.id.editTextDeskripsi);
        gambar = findViewById(R.id.gambar);
        btn_camera = findViewById(R.id.camera);
        btn_save = findViewById(R.id.btn_save);
    }

    private void init_listener(){
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);
                Intent intentChoose = Intent.createChooser(galleryIntent, "Pilih gambar untuk di upload");
                startActivityForResult(intentChoose, 200);
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent galleryIntent = new Intent();
                // progess dialog
                final ProgressDialog process = new ProgressDialog(new_barang.this);
                process.setTitle("Please Wait ..");
                process.setMessage("uploading file..");
                process.show();

                MultipartBody.Part body_img = null;
                // jika file upload tidak kosong
                if (!imagePath.isEmpty()){
                    //File creating from selected URL
                    File file = new File(imagePath);
                    // create RequestBody instance from file
                    RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    // MultipartBody.Part is used to send also the actual file name
                    body_img = MultipartBody.Part.createFormData("gambar", file.getName(), requestFile);
                }
                RequestBody reqNama = MultipartBody.create(MediaType.parse("multipart/form-data"),nama.getText().toString());
                RequestBody reqHarga= MultipartBody.create(MediaType.parse("multipart/form-data"),harga.getText().toString());
                RequestBody reqDeskripsi = MultipartBody.create(MediaType.parse("multipart/form-data"),deskripsi.getText().toString());

                Call<PostPutDellBarang> new_Barang = mApi.postBarang(body_img, reqNama, reqHarga, reqDeskripsi);
                new_Barang.enqueue(new Callback<PostPutDellBarang>() {
                    @Override
                    public void onResponse(Call<PostPutDellBarang> call, Response<PostPutDellBarang> response) {
                        process.hide();
                        Toast.makeText(getApplicationContext(), "Sukses : ", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<PostPutDellBarang> call, Throwable t) {
                        process.hide();
                        Toast.makeText(getApplicationContext(), "Gagal : "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 200) {
            if (data == null) {
                Toast.makeText(getApplicationContext(), "Gambar Gagal Di load",Toast.LENGTH_LONG).show();
                return;
            }
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn,null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imagePath = cursor.getString(columnIndex);
                Picasso.get().load(new File(imagePath)).into(gambar);
                cursor.close();
            }else {
                Toast.makeText(getApplicationContext(), "Gambar Gagal Di load",Toast.LENGTH_LONG).show();
            }
        }
    }
}
