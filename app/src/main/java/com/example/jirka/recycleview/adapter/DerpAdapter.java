package com.example.jirka.recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jirka.recycleview.R;
import com.example.jirka.recycleview.model.ListItem;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Jirka on 26.7.2016.
 */
public class DerpAdapter extends RecyclerView.Adapter<DerpAdapter.DerpHolder>{

    private List<ListItem> listData;
    private LayoutInflater inflater;

    public DerpAdapter (List<ListItem> listData, Context c) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(c);   // layout inflater v kontextu volající třídy (UI)

    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p/>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p/>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @Override
    public DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // vytvoření view jedné položky z xml
        View view = inflater.inflate(R.layout.list_item, parent, false);
        //DerpHolder obsahuje ukazatele na views v rámci tednoho ItemView
        return new DerpHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p/>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p/>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle effcient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(DerpHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.tvTitle.setText(item.getTitle());  // tvTitle dané položky se naplní z getteru položky
        holder.imIcon.setImageResource(item.getImageResID());   //setImageResource si jako zdroj bere ID ikony z resouce inventory uloženém v holderu přes getter
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return listData.size();
    }

    // view holder přiřazuje data do view
    class DerpHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private ImageView imIcon;
        private View container;   //  bude potřeba až při definování OnClick;

        public DerpHolder(View itemView) {    // toto je constructor
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.lblItemtext);
            imIcon = (ImageView) itemView.findViewById(R.id.item_icon);
            container = itemView.findViewById(R.id.cont_item_root);   // zde není nutné přetypování - findViewById výsledek je ID view, což je id layoutu
        }
    }

}
