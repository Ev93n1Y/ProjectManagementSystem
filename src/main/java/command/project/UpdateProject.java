package command.project;

import command.Command;
import entities.dto.ProjectDto;
import service.ProjectService;
import view.View;

import java.sql.Date;

public class UpdateProject implements Command {
    public static final String COMMAND_NAME = "update project";
    View view;
    ProjectService service;

    public UpdateProject(View view, ProjectService service) {
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
            } catch (NumberFormatException e){
                view.write("Incorrect input, use only digits!");
            }
        }
        view.write("Please enter project name:");
        dto.setName(view.read());
        view.write("Please enter project company_id:");
        dto.setCompany_id(Integer.parseInt(view.read()));
        view.write("Please enter project customer_id:");
        dto.setCustomer_id(Integer.parseInt(view.read()));
        view.write("Please enter project cost:");
        dto.setCost(Integer.parseInt(view.read()));
        view.write("Please enter project creation date:");
        dto.setCreation_date(Date.valueOf(view.read()));
        dto = service.update(dto.getId(), dto);
        view.write(String.format("Project id = %d was updated", dto.getId()));
        view.write(dto.toString());
    }
}
