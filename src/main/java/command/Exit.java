package command;

import exceptions.ExitException;
import view.View;

public class Exit implements Command{
    public static final String COMMAND_NAME = "exit";

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        throw new ExitException();
    }
}
