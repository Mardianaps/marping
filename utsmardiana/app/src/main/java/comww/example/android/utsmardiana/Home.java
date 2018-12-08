package comww.example.android.utsmardiana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {


    ImageView imageLogout, imageInbox, imageKeranjang, imageFeed;
    SessionManagement sessionManagementLogout;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<RecyclerBarang> dataSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dataSet = new ArrayList<>();
        initDataset();
        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(dataSet, this);
        rvView.setAdapter(adapter);
        imageLogout = findViewById(R.id.imageViewLogout);
        imageInbox = findViewById(R.id.imageViewInbox);
        imageKeranjang = findViewById(R.id.imageViewKeranjang);
        imageFeed = findViewById(R.id.imageViewFeed_btn);
        sessionManagementLogout = new SessionManagement (this);

        imageLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagementLogout.logoutUser();
                finish();
            }
        });

        imageInbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), inbox.class);
                startActivity(a);
            }
        });

        imageKeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), keranjang.class);
                startActivity(b);
            }
        });

        imageFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(), feed.class);
                startActivity(c);
            }
        });
    }


    private void initDataset () {
        RecyclerBarang brg = new RecyclerBarang("Jam Tangan", "Rp 699000000", R.drawable.jammm);
        dataSet.add(brg);

        brg = new RecyclerBarang("Buah", "Rp 200000", R.drawable.buah);
        dataSet.add(brg);

        brg = new RecyclerBarang("Lipstik", "Rp 250000", R.drawable.lipstik);
        dataSet.add(brg);

        brg = new RecyclerBarang("Laptop", "Rp 5500000", R.drawable.laptop);
        dataSet.add(brg);

        brg = new RecyclerBarang("Baju", "Rp 5500000", R.drawable.buajuu);
        dataSet.add(brg);

    }
}
