package command.developer;

import command.Command;
import service.DeveloperService;
import view.View;

public class AllMiddleDevelopers implements Command {
    public static final String COMMAND_NAME = "all middle devs";
    View view;
    DeveloperService service;

    public AllMiddleDevelopers(View view, DeveloperService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        String result = service.AllMiddleDevelopers().toString();
        view.write(result);
    }
}
