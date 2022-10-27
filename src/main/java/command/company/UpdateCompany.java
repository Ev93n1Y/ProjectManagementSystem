package command.company;

import command.Command;
import entities.dto.CompanyDto;
import service.CompanyService;
import view.View;

public class UpdateCompany implements Command {
    public static final String COMMAND_NAME = "update company";
    View view;
    CompanyService service;

    public UpdateCompany(View view, CompanyService service) {
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
        view.write("Please enter company id:");
        while (true){
            try{
                dto.setId(Integer.parseInt(view.read()));
                break;
            } catch (NumberFormatException e){
                view.write("Incorrect input, use only digits!");
            }
        }
        view.write("Please enter company name:");
        dto.setName(view.read());
        view.write("Please enter company location:");
        dto.setLocation(view.read());
        dto = service.update(dto.getId(), dto);
        view.write(String.format("Company id = %d was updated", dto.getId()));
        view.write(dto.toString());
    }
}
