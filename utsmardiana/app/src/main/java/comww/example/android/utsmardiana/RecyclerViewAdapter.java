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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<RecyclerBarang> rvData;
    Context mContext;

    public RecyclerViewAdapter(ArrayList<RecyclerBarang> inputData, Context co) {
        mContext = co;
        rvData = inputData;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView tvImage;
        public TextView tvTitle;
        public TextView tvSubtitle;
        public ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_title);
            tvSubtitle = v.findViewById(R.id.tv_subtitle);
            tvImage = v.findViewById(R.id.icon);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.barang, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final RecyclerBarang barang = rvData.get(position);
        holder.tvTitle.setText(barang.namaBarang);
        holder.tvImage.setImageResource(barang.getImageView());
        holder.tvSubtitle.setText(barang.namaHarga);

        holder.tvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (mContext, MainActivity5.class);
                i.putExtra("namaBarang", barang.namaBarang);
                i.putExtra("namaHarga", barang.namaHarga);
                i.putExtra("imageBarang", barang.imageView);

                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }
}
