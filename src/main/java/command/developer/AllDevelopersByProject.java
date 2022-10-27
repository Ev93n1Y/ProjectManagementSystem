package command.developer;

import command.Command;
import service.DeveloperService;
import view.View;

public class AllDevelopersByProject implements Command {
    public static final String COMMAND_NAME = "project devs";
    View view;
    DeveloperService service;

    public AllDevelopersByProject(View view, DeveloperService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        int id;
        view.write("Please enter project id:");
        while (true){
            try{
                id = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                view.write("Incorrect input, use only digits!");
            }
        }
        String result = service.AllDevelopersByProject(id).toString();
        view.write(result);
    }
}
