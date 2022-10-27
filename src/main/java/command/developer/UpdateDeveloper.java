package command.developer;

import command.Command;
import entities.dto.DeveloperDto;
import service.DeveloperService;
import view.View;

public class UpdateDeveloper implements Command {
    public static final String COMMAND_NAME = "update developer";
    View view;
    DeveloperService service;

    public UpdateDeveloper(View view, DeveloperService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        DeveloperDto dto = new DeveloperDto();
        view.write("Please enter developer id:");
        while (true){
            try{
                dto.setId(Integer.parseInt(view.read()));
                break;
            } catch (NumberFormatException e){
                view.write("Incorrect input, use only digits!");
            }
        }
        view.write("Please enter developer name:");
        dto.setName(view.read());
        view.write("Please enter developer age:");
        dto.setAge(Integer.parseInt(view.read()));
        view.write("Please enter developer gender:");
        dto.setGender(view.read());
        view.write("Please enter developer salary:");
        dto.setSalary(Integer.parseInt(view.read()));
        dto = service.update(dto.getId(), dto);
        view.write(String.format("Developer id = %d was updated", dto.getId()));
        view.write(dto.toString());
    }
}
