package com.example.betika_ui.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.betika_ui.db.Betting;
import com.example.betika_ui.db.Bettingdatabase;
import com.example.betika_ui.db.betDao;

import java.util.List;

import androidx.lifecycle.LiveData;

public  class repository {
    private betDao betdao;
    private  LiveData<List<Betting>> betting;

    public  repository(Application application)
    {
        Bettingdatabase bettingdatabase = Bettingdatabase.getDatabase(application);
        this.betdao = bettingdatabase.bdao();
        this.betting = betdao.getAllData();
    }

   public LiveData<List<Betting>> getAllData()
    {
        return betting;
    }


    //to insert item
    public  void insert(Betting betting)
    {
        new InsertAsyncTask(betdao).execute(betting);
    }


    private  static  class InsertAsyncTask  extends AsyncTask<Betting,Void,Void> {

        private betDao betdaos;

        public InsertAsyncTask(betDao betdao) {
        this.betdaos = betdao;
        }

        @Override
        protected Void doInBackground(Betting... bettings) {
            betdaos.insert(bettings[0]);
            return null;
        }
    }

    //to delete item
    public  void delete(Betting betting)
    {
        new deleteAsyncTask(betdao).execute(betting);
    }

    private static class deleteAsyncTask extends  AsyncTask<Betting, Void,Void>
    {
        private betDao betdaos;

        public deleteAsyncTask(betDao betdao) {
            this.betdaos = betdao;
        }

        @Override
        protected Void doInBackground(Betting... bettings) {
            betdaos.delete(bettings[0]);
            return null;
        }
    }

    public void deleteAll()
    {
        new deleteAllAsyncTask(betdao).execute();
    }

    private static class deleteAllAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private  betDao betDAO;

        public deleteAllAsyncTask(betDao betdao) {
            betDAO = betdao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            betDAO.deleteAll();
            return null;
        }
    }



}
