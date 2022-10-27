package command;

import java.sql.SQLException;

public interface Command {
    boolean canExecute(String input);

    void execute();
}
