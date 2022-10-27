package command.skill;

import command.Command;
import entities.dto.SkillDto;
import service.SkillService;
import view.View;

public class UpdateSkill implements Command {
    public static final String COMMAND_NAME = "update skill";
    View view;
    SkillService service;

    public UpdateSkill(View view, SkillService service) {
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
            } catch (NumberFormatException e){
                view.write("Incorrect input, use only digits!");
            }
        }
        view.write("Please enter skill name:");
        dto.setDepartment(view.read());
        view.write("Please enter skill level:");
        dto.setLevel(view.read());
        dto = service.update(dto.getId(), dto);
        view.write(String.format("Skill id = %d was updated", dto.getId()));
        view.write(dto.toString());
    }
}
