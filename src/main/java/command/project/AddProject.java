package command.project;

import command.Command;
import entities.dto.ProjectDto;
import service.ProjectService;
import view.View;

import java.sql.Date;

public class AddProject implements Command {
    public static final String COMMAND_NAME = "add project";
    private final View view;
    private final ProjectService service;

    public AddProject(View view, ProjectService service) {
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
        view.write("Please enter project name:");
        dto.setName(view.read());
        view.write("Please enter project company_id:");
        dto.setCompany_id(Integer.parseInt(view.read()));
        view.write("Please enter project customer_id:");
        dto.setCustomer_id(Integer.parseInt(view.read()));
        view.write("Please enter project cost:");
        dto.setCost(Integer.parseInt(view.read()));
        view.write("Please enter project creation date:");
        while (true){
            try{
                dto.setCreation_date(Date.valueOf(view.read()));
                break;
            } catch (IllegalArgumentException e){
                view.write("Please use format YYYY-MM-DD!");
            }
        }
        dto = service.create(dto);
        view.write("New project was added");
        view.write(dto.toString());
    }
}
