package com.example.betika_ui.adapter.bets;


import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.betika_ui.R;
import com.example.betika_ui.adapter.Bets;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;


public class Live_bet_adapter extends RecyclerView.Adapter<Live_bet_adapter.MyViewHolder> {

    private List<Bets> betsList;
    private RecyclerViewActionListner mListener;

    public interface RecyclerViewActionListner
    {
        void onViewClicked(int clickedViewId, int clickedItemPosition);
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder
    {
        public Button button1,button2,button3,button4;
        public  TextView one,two,title,title2,title3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            button1 = (Button) itemView.findViewById(R.id.button1);
            button2 = (Button) itemView.findViewById(R.id.button2);
            button3 = (Button) itemView.findViewById(R.id.button3);
            button4 = (Button) itemView.findViewById(R.id.button4);
            one = (TextView) itemView.findViewById(R.id.one);
            two = (TextView) itemView.findViewById(R.id.two);
            title = (TextView) itemView.findViewById(R.id.title);
            title2 = (TextView) itemView.findViewById(R.id.title2);
            title3 = (TextView) itemView.findViewById(R.id.title3);
        }
    }

    public Live_bet_adapter(List<Bets> betsList, RecyclerViewActionListner mlistener)
    {
        this.mListener = mlistener;
        this.betsList = betsList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cycle_item,parent,false);

        final MyViewHolder holder = new MyViewHolder(itemView);
        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: button1 clicked at viewholder");
                mListener.onViewClicked(view.getId(), holder.getAdapterPosition());
            }
        });
        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onViewClicked(view.getId(), holder.getAdapterPosition());
            }
        });
        holder.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onViewClicked(view.getId(), holder.getAdapterPosition());
            }
        });
        holder.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onViewClicked(view.getId(), holder.getAdapterPosition());
            }
        });

        return new Live_bet_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      Bets bets = betsList.get(position);
      holder.button1.setText(bets.getButton1());
      holder.button4.setText(bets.getButton4());
      holder.button2.setText(bets.getButton2());
      holder.button3.setText(bets.getButton3());
      holder.one.setText(bets.getOne());
      holder.two.setText(bets.getTwo());
      holder.title.setText(bets.getTitle());
      holder.title2.setText(bets.getTitle2());
      holder.title3.setText(bets.getTitle3());
    }

    @Override
    public int getItemCount() {
        return betsList.size();
    }
}
