package command.project;

import command.Command;
import service.DeveloperService;
import service.ProjectService;
import view.View;

public class DeleteProject  implements Command {
    public static final String COMMAND_NAME = "del project";
    private final View view;
    private final ProjectService service;

    public DeleteProject(View view, ProjectService service) {
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
        service.delete(id);
    }
}
