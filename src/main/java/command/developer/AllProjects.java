package command.developer;

import command.Command;
import service.ProjectService;
import view.View;

public class AllProjects implements Command {
    public static final String COMMAND_NAME = "all projects";
    View view;
    ProjectService service;

    public AllProjects(View view, ProjectService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        String result = service.AllProjects().toString();
        view.write(result);
    }
}