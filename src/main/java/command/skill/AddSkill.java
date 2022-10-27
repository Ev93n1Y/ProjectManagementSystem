package command.skill;

import command.Command;
import entities.dto.SkillDto;
import service.SkillService;
import view.View;

public class AddSkill implements Command {
    public static final String COMMAND_NAME = "add skill";
    private final View view;
    private final SkillService service;

    public AddSkill(View view, SkillService service) {
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
        view.write("Please enter skill name:");
        dto.setDepartment(view.read());
        view.write("Please enter skill level:");
        dto.setLevel(view.read());
        dto = service.create(dto);
        view.write("New skill added");
        view.write(dto.toString());
    }
}