package command.developer;

import command.Command;
import service.DeveloperService;
import view.View;

public class AllJavaDevelopers implements Command {
    public static final String COMMAND_NAME = "all java devs";
    View view;
    DeveloperService service;

    public AllJavaDevelopers(View view, DeveloperService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        String result = service.AllJavaDevelopers().toString();
        view.write(result);
    }
}
