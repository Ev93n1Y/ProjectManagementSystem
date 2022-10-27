package command.customer;

import command.Command;
import entities.dto.CustomerDto;
import service.CustomerService;
import view.View;

public class SelectCustomer implements Command {
    public static final String COMMAND_NAME = "select customer";
    View view;
    CustomerService service;

    public SelectCustomer(View view, CustomerService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        CustomerDto dto = new CustomerDto();
        view.write("Please enter customer id:");
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