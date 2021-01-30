package com.example.a1_1701040127;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import  java.util.ArrayList;

import static com.example.a1_1701040127.R.id.name_alphabet_button;
import static com.example.a1_1701040127.R.id.recyclerview_id;

/**
 *Name    : -class MainActivity
 *          -extends from AppCompatActiviy
 * Purpose:Launched the android app
 */

public class MainActivity extends AppCompatActivity  {
    //initialize
    List<Card> cards;
    List<Selection> selections;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //set view for this app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create cards list when the app first start
        cards = new ArrayList<>();
        for (int i = 0; i < ListResources.images_h.length; i++) {
            Card card = new Card(ListResources.images_h[i], ListResources.sounds[i]);
            cards.add(card);
        }
        //creat selection list: hiragana && katagrana
        selections = new ArrayList<>();
        Selection s1 = new Selection("Hiragana", 1);
        Selection s2 = new Selection("Katagana", 2);
        selections.add(s1);
        selections.add(s2);

        //find the recyclerview in the layout
        RecyclerView listLetter = (RecyclerView) findViewById(recyclerview_id);
        //create new recyclerAdapter to store necessary data needed for the recyclerView
        CardRecyclerAdapter myAdapter = new CardRecyclerAdapter(this,cards);
        //set layout for the recyclerView
        listLetter.setLayoutManager(new GridLayoutManager(this,5));
        //set new recyclerAdapter fro recyclerView
        listLetter.setAdapter(myAdapter);

        RecyclerView buttonType =(RecyclerView) findViewById(name_alphabet_button);
        SelectionRecycleAdapter selectionAdapter = new SelectionRecycleAdapter(this,selections);
        buttonType.setLayoutManager(new GridLayoutManager(this,2));
        buttonType.setAdapter(selectionAdapter);

        selectionAdapter.setWhenClickListener(new SelectionRecycleAdapter.OnItemsClickListener() {
            @Override
            public void onItemClick(Selection selection) {
                setSelections(selection.getId());
                textView =findViewById(R.id.text_app);
                textView.setText(selection.getName());

            }
        });


    }
    // set selection when user click choose hiragana or katagan
    public void setSelections(int num){
        cards = new ArrayList<>();
        // click hiragana
        if(num==1 ){
            for (int i = 0; i < ListResources.images_h.length; i++) {
                Card card = new Card(ListResources.images_h[i], ListResources.sounds[i]);
                cards.add(card);
            }


        }
        //click katagrana
        else if(num==2){
            for (int i = 0; i < ListResources.images_k.length; i++) {
                Card card = new Card(ListResources.images_k[i], ListResources.sounds[i]);
                cards.add(card);
            }


        }
        //set the view again to show in the app
        RecyclerView listLetter = (RecyclerView) findViewById(recyclerview_id);
        CardRecyclerAdapter myAdapter = new CardRecyclerAdapter(this,cards);
        listLetter.setLayoutManager(new GridLayoutManager(this,5));
        listLetter.setAdapter(myAdapter);

    }
}