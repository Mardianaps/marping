package comww.example.android.utsmardiana;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {
    private ArrayList<RecyclerBarang2> rvData;
    Context mContext;

    public RecyclerViewAdapter2(ArrayList<RecyclerBarang2> inputData, Context co) {
        mContext = co;
        rvData = inputData;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView tvImage2;
        public TextView tvTitle2;
        public TextView tvSubtitle2;
        public ViewHolder(View v) {
            super(v);
            tvTitle2 = (TextView) v.findViewById(R.id.tv_title2);
            tvSubtitle2 = v.findViewById(R.id.tv_subtitle2);
            tvImage2 = v.findViewById(R.id.icon);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.barang2, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final RecyclerBarang2 barang2 = rvData.get(position);
        holder.tvTitle2.setText(barang2.namaBarang2);
        holder.tvImage2.setImageResource(barang2.getImageView2());
        holder.tvSubtitle2.setText(barang2.namaHarga2);

        holder.tvImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (mContext, RecyclerView2.class);
                i.putExtra("namaBarang", barang2.namaBarang2);
                i.putExtra("namaHarga", barang2.namaHarga2);
                i.putExtra("imageBarang", barang2.imageView2);

                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }
}
