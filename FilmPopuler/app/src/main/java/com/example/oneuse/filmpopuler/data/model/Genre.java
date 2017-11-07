package com.example.oneuse.filmpopuler.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ONEUSE on 30/10/2017.
 */

public class Genre {
    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "GenresItem{" +
                        "name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }

}

