package com.example.betika_ui.ui.home;

import android.app.Application;
import android.os.AsyncTask;

import com.example.betika_ui.db.Betting;
import com.example.betika_ui.db.Bettingdatabase;
import com.example.betika_ui.db.betDao;
import com.example.betika_ui.repository.repository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private repository rep;
    private LiveData<List<Betting>> mbetting;
    private betDao betdao;
    private Bettingdatabase bettingdatabase;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        rep = new repository((application));

    }

    public void insert(Betting betting)
    {
        rep.insert(betting);
    }

}