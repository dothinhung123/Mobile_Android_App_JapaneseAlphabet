package com.example.a1_1701040127;

// selection: when user click to the image the sound will be display
public class Selection {
    // name of sound
    private String name;
    // the position of sound in raw folder
    private int id;

    //constructor
    public Selection(String name, int id) {
        this.name = name;
        this.id = id;
    }

    //getter && setter
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
