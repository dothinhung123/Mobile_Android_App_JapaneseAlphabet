package com.example.a1_1701040127;

//Object Card
public class Card {
    //id of sounds
    private int id;
    // the position of sound in drawable folder
    private int sound;

    //constructor
    Card(int id, int sound) {
        this.id = id;
        this.sound = sound;
    }

    //getter && setter
    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
