package com.sebastianZok;

public class Main{

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your command line based crowdfunding platform");
        ControlPanelInterface controlPanel = new ControlPanel();
        controlPanel.inputAction();
    }
}

