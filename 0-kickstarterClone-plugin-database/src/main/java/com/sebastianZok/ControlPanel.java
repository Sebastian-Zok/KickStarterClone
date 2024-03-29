package com.sebastianZok;

import com.sebastianZok.utils.CommandLineReader;
 import java.util.HashMap;
import com.sebastianZok.utils.CommandLineWriter;

public class ControlPanel implements ControlPanelInterface {

    HashMap<Integer, ControlPanelInterface> controls = new HashMap();

    public ControlPanel(){
       controls.put(1, new CreateAccount());
       controls.put(2, new Login());
       controls.put(3, new ViewBalance());
       controls.put(4, new Deposit());
       controls.put(5, new Browse());
       controls.put(6, new CreateProject());
       controls.put(7, new ManageProjects());
    }

    @Override
    public void inputAction() {
        do{
                    new Mediator().mediate();

                    CommandLineWriter.write(
                    "What do you want to do next?\n" +
                    "1| Create a new account\n" +
                    "2| Login to your account\n" +
                    "3| View Balance\n" +
                    "4| Deposit Money\n" +
                    "5| Browse through Projects\n" +
                    "6| Create Project\n" +
                    "7| Manage Projects\n" +
                    "9| Quit\n"
            );
            String stringResponse = CommandLineReader.readLine();
            try{
                int res = Integer.parseInt(stringResponse);

                if(res==9) break;
                if(res > controls.size() || res < 1){
                    CommandLineWriter.write("Invalid Input");
                }else if(SessionService.getInstance() == null && res > 2 ){
                    CommandLineWriter.write("Login required");
                }else{
                    controls.get(res).inputAction();
                }

                CommandLineWriter.write("Enter to continue");
                String awaitEnter = CommandLineReader.readLine();
            }catch (Exception e){
                CommandLineWriter.write(e.toString());
            }
        }while(true);
    }
}
