package jp.co.nino.learning.mainScreen.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jp.co.nino.learning.R;
import jp.co.nino.learning.data.api.model.Genre1;

/**
 * Created by liu.rui on 2017/12/25.
 */

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.MyViewHolder> {

    private List<Genre1> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewSubtitle;
        TextView textViewAct;
        TextView textViewTime;
        TextView textViewContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewTitle = itemView.findViewById(R.id.main_title);
            this.textViewSubtitle = itemView.findViewById(R.id.subtitle);
            this.textViewAct = itemView.findViewById(R.id.act);
            this.textViewTime = itemView.findViewById(R.id.on_air_time);
            this.textViewContent = itemView.findViewById(R.id.content);
        }
    }

    public HomeListAdapter(List<Genre1> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        int height = parent.getMeasuredHeight() / 4;
        view.setMinimumHeight(height);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        if (dataSet.get(listPosition).getTitle() != "") {
            holder.textViewTitle.setText(dataSet.get(listPosition).getTitle());
        } else {
            holder.textViewTitle.setVisibility(View.GONE);
        }
        if (dataSet.get(listPosition).getTitle() != "") {
            holder.textViewSubtitle.setText(dataSet.get(listPosition).getSubtitle());
        } else {
            holder.textViewSubtitle.setVisibility(View.GONE);
        }
        if (dataSet.get(listPosition).getTitle() != "") {
            holder.textViewAct.setText(dataSet.get(listPosition).getAct());
        } else {
            holder.textViewAct.setVisibility(View.GONE);
        }
        if (dataSet.get(listPosition).getTitle() != "") {
            holder.textViewTime.setText(dataSet.get(listPosition).getStartTime().concat("〜")
                    .concat(dataSet.get(listPosition).getEndTime()));
        } else {
            holder.textViewTime.setVisibility(View.GONE);
        }
        if (dataSet.get(listPosition).getTitle() != "") {
            holder.textViewContent.setText(dataSet.get(listPosition).getContent());
        } else {
            holder.textViewContent.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
