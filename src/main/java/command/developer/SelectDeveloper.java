package command.developer;

import command.Command;
import entities.dto.DeveloperDto;
import service.DeveloperService;
import view.View;

public class SelectDeveloper implements Command {
    public static final String COMMAND_NAME = "select developer";
    View view;
    DeveloperService service;

    public SelectDeveloper(View view, DeveloperService service) {
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
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                view.write("Incorrect input, use only digits!");
            }
        }
        dto = service.read(dto.getId());
        view.write(dto.toString());
    }
}