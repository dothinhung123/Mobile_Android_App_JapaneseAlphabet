package com.example.a1_1701040127;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Name    -CardRecylerAdapter
 * Source  -which extends and implement all the necessary methods from RecyclerView
 * - RecyclerView is a ViewGroup
 * -RecyclerView.Adapter , is a store used to control data and update data needed used in View
 * -RecyclerAdapter.ViewHolder used to assigned value for each component to show in View
 *
 * @see androidx.recyclerview.widget.RecyclerView.Adapter
 * Purpose -  Resuable component for GridLayoutManager
 */
public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.MyViewHolder> {
    //initalize context
    //context def: allow access to the information of states inside app
    private Context context;
    //initalize cardlist
    private List<Card> cards;
    //initalize mediaPlayer
    //mediaPlayer def: add and control audio/video files
    private MediaPlayer mediaPlayer;

    //contructor
    public CardRecyclerAdapter(Context context, List<Card> cards) {
        this.context = context;
        this.cards = cards;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // initalize view
        View view;
        //initalize layoutinflater
        // layoutinflater : a component assist to convert file.xml to view
        LayoutInflater mInflater = LayoutInflater.from(context);
        //convert card.xml layout to view
        // attachToRoot =false it means that root is only used to create the correct subclass of LayoutParams for the root view in the XML.
        view = mInflater.inflate(R.layout.card, parent, false);
        //create new viewholder with this view
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // assign data inside the holder to show to the view
        //set images
        holder.img.setImageResource(cards.get(position).getId());
        //set click event
        holder.img.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //new media is created
                        mediaPlayer = MediaPlayer.create(holder.img.getContext(), cards.get(position).getSound());

                        //if not playing
                        if (mediaPlayer.isPlaying()) {
                            //pause it
                            mediaPlayer.pause();
                        } else {
                            //start it
                            mediaPlayer.start();
                        }


                    }
                }

        );

    }

    @Override
    public int getItemCount() {
        // length of card list
        return cards.size();
    }

    /**
     * Name: MyViewHolder
     * Source: extends from RecylerView.ViewHolder
     * Purpose: assign resources for the view
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // initalize ImageButton
        // a button has an image
        ImageButton img;

        public MyViewHolder(View view) {
            super(view);
            //create new images in view
            img = (ImageButton) view.findViewById(R.id.letter_image_id);


        }
    }
}
