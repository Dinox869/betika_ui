package com.example.betika_ui.ui.checkout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.betika_ui.R;
import com.example.betika_ui.adapter.bets.checkout_adapter;
import com.example.betika_ui.db.Betting;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class checkout extends AppCompatActivity implements checkout_adapter.RecyclerViewActionListner {
    private static final String TAG = "" ;
    TabLayout tabLayout;
    private RecyclerView recyclerView;
    private checkViewModel checkviewmodel;
    private checkout_adapter checkout_adapters;
    private List<Betting> check_data = new ArrayList<>();



    protected  void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.checkout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarcheck);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Betika");
        tabLayout= (TabLayout)findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Normal (1)"));
        tabLayout.addTab(tabLayout.newTab().setText("Virtual (0)"));
        tabLayout.addTab(tabLayout.newTab().setText("Shikisha (0)"));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviews);
        checkout_adapters = new checkout_adapter(check_data,  this);
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(checkout_adapters);
        checkviewmodel = ViewModelProviders.of(this).get(checkViewModel.class);
        checkviewmodel.getAllData().observe(this, new Observer<List<Betting>>() {
            @Override
            public void onChanged(@Nullable  List<Betting> bettings) {

                checkout_adapters.setbets(bettings);
            }
        });
    }
//        @Override
//    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
//        Log.d(TAG, "checkout: onViewClicked ");
//        switch (clickedViewId){
//            case R.id.cancel:
//                   checkviewmodel.deleteAll();
//                break;
//
//        }
//    }

    @Override
    public void onViewClicked(Betting betting) {
        Log.d(TAG, "checkout: onViewClicked ");
        checkviewmodel.delete(betting);
    }
}
