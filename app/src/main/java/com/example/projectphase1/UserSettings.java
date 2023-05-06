package com.example.projectphase1;

import android.app.Application;



// Class With the user settings we need named here


public class UserSettings extends Application {

public static final String PREFERENCES = "preferences";
    public static final String Custom_Theme = "CustomTheme";
    public static final String Light_Theme = "LightTheme";
    public static final String Dark_Theme = "DarkTheme";


    private String customTheme;

    public String getCustomTheme()
    {
        return customTheme;
    }

    public void setCustomTheme(String customTheme) {
        this.customTheme = customTheme;
    }
}
