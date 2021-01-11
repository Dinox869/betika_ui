package com.example.betika_ui;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.betika_ui.adapter.Bets;
import com.example.betika_ui.adapter.bets.Live_bet_adapter;
import com.example.betika_ui.adapter.bets.checkout_adapter;
import com.example.betika_ui.adapter.checkout_data;
import com.example.betika_ui.db.Betting;
import com.example.betika_ui.db.Bettingdatabase;
import com.example.betika_ui.db.betDao;
import com.example.betika_ui.ui.checkout.checkout;
import com.example.betika_ui.ui.home.HomeFragment;
import com.example.betika_ui.ui.home.HomeViewModel;
import com.example.betika_ui.ui.home.MyDividerItemDecoration;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "" ;
    private static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;
    private static final int UPDATE_NOTE_ACTIVITY_REQUEST_CODE = 2 ;

    private List<Bets> betsList =  new ArrayList<>();

    private RecyclerView recyclerView;
    boolean colors = false;
    private Live_bet_adapter list_bet_adapter;

    private betDao betdao;
    private Bettingdatabase bettingdatabase;
    private HomeViewModel homeViewModel;


//    public  MainActivity(Application application){
//        super(application);
//    }




    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        list_bet_adapter = new Live_bet_adapter(betsList);
//        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.addItemDecoration(new MyDividerItemDecoration(this,LinearLayoutManager.VERTICAL,16));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(list_bet_adapter);
//        prepareBetData();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_notifications)
                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onViewClicked: Its now in mainActivity ");
        if (requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {

            Log.d(TAG, "onViewClicked: Successful ");
            // Code to insert note
            Betting betting = new Betting(

                    data.getStringExtra(HomeFragment.TEAM1),
                    data.getStringExtra(HomeFragment.TEAM2),
                    data.getStringExtra(HomeFragment.BET_NUMBER)
            );
            homeViewModel.insert(betting);
            Toast.makeText(
                    getApplicationContext(),
                    R.string.Add_item,
                    Toast.LENGTH_LONG).show();
        }  else {
            Log.d(TAG, "onViewClicked: Failed ");
            Toast.makeText(
                    getApplicationContext(),
                    R.string.No_Item,
                    Toast.LENGTH_LONG).show();
        }
    }

    //    private void prepareBetData()
//    {
//        Bets bets = new Bets("1.87","1", "1","Soccer-club Friendly Games,international Clubs","GIA LAI","KHANH HAO",
//                "2.61","6.13","27+");
//        betsList.add(bets);
//         bets = new Bets("1.56","5", "5","Basketball-KBL,Repubic of Korea","ANYANH","KNIGHTS",
//                "2.61","2.72","41+");
//        betsList.add(bets);
//         bets = new Bets("3.26","1", "1","Soccer-GT World Nation League, Electronics league","NEW ZEALAND","PARAGUAY (MARCH)",
//                "2.26","2.85","18+");
//        betsList.add(bets);
//         bets = new Bets("2.48","2", "2","Soccer - GT World Nation League, Electronics league ","EGYPT(KASANDAN)","GREECE(PANTO)",
//                "2.28","3.87","19+");
//        betsList.add(bets);
//         bets = new Bets("1.48","2", "2","Basketball-CLA Western Conference, Electronics","NEW ORLEANS","SACRAMENTO KENYA",
//                "1.61","4.13","27+");
//        betsList.add(bets);
//         bets = new Bets("1.67","1", "1","Soccer-club Friendly Games,international Clubs","GIA LAI","KHANH HAO",
//                "2.61","6.13","27+");
//        betsList.add(bets);
//         bets = new Bets("1.67","1", "1","Soccer-club Friendly Games,international Clubs","GIA LAI","KHANH HAO",
//                "2.61","6.13","27+");
//        betsList.add(bets);
//         bets = new Bets("1.67","1", "1","Soccer-club Friendly Games,international Clubs","GIA LAI","KHANH HAO",
//                "2.61","6.13","27+");
//        betsList.add(bets);
//         bets = new Bets("1.67","1", "1","Soccer-club Friendly Games,international Clubs","GIA LAI","KHANH HAO",
//                "2.61","6.13","27+");
//        betsList.add(bets);
//        list_bet_adapter.notifyDataSetChanged();
//    }

//    @Override
//    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
//
//    }
}