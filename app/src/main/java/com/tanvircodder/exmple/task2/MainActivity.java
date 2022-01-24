package com.tanvircodder.exmple.task2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tanvircodder.exmple.task2.internet.InternetConnection;
import com.tanvircodder.exmple.task2.internet.JsonPerser;
import com.tanvircodder.exmple.task2.model.Util;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Util>> {
    RecyclerView mRecyclerView;
    MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter =  new MyAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        setTitle("Task 2 Java");

        getSupportLoaderManager().initLoader(0,null,this);
    }

    @NonNull
    @Override
    public Loader<List<Util>> onCreateLoader(int id, @Nullable Bundle args) {
        return new AsyncTaskLoader<List<Util>>(this) {
            List<Util> mData = null;
            @Override
            protected void onStartLoading() {
                if (mData != null){
                    deliverResult(mData);
                }else{
                    forceLoad();
                }
            }
            @Nullable
            @Override
            public List<Util> loadInBackground() {
                URL url = InternetConnection.buildURL();
                System.out.println("The url : " + url.toString());
                List<Util> parsingData = null;
                try {
                    String httprequest = InternetConnection.HttpResponse(url);
                    parsingData = JsonPerser.UrlJsonParsing(MainActivity.this,httprequest);
                    return parsingData;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            public void deliverResult(List<Util> data){
                mData = data;
                super.deliverResult(data);
            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Util>> loader, List<Util> data) {
        mAdapter.swapData(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Util>> loader) {
        mAdapter.swapData(null);
    }
}