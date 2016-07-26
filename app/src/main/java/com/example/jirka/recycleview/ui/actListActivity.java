package com.example.jirka.recycleview.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.jirka.recycleview.R;
import com.example.jirka.recycleview.adapter.DerpAdapter;
import com.example.jirka.recycleview.model.DerpData;

public class actListActivity extends AppCompatActivity {
    private RecyclerView recView;   //  odkaz RecyclerView
    private DerpAdapter adapter;    //  odkaz na náš adaptér



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recView = (RecyclerView) findViewById(R.id.recycler_list); // odklaz na RecyclerView

        // /GridLayoutManager, StaggeredGridLayoutManager, RecyclerView.LayoutManager
        recView.setLayoutManager(new LinearLayoutManager(this));   // přiřazení layoutManagera k RecyclerView

        adapter = new DerpAdapter(DerpData.getListData(), this);  // parametry budou dále doplněny
        recView.setAdapter(adapter);

    }
}
