package com.example.holidaycallendar.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.holicalendar.R;
import com.example.holidaycallendar.activities.model.ModelMain;
import com.example.holidaycallendar.activities.utils.Tools;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

/*
 * Created by Azhar Rivaldi on 12-02-2024
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class MonthlyAdapter extends RecyclerView.Adapter<MonthlyAdapter.ViewHolder> {

    List<ModelMain> modelMainList;
    Context mContext;

    public MonthlyAdapter(Context context, List<ModelMain> items) {
        this.mContext = context;
        this.modelMainList = items;
    }

    @Override
    public MonthlyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_monthly,
                parent, false);
        return new MonthlyAdapter.ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(MonthlyAdapter.ViewHolder holder, int position) {
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
        holder.timelineView.setMarkerColor(cardColors[colorIndex]);
    }

    @Override
    public int getItemCount() {
        return modelMainList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TimelineView timelineView;
        public CardView cvListNow;
        public LinearLayout linearCuti;
        public TextView tvDate, tvKeterangan;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            timelineView = itemView.findViewById(R.id.timelineView);
            timelineView.initLine(viewType);
            cvListNow = itemView.findViewById(R.id.cvListNow);
            linearCuti = itemView.findViewById(R.id.linearCuti);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvKeterangan = itemView.findViewById(R.id.tvKeterangan);
        }
    }

}