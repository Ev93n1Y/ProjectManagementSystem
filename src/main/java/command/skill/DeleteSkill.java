package command.skill;

import command.Command;
import service.CompanyService;
import service.SkillService;
import view.View;

public class DeleteSkill  implements Command {
    public static final String COMMAND_NAME = "del skill";
    private final View view;
    private final SkillService service;

    public DeleteSkill(View view, SkillService service) {
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
        view.write("Please enter skill id:");
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
        view.write(String.format("Skill id = %d was removed", id));
    }
}
