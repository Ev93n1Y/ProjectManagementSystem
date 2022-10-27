package command.developer;

import command.Command;
import service.CustomerService;
import service.DeveloperService;
import view.View;

public class DeleteDeveloper  implements Command {
    public static final String COMMAND_NAME = "del developer";
    private final View view;
    private final DeveloperService service;

    public DeleteDeveloper(View view, DeveloperService service) {
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
        view.write("Please enter developer id:");
        while (true){
            try{
                id = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                view.write("Incorrect input, use only digits!");
            }
        }
        service.delete(id);
        //view.write(String.format("Developer id = %d was removed", id));
    }
}