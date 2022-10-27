package command.customer;

import command.Command;
import entities.dto.CustomerDto;
import service.CustomerService;
import view.View;

public class UpdateCustomer implements Command {
    public static final String COMMAND_NAME = "update customer";
    View view;
    CustomerService service;

    public UpdateCustomer(View view, CustomerService service) {
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
            } catch (NumberFormatException e){
                view.write("Incorrect input, use only digits!");
            }
        }
        view.write("Please enter customer name:");
        dto.setName(view.read());
        view.write("Please enter customer email:");
        dto.setEmail(view.read());
        dto = service.update(dto.getId(), dto);
        view.write(String.format("Customer id = %d was updated", dto.getId()));
        view.write(dto.toString());
    }
}
