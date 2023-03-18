package com.sebastianZok;
import com.sebastianZok.utils.CommandLineWriter;

public class Main{

    public static void main(String[] args) throws Exception {
        CommandLineWriter.write("Welcome to your command line based crowdfunding platform");
        ControlPanelInterface controlPanel = new ControlPanel();
        controlPanel.inputAction();
    }
}

