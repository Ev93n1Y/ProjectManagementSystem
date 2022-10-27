package command;

import command.company.AddCompany;
import command.company.DeleteCompany;
import command.company.SelectCompany;
import command.company.UpdateCompany;
import command.customer.AddCustomer;
import command.customer.DeleteCustomer;
import command.customer.SelectCustomer;
import command.customer.UpdateCustomer;
import command.developer.*;
import command.project.AddProject;
import command.project.DeleteProject;
import command.project.SelectProject;
import command.project.UpdateProject;
import command.skill.AddSkill;
import command.skill.DeleteSkill;
import command.skill.SelectSkill;
import command.skill.UpdateSkill;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Help implements Command{
    private static final String HELP = "help";
    private final View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(HELP);
    }

    @Override
    public void execute() {
        List<String> commandList = new ArrayList<>();

        commandList.add(String.format("Enter >%s< to see all commands", HELP));
        commandList.add(String.format("Enter >%s< to exit program", Exit.COMMAND_NAME));

        commandList.add(String.format("Enter >%s< to see developers total salary by project",
                TotalDevelopersSalaryByProject.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to see all developers by project",
                AllDevelopersByProject.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to see all Java developers",
                AllJavaDevelopers.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to see all middle developers",
                AllMiddleDevelopers.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to see projects list",
                AllProjects.COMMAND_NAME));

        commandList.add(String.format("Enter >%s< to add new company", AddCompany.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to add new customer", AddCustomer.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to add new developer", AddDeveloper.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to add new project", AddProject.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to add new skill", AddSkill.COMMAND_NAME));

        commandList.add(String.format("Enter >%s< to delete company", DeleteCompany.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to delete customer", DeleteCustomer.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to delete developer", DeleteDeveloper.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to delete project", DeleteProject.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to delete skill", DeleteSkill.COMMAND_NAME));

        commandList.add(String.format("Enter >%s< to select company", SelectCompany.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to select customer", SelectCustomer.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to select developer", SelectDeveloper.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to select project", SelectProject.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to select skill", SelectSkill.COMMAND_NAME));

        commandList.add(String.format("Enter >%s< to update company", UpdateCompany.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to update customer", UpdateCustomer.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to update developer", UpdateDeveloper.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to update project", UpdateProject.COMMAND_NAME));
        commandList.add(String.format("Enter >%s< to update skill", UpdateSkill.COMMAND_NAME));

        view.write("Commands list:");
        for(String command: commandList){
            view.write(command);
        }
    }
}
