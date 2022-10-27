package command.customer;

import command.Command;
import service.CompanyService;
import service.CustomerService;
import view.View;

public class DeleteCustomer  implements Command {
    public static final String COMMAND_NAME = "del customer";
    private final View view;
    private final CustomerService service;

    public DeleteCustomer(View view, CustomerService service) {
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
        view.write("Please enter customer id:");
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
        //view.write(String.format("Customer id = %d was removed", id));
    }
}
