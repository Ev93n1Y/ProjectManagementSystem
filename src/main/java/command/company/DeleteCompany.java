package command.company;

import command.Command;
import service.CompanyService;
import service.CustomerService;
import view.View;

public class DeleteCompany  implements Command {
    public static final String COMMAND_NAME = "del company";
    private final View view;
    private final CompanyService service;

    public DeleteCompany(View view, CompanyService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        int id;
        view.write("Please enter company id:");
        while (true){
            try{
                id = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                view.write("Incorrect input, use only digits!");
            }
        }
        service.delete(id);
    }
}



