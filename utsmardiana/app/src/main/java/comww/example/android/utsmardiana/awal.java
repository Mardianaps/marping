package comww.example.android.utsmardiana;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class awal extends AppCompatActivity {
    ImageView btnToped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awal);

        btnToped = findViewById(R.id.imgToped);
//        SessionManagement sessionManagement = new SessionManagement(this);
//        if(sessionManagement.isLoggedIn()){
//            Intent k = new Intent(getApplicationContext(),Pilihan_akun.class);
//            startActivity(k);
//            finish();
//        }

        btnToped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(getApplicationContext(),Pilihan_akun.class);
                startActivity(k);
            }
        });

//        Button btnDaftar= findViewById(R.id.btn_Daftar);
//        Button btnLogin=findViewById(R.id.btn_Login);
//
//        btnDaftar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(),Home.class);
//                startActivity(i);
//            }
//        });
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(),Login.class);
//                startActivity(i);
//            }
//        });
    }
}