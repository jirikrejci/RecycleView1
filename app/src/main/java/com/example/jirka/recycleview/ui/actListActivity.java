package com.example.jirka.recycleview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.jirka.recycleview.R;
import com.example.jirka.recycleview.adapter.DerpAdapter;
import com.example.jirka.recycleview.model.DerpData;
import com.example.jirka.recycleview.model.ListItem;

import java.util.ArrayList;

public class actListActivity extends AppCompatActivity implements DerpAdapter.ItemClickCallback {
    // bundle constants as a KEYs
    public static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";


    //internal variables

    private RecyclerView recView;   //  odkaz RecyclerView
    private DerpAdapter adapter;    //  odkaz na náš adaptér
    private ArrayList listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listData = (ArrayList) DerpData.getListData();
        recView = (RecyclerView) findViewById(R.id.recycler_list); // odklaz na RecyclerView

        // /GridLayoutManager, StaggeredGridLayoutManager, RecyclerView.LayoutManager
        recView.setLayoutManager(new LinearLayoutManager(this));   // přiřazení layoutManagera k RecyclerView

        //adapter = new DerpAdapter(listData, this);
        adapter = new DerpAdapter(DerpData.getListData(), this);  //  nově po upravení volí tuto variantu
        recView.setAdapter(adapter);
        adapter.setItemClickCallback(this);  // přiřazení callback
    }

    @Override
    public void onItemClick(int p) {
        Toast.makeText(this, "kliknuto na položku. Item = " + String.valueOf(p), Toast.LENGTH_SHORT).show();
        ListItem item = (ListItem) listData.get(p);  // dostáváme data adekvátní k dané položce seznamu
        Intent intent = new Intent(this, actDetailActivity.class);
        Bundle extras = new Bundle();
        extras.putString(EXTRA_QUOTE, item.getTitle());
        extras.putString(EXTRA_ATTR, item.getSubtitle());
        intent.putExtra(BUNDLE_EXTRAS, extras);
        startActivity(intent);
    }

    @Override
    public void onSecondaryIconCllick(int p) {
        Toast.makeText(this, "kliknuto na hvězdo. Item = " + String.valueOf(p), Toast.LENGTH_SHORT).show();
        ListItem item = (ListItem) listData.get(p);
        item.setFavourite(!item.isFavourite());
        adapter.setListData(listData);
        adapter.notifyDataSetChanged();

    }
}
