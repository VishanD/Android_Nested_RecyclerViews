package com.example.vishan.recyclerviewexcercise.model;

import com.example.vishan.recyclerviewexcercise.R;

import java.util.ArrayList;

/**
 * Created by vishan on 7/2/16.
 */
public class Sailboat {

    private int imageID;

    public void setInnerImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getInnerImageID() {
        return imageID;
    }

    public static ArrayList<Sailboat> getData() {

        ArrayList<Sailboat> innerDataList = new ArrayList<>();

        int images[] = getImages();

        for (int i = 0; i < images.length; i++) {
            Sailboat sailboat = new Sailboat();
            sailboat.setInnerImageID(images[i]);

            innerDataList.add(sailboat);
        }

        return innerDataList;
    }

    private static int[] getImages() {

        int images[] = {
                R.drawable.boatone, R.drawable.boattwo, R.drawable.boatthree, R.drawable.boatfour, R.drawable.boatfive, R.drawable.boatsix
        };

        return images;
    }
}
