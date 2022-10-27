import command.*;
import command.company.*;
import command.customer.*;
import command.developer.*;
import command.project.*;
import command.skill.*;
import config.DatabaseManagerConnector;
import config.PropertiesConfig;
import controller.ProjectManagementSystem;
import repository.*;
import service.*;
import service.converter.*;
import view.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Launch {
    public static void main(String[] args) {
        String dbUsername = System.getenv("dbUsername");
        String dbPassword = System.getenv("dbPassword");
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        Properties properties = propertiesConfig.loadProperties("application.properties");
        DatabaseManagerConnector connector = new DatabaseManagerConnector(properties, dbUsername, dbPassword);

        CompanyService companyService =
                new CompanyService(new CompanyRepository(connector), new CompanyConverter());
        CustomerService customerService =
                new CustomerService(new CustomerRepository(connector), new CustomerConverter());
        DeveloperService developerService =
                new DeveloperService(new DeveloperRepository(connector), new DeveloperConverter());
        ProjectService projectService =
                new ProjectService(new ProjectRepository(connector), new ProjectConverter());
        SkillService skillService =
                new SkillService(new SkillRepository(connector), new SkillConverter());

        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        List<Command> commandList = new ArrayList<>();
        ProjectManagementSystem projectManagementSystem = new ProjectManagementSystem(console, commandList);
        commandList.add(new Help(console));
        commandList.add(new Exit());
        commandList.add(new TotalDevelopersSalaryByProject(console, developerService));
        commandList.add(new AllDevelopersByProject(console, developerService));
        commandList.add(new AllJavaDevelopers(console, developerService));
        commandList.add(new AllMiddleDevelopers(console, developerService));
        commandList.add(new AllProjects(console, projectService));

        commandList.add(new AddCompany(console, companyService));
        commandList.add(new AddCustomer(console, customerService));
        commandList.add(new AddDeveloper(console, developerService));
        commandList.add(new AddProject(console, projectService));
        commandList.add(new AddSkill(console, skillService));
        commandList.add(new DeleteCompany(console,companyService));
        commandList.add(new DeleteCustomer(console,customerService));
        commandList.add(new DeleteDeveloper(console,developerService));
        commandList.add(new DeleteProject(console,projectService));
        commandList.add(new DeleteSkill(console,skillService));
        commandList.add(new UpdateCompany(console,companyService));
        commandList.add(new UpdateCustomer(console,customerService));
        commandList.add(new UpdateDeveloper(console,developerService));
        commandList.add(new UpdateProject(console,projectService));
        commandList.add(new UpdateSkill(console,skillService));
        commandList.add(new SelectCompany(console,companyService));
        commandList.add(new SelectCustomer(console,customerService));
        commandList.add(new SelectDeveloper(console,developerService));
        commandList.add(new SelectProject(console,projectService));
        commandList.add(new SelectSkill(console,skillService));
        projectManagementSystem.run();
    }
}
