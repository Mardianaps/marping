package comww.example.android.utsmardiana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Daftar extends AppCompatActivity {

    private EditText edtEmail, edtPassword, edtNama;
    private ModelUser user;
    DataHelper db;
    Button btnDaftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        user = new ModelUser();
        edtEmail = findViewById(R.id.editEmail);
        edtPassword = findViewById(R.id.editPassword);
        edtNama = findViewById(R.id.editNama);
        db = new DataHelper(getApplicationContext());
        btnDaftar=(Button)findViewById(R.id.btnDaftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                postDataToSQLite();//untuk mengepost ke SQLite
                Intent inte = new Intent(getApplicationContext(), Login.class);
                startActivity(inte);
            }
        });

    }

    private void postDataToSQLite(){
        if(!db.checkUser(edtEmail.getText(). toString(). trim())){
            user.setEmail(edtEmail.getText().toString().trim());
            user.setPassword(edtPassword.getText().toString().trim());
            user.setNama(edtNama.getText().toString().trim());

            db.addUser(user);
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show();
        }
    }
}
