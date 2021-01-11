package com.example.betika_ui.adapter.bets;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.betika_ui.R;
import com.example.betika_ui.adapter.Bets;
import com.example.betika_ui.adapter.checkout_data;
import com.example.betika_ui.db.Betting;
import com.example.betika_ui.db.betDao;
import com.example.betika_ui.repository.repository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;


public  class checkout_adapter extends RecyclerView.Adapter<checkout_adapter.MyViewHolder> {

    private List<Betting> checkList;
    private RecyclerViewActionListner mListener;
    private Context mcontext;
  //  private final LayoutInflater layoutInflater;
    private betDao betDaos;
    private repository rep;


    public interface RecyclerViewActionListner
    {
        void onViewClicked(Betting betting);

    }

    public class MyViewHolder extends  RecyclerView.ViewHolder
    {
        public TextView first,second,third,rate;
        public ImageButton button;
        private int mposition;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            button = (ImageButton) itemView.findViewById(R.id.cancel);
            first = (TextView) itemView.findViewById(R.id.first);
            second = (TextView) itemView.findViewById(R.id.second);
            third = (TextView) itemView.findViewById(R.id.third);
            rate = (TextView) itemView.findViewById(R.id.rates);
        }

        public void setData(String team_1, String team_2, String bet_number,String rates,int position) {
            //bet_number not used....
            first.setText(team_1);
            second.setText(team_2);
            third.setText(team_1);
            rate.setText(rates);
            mposition = position;
        }

        public void setListeners(){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onViewClicked(checkList.get(mposition));
                    }
                }
            });
        }
    }

    public checkout_adapter(List<Betting> checkList, RecyclerViewActionListner mlistener)
    {
        this.mListener = mlistener;
        this.checkList = checkList;
       // layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.checkout_item,parent,false);

       // final MyViewHolder holder = new MyViewHolder(itemView);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
         if(checkList!= null)
         {
             final Betting checklist = checkList.get(position);
             holder.setData(
                     checklist.getTeam_1(),
                     checklist.getTeam_2(),
                     checklist.getTeam_1(),
                     checklist.getBet_number(),
                     position);
             holder.setListeners();

//             holder.button.setOnClickListener(new View.OnClickListener() {
//                 @Override
//                 public void onClick(View view) {
//                     Betting checklists = checkList.get(position);
//                    // rep.delete(checklists);
//                     checkList.remove(position);
//                     rep.delete(checkList.get(position));
//                     notifyDataSetChanged();
//
//                 }
//             });
         }
         else {
             Log.d(TAG, "checkadapter: onViewClicked ");
         }
    }


    @Override
    public int getItemCount() {
        return checkList.size();
    }

    public void setbets(List<Betting> checkLists )
    {
        checkList = checkLists;
        notifyDataSetChanged();
    }
}
