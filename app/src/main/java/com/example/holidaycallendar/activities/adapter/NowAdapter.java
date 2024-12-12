package com.example.holidaycallendar.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.holicalendar.R;
import com.example.holidaycallendar.activities.model.ModelMain;
import com.example.holidaycallendar.activities.utils.Tools;

import java.util.List;

public class NowAdapter extends RecyclerView.Adapter<NowAdapter.ViewHolder> {

    List<ModelMain> modelMainList;
    Context mContext;

    public NowAdapter(Context context, List<ModelMain> items) {
        this.mContext = context;
        this.modelMainList = items;
    }

    @NonNull
    @Override
    public NowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_now,
                parent, false);
        return new NowAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NowAdapter.ViewHolder holder, int position) {
        ModelMain data = modelMainList.get(position);

        int lastColorIndex = -1;
        int[] cardColors = mContext.getResources().getIntArray(R.array.cardview_color);
        int colorIndex = (position % cardColors.length);
        if (colorIndex == lastColorIndex) {
            colorIndex = (colorIndex + 1) % cardColors.length;
        }
        holder.cvListNow.setCardBackgroundColor(cardColors[colorIndex]);

        if (data.getStrCuti().equals("true")) {
            holder.linearCuti.setVisibility(View.VISIBLE);
        } else {
            holder.linearCuti.setVisibility(View.GONE);
        }

        holder.tvDate.setText(Tools.setDate(data.getStrTanggal()));
        holder.tvKeterangan.setText(data.getStrKeterangan());
    }

    @Override
    public int getItemCount() {
        return modelMainList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cvListNow;
        public LinearLayout linearCuti;
        public TextView tvDate, tvKeterangan;

        public ViewHolder(View itemView) {
            super(itemView);
            cvListNow = itemView.findViewById(R.id.cvListNow);
            linearCuti = itemView.findViewById(R.id.linearCuti);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvKeterangan = itemView.findViewById(R.id.tvKeterangan);
        }
    }

}