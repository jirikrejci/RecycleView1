package com.example.jirka.recycleview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.jirka.recycleview.R;
import com.example.jirka.recycleview.adapter.DerpAdapter;
import com.example.jirka.recycleview.model.DerpData;

public class actListActivity extends AppCompatActivity implements DerpAdapter.ItemClickCallback {
    // bundle constants
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";


    //internal variables

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

    @Override
    public void onItemClick(int p) {
        Toast.makeText(this, "kliknuto na položku. Item = " + String.valueOf(p), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSecondaryIconCllick(int p) {
        Toast.makeText(this, "kliknuto na hvězdo. Item = " + String.valueOf(p), Toast.LENGTH_SHORT).show();

    }
}
