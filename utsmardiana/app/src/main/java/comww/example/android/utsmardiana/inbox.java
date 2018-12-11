package comww.example.android.utsmardiana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inbox extends AppCompatActivity {
    Button buttonChat, buttonBantuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        buttonChat = findViewById(R.id.buttonChat);
        buttonBantuan = findViewById(R.id.buttonBantuan);

        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), chat.class);
                startActivity(a);
            }
        });

        buttonBantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), pusat_bantuan.class);
                startActivity(a);
            }
        });

    }
}
