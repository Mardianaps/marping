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

public class feed extends AppCompatActivity {

    //SessionManagement sessionManagementLogout;
    private RecyclerView rvView2;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<RecyclerBarang2> dataSet2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        dataSet2 = new ArrayList<>();
        initDataset2();
        rvView2 = (RecyclerView) findViewById(R.id.rv_main2);
        rvView2.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView2.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter2(dataSet2, this);
        rvView2.setAdapter(adapter);
        //sessionManagementLogout = new SessionManagement (this);


//        //Horizontalll  rv_main3
        rvView2 = (RecyclerView) findViewById(R.id.rv_main2);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvView2.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter2(dataSet2, this);
        rvView2.setAdapter(adapter);
    }

    private void initDataset2 () {
        RecyclerBarang2 brg = new RecyclerBarang2("Fullset Baby", "Rp 1500000", R.drawable.fff);
        dataSet2.add(brg);

        brg = new RecyclerBarang2("Daily Baby Finds", "Rp 2000000", R.drawable.ggg);
        dataSet2.add(brg);

        brg = new RecyclerBarang2("Carseat Baby Car", "Rp 1000000", R.drawable.hhh);
        dataSet2.add(brg);

        brg = new RecyclerBarang2("These Luxury Strollers", "Rp 500000", R.drawable.iii);
        dataSet2.add(brg);
    }

}
