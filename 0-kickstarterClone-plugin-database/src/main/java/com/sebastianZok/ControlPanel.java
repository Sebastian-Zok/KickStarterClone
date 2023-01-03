package com.sebastianZok;

import com.sebastianZok.utils.CommandLineReader;
 import java.util.HashMap;

public class ControlPanel implements ControlPanelInterface {

    HashMap<Integer, ControlPanelInterface> controls = new HashMap();

    public ControlPanel(){
       controls.put(1, new CreateAccount());
       //controls.put(2, new Login());
    }

    @Override
    public void inputAction() {
        do{
            System.out.println(
                    "What do you want to do next?\n" +
                    "1| Create a new account\n" +
                    "2| Login to your account\n"
            );
            String stringResponse = CommandLineReader.readLine();
            try{
                int res = Integer.parseInt(stringResponse);
                if(res==0) break;


                controls.get(res).inputAction();
                System.out.println("Enter to continue");
                String awaitKey = CommandLineReader.readLine();
                if(!awaitKey.equals("")) break;
            }catch (Exception e){
                System.out.println(e);
            }
        }while(true);
    }
}
