package com.example.homepagedemo;

import java.util.ArrayList;

public class Model {

    public enum STATE {
        CLOSED,
        OPENED
    }

    String name;
    int level;
    STATE state = STATE.CLOSED;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    ArrayList<Model> models = new ArrayList<>();



    public Model(String name, int level) {
        this.name = name;
        this.level = level;
    }

}
