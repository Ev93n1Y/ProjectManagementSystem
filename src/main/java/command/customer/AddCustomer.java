package command.customer;

import command.Command;
import entities.dto.CustomerDto;
import service.CustomerService;
import view.View;

public class AddCustomer implements Command {
    public static final String COMMAND_NAME = "add customer";
    private final View view;
    private final CustomerService service;

    public AddCustomer(View view, CustomerService service) {
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
        view.write("Please enter customer name:");
        dto.setName(view.read());
        view.write("Please enter customer email:");
        dto.setEmail(view.read());
        dto = service.create(dto);
        view.write("New customer added");
        view.write(dto.toString());
    }
}
