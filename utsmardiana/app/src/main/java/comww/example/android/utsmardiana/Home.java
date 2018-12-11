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
import java.util.List;

import comww.example.android.utsmardiana.Model.Barang;
import comww.example.android.utsmardiana.Model.getBarang;
import comww.example.android.utsmardiana.Rest.ApiClient;
import comww.example.android.utsmardiana.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {


    ImageView imageLogout, imageInbox, imageKeranjang, imageFeed;
    SessionManagement sessionManagementLogout;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Barang> dataSet;
    private ApiInterface mApiInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
//        dataSet = new ArrayList<>();
        rvView = (RecyclerView) findViewById(R.id.rv_main);
        initDataset();
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
//        RecyclerBarang brg = new RecyclerBarang("Car Sit Baby", "Rp 699000000", R.drawable.aaa);
//        dataSet.add(brg);
//
//        brg = new RecyclerBarang("Celana", "Rp 200000", R.drawable.bbb);
//        dataSet.add(brg);
//
//        brg = new RecyclerBarang("Bed Baby", "Rp 250000", R.drawable.ccc);
//        dataSet.add(brg);
//
//        brg = new RecyclerBarang("Food Set", "Rp 5500000", R.drawable.ddd);
//        dataSet.add(brg);
//
//        brg = new RecyclerBarang("Hipseat Baby", "Rp 5500000", R.drawable.eee);
//        dataSet.add(brg);

        Call<getBarang> getBarang = mApiInterface.getBarang();
        getBarang.enqueue(new Callback<comww.example.android.utsmardiana.Model.getBarang>() {
            @Override
            public void onResponse(Call<comww.example.android.utsmardiana.Model.getBarang> call, Response<comww.example.android.utsmardiana.Model.getBarang> response) {
               dataSet = response.body().getListBarang();

                layoutManager = new LinearLayoutManager(getApplicationContext());
                rvView.setLayoutManager(layoutManager);
                adapter = new RecyclerViewAdapter(dataSet, getApplication());
                rvView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<comww.example.android.utsmardiana.Model.getBarang> call, Throwable t) {

            }
        });

    }
}
