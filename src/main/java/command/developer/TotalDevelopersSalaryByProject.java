package command.developer;

import command.Command;
import service.DeveloperService;
import view.View;

public class TotalDevelopersSalaryByProject implements Command {
    public static final String COMMAND_NAME = "total project devs salary";
    View view;
    DeveloperService service;

    public TotalDevelopersSalaryByProject(View view, DeveloperService service) {
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
        String result = service.TotalDevelopersSalaryByProject(id).toString();
        view.write(result);
    }
}
