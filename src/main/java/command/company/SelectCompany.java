package command.company;

import command.Command;
import entities.dto.CompanyDto;
import service.CompanyService;
import view.View;

public class SelectCompany implements Command {
    public static final String COMMAND_NAME = "select company";
    View view;
    CompanyService service;

    public SelectCompany(View view, CompanyService service) {
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
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                view.write("Incorrect input, use only digits!");
            }
        }
        dto = service.read(dto.getId());
        view.write(dto.toString());
    }
}
