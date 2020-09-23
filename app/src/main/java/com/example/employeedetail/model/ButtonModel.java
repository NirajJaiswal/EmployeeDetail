package com.example.employeedetail.model;

public class ButtonModel
{
    private int buttonId;
    private String buttonName;

    public ButtonModel(int buttonId, String buttonName) {
        this.buttonId = buttonId;
        this.buttonName = buttonName;
    }

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }
}
