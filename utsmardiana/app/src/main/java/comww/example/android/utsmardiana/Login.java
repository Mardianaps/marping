package comww.example.android.utsmardiana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private EditText edtEmail, edtPass;
    private Button btnLogin;
    private SessionManagement sessionManagement
            ;
    private ModelUser user;
    private DataHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DataHelper(this);
        user = new ModelUser();
        edtEmail = findViewById(R.id.editEmail);
        edtPass = findViewById(R.id.editPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cekValidasi()){
                    if(!isValidEmail(edtEmail.getText().toString().trim())){ //mengecek format email dan pass
                        edtEmail.setError("Email tidak valid");
                    }else if (!isValidPassword(edtPass.getText().toString().trim())){
                        edtPass.setError("Password Errorr");
                    }else {
                        if(db.checkUser(edtEmail.getText().toString(), edtPass.getText().toString())){///cekDb
                            sessionManagement.createLoginSession(edtEmail.getText().toString(),edtPass.getText().toString());//create session
                            verifyFromSQLite();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"password tidak cocok",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        Button btnDaftar = (Button)findViewById(R.id.btnDftr);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), Daftar.class);
                startActivity(b);
            }
        });

        sessionManagement = new SessionManagement(this);

//        Button btnGoogle = (Button)findViewById(R.id.btnGoogle);
//        btnGoogle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent c = new Intent(getApplicationContext(), webView.class);
//                startActivity(c);
//            }
//        });

    }

    private void verifyFromSQLite(){
        if(db.checkUser(edtEmail.getText().toString().trim(), edtPass.getText().toString().trim())){
            goToActivity();
        }
    }
    private boolean cekValidasi(){
        if(edtEmail.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"email tidak boleh kosong",Toast.LENGTH_SHORT).show();
            return false;
        }else if(edtPass.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"password tidak boleh kosong",Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(), Home.class);
        startActivity(mIntent);
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (!TextUtils.isEmpty(pass) && pass.length() > 2) {
            return true;
        }
        return false;
    }
}
