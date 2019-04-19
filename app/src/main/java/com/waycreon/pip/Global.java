package com.waycreon.pip;

import android.app.Application;
import android.graphics.Bitmap;

/**
 * Created by Waycreon on 7/31/2015.
 */
public class Global extends Application {
    public static boolean isLimited = true;

    Bitmap image;
    private int position = 0;

    private int color = 0xFFFF0000;


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
