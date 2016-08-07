package com.example.vishan.recyclerviewexcercise.model;

import com.example.vishan.recyclerviewexcercise.R;

import java.util.ArrayList;

/**
 * Created by vishan on 7/2/16.
 */
public class Landscape {

    private int imageID;
    private String title;
    private String description;

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageID() {
        return imageID;
    }

    public String  getTitle() {
        return title;
    }

    public String  getDescription() {
        return description;
    }

    public static ArrayList<Landscape> getData() {

        ArrayList<Landscape> dataList = new ArrayList<>();

        int[] images = getImages();

        for (int i=0; i < images.length; i++) {

            Landscape landscape = new Landscape();
            landscape.setImageID(images[i]);
            landscape.setTitle("Landscape " + i);
            landscape.setDescription("Description " + i);

            dataList.add(landscape);
        }

        return dataList;
    }

    private static int[] getImages() {

        int[] images = {
                R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,
                R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.eleven, R.drawable.thirteen, R.drawable.fourteen, R.drawable.fifteen,
                R.drawable.sixteen};

        return images;
    }
}
