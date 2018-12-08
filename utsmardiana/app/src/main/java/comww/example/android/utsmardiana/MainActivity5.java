package comww.example.android.utsmardiana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity5 extends AppCompatActivity {
    ImageView imageView;
    TextView txtViewJam, txtViewHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

       imageView = findViewById(R.id.imageViewJam);
       txtViewJam = findViewById(R.id.txtViewJam);
       txtViewHarga = findViewById(R.id.txtViewHarga);

        Bundle brg = getIntent().getExtras();
        txtViewJam.setText( brg.getString("namaBarang"));
        imageView.setImageResource(brg.getInt("imageBarang"));
        txtViewHarga.setText(brg.getString("namaHarga"));

    }
}