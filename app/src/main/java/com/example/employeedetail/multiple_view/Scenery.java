package com.example.employeedetail.multiple_view;

public class Scenery {
    private int sceneryImage;
    private int sceneryOneImage;
    private int sceneryTwoImage;

    public Scenery(int sceneryImage, int sceneryOneImage, int sceneryTwoImage) {
        this.sceneryImage = sceneryImage;
        this.sceneryOneImage = sceneryOneImage;
        this.sceneryTwoImage = sceneryTwoImage;
    }

    public int getSceneryImage() {
        return sceneryImage;
    }

    public void setSceneryImage(int sceneryImage) {
        this.sceneryImage = sceneryImage;
    }

    public int getSceneryOneImage() {
        return sceneryOneImage;
    }

    public void setSceneryOneImage(int sceneryOneImage) {
        this.sceneryOneImage = sceneryOneImage;
    }

    public int getSceneryTwoImage() {
        return sceneryTwoImage;
    }

    public void setSceneryTwoImage(int sceneryTwoImage) {
        this.sceneryTwoImage = sceneryTwoImage;
    }
}
