package com.input.gui;

import java.util.Locale;

public class Controller {
    public boolean validate(String user, String password) {
        if (!user.toLowerCase().equals("nero")) {
            return false;

        } else if (!password.toLowerCase().equals("admin")) {
            return false;

        } else {
            return true;
        }
    }
}
