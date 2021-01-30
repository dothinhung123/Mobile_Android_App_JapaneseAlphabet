package com.example.a1_1701040127;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Name    -SelectionRecylerAdapter
 * Source  -which extends and implement all the necessary methods from RecyclerView
 * - RecyclerView is a ViewGroup
 * -RecyclerView.Adapter , is a store used to control data and update data needed used in View
 * -RecyclerAdapter.ViewHolder used to assigned value for each component to show in View
 *
 * @see androidx.recyclerview.widget.RecyclerView.Adapter
 * Purpose -  Resuable component for GridLayoutManager
 */

public class SelectionRecycleAdapter extends RecyclerView.Adapter<SelectionRecycleAdapter.MyViewHolder> {
    private Context context;
    private List<Selection> selections; //Main-list item titles will be stored here
    private OnItemsClickListener listener; //Need this clickListener for the Main-list item onClick events

    //constructor
    public SelectionRecycleAdapter(Context context, List<Selection> selections) {
        this.context = context;
        this.selections = selections;
    }

    //set items when user click
    public void setWhenClickListener(OnItemsClickListener listener) {
        this.listener = listener;
    }


    @Override
    public SelectionRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //initalize view
        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        //convert  selection.xml to view
        view = mInflater.inflate(R.layout.selection, parent, false);
        return new SelectionRecycleAdapter.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SelectionRecycleAdapter.MyViewHolder holder, int position) {
        final Selection modelItems = selections.get(position);
        holder.setData(selections.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(modelItems);
                }
            }
        });
    }

    @Override
    public int getItemCount() {//length of items
        return selections.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //initalize data
        CardView cardView;
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.selection);
            textView = itemView.findViewById(R.id.name_alphabet);

        }

        public void setData(String name) {
            this.textView.setText(name);
        }
    }

    //interface
    public interface OnItemsClickListener {
        void onItemClick(Selection selection);
    }

}
