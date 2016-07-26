package com.example.jirka.recycleview.model;

// toto bude dummy data source

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jirka on 26.7.2016.
 */
public class DerpData {
    private static final String[] titles = {"Běží liška k Táboru", "Nese pytel zázvoru", "Ježek za ní pospíchá"};
    private static final int[] icons = {android.R.drawable.ic_popup_reminder, android.R.drawable.ic_menu_edit, android.R.drawable.ic_btn_speak_now};

    public static List<ListItem> getListData() {

        List<ListItem> data = new ArrayList<>();

        //repeat proces 4 times, so we have enough data to demonstrate Scrollable RecyclerView
        for (int x = 0; x < 4; x++) {
            for (int i = 0; i < titles.length && i < icons.length; i++) {
                ListItem item = new ListItem();
                item.setTitle(String.valueOf(x*3 + i)  + ": " + titles[i] );
                item.setImageResID(icons[i]);
                data.add(item);
            }
        }
        return data;
    };

}
