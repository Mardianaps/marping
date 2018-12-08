package comww.example.android.utsmardiana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Logout extends AppCompatActivity {

    Button btnLogin;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        btnLogin = findViewById(R.id.buttonLogout);
        sessionManagement = new SessionManagement(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.logoutUser();
            }
        });
    }
}
