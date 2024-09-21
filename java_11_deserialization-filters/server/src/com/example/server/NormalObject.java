package com.example.server;

import java.io.*;

public class NormalObject implements Serializable {
    private String name;
    public NormalObject(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "NormalObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
