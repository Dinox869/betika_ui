package com.example.betika_ui.ui.checkout;

import android.app.Application;
import android.os.AsyncTask;

import com.example.betika_ui.adapter.checkout_data;
import com.example.betika_ui.db.Betting;
import com.example.betika_ui.db.Bettingdatabase;
import com.example.betika_ui.db.betDao;
import com.example.betika_ui.repository.repository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class checkViewModel  extends AndroidViewModel {

    private LiveData<List<Betting>> checkList;
    private repository rep;

    public checkViewModel(@NonNull Application application) {
        super(application);
        rep = new repository((application));
        checkList = rep.getAllData();
    }

    public void deleteAll()
    {
        rep.deleteAll();
    }

    LiveData<List<Betting>> getAllData()
    {
        return checkList;
    }

    public void delete(Betting betting)
    {
        rep.delete(betting);
    }

}
