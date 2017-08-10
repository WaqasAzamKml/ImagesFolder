package com.approsoft.imagesfolder;

/**
 * Created by Approsoft on 6/22/2017.
 */

public class SingleImage {
    String imagePath;

    public SingleImage(){

    }

    public SingleImage(String imagePath){
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
