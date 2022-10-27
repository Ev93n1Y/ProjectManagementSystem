package command.skill;

import command.Command;
import entities.dto.SkillDto;
import service.SkillService;
import view.View;

public class SelectSkill implements Command {
    public static final String COMMAND_NAME = "select skill";
    View view;
    SkillService service;

    public SelectSkill(View view, SkillService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(COMMAND_NAME);
    }

    @Override
    public void execute() {
        SkillDto dto = new SkillDto();
        view.write("Please enter skill id:");
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