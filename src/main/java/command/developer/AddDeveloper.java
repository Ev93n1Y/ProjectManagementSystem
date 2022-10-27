package command.developer;

import command.Command;
import entities.dto.DeveloperDto;
import service.DeveloperService;
import view.View;

public class AddDeveloper implements Command {
    public static final String COMMAND_NAME = "add developer";
    private final View view;
    private final DeveloperService service;

    public AddDeveloper(View view, DeveloperService service) {
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
        view.write("Please enter developer name:");
        dto.setName(view.read());
        view.write("Please enter developer age:");
        dto.setAge(Integer.parseInt(view.read()));
        view.write("Please enter developer gender:");
        dto.setGender(view.read());
        view.write("Please enter developer salary:");
        dto.setSalary(Integer.parseInt(view.read()));
        dto = service.create(dto);
        view.write("New developer was added");
        view.write(dto.toString());
    }
}