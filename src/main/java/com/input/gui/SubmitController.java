package com.input.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitController implements ActionListener {
    private final App APP;
    private final Controller CONTROLLER;

    public SubmitController(App myApp) {
        this.CONTROLLER = new Controller();
        this.APP = myApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (CONTROLLER.validate(APP.getUser(), APP.getPassword())) {
            APP.loginSuccess();

        } else {
            APP.loginFailure();
        }

        APP.showLoginMessage();
    }
}
