package command.company;

import command.Command;
import entities.dto.CompanyDto;
import service.CompanyService;
import view.View;

public class AddCompany implements Command {
    public static final String COMMAND_NAME = "add company";
    private final View view;
    private final CompanyService service;

    public AddCompany(View view, CompanyService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        CompanyDto dto = new CompanyDto();
        view.write("Please enter company name:");
        dto.setName(view.read());
        view.write("Please enter company location:");
        dto.setLocation(view.read());
        dto = service.create(dto);
        view.write("New company was added");
        view.write(dto.toString());
    }
}

