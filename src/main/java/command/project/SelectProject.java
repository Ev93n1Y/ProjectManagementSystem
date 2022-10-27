package command.project;

import command.Command;
import entities.dto.ProjectDto;
import service.ProjectService;
import view.View;

public class SelectProject implements Command {
    public static final String COMMAND_NAME = "select project";
    View view;
    ProjectService service;

    public SelectProject(View view, ProjectService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        ProjectDto dto = new ProjectDto();
        view.write("Please enter project id:");
        while (true){
            try{
                dto.setId(Integer.parseInt(view.read()));
                break;
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                view.write("Incorrect input, use only digits!");
            }
        }
        dto = service.read(dto.getId());
        view.write(dto.toString());
    }
}
