package com.example.yummlyteam.app.model;

public class DialogInfo {
    private int title;
    private int notification;
    private int positiveText;
    private String additionalDialogInformation;
    private int negativeText;
    private boolean displayNegativeButton = false;

    public DialogInfo (int title, int notification, int positiveText, String additionalDialogInformation) {
        this.title = title;
        this.notification = notification;
        this.positiveText = positiveText;
        this.additionalDialogInformation = additionalDialogInformation;
        this.displayNegativeButton = false;
        this.negativeText = 0;
    }

    public DialogInfo (int title, int notification, int positiveText, String additionalDialogInformation, boolean displayNegativeButton, int negativeText) {
        this.title = title;
        this.notification = notification;
        this.positiveText = positiveText;
        this.additionalDialogInformation = additionalDialogInformation;
        this.displayNegativeButton = displayNegativeButton;
        this.negativeText = negativeText;
    }

    public int getTitle() {
        return title;
    }

    public int getNotification() {
        return notification;
    }

    public int getPositiveText() {
        return positiveText;
    }

    public String getAdditionalDialogInfo() {
        return additionalDialogInformation;
    }

    public int getNegativeText() {
        return negativeText;
    }

    public boolean getDisplayNegativeButton() {
        return displayNegativeButton;
    }

}
