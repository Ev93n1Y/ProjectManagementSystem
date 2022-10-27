package service;

import entities.dao.ProjectDao;
import entities.dto.ProjectDto;
import repository.ProjectRepository;
import service.converter.ProjectConverter;

public class ProjectService implements Crud<ProjectDto> {
    private final ProjectRepository repository;
    private final ProjectConverter converter;

    public ProjectService(ProjectRepository repository, ProjectConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }
    @Override
    public ProjectDto create(ProjectDto dto){
        ProjectDao dao = repository.save(converter.to(dto));
        return converter.from(dao);
    }
    @Override
    public ProjectDto read(Integer id){
        ProjectDao dao = repository.selectById(id);
        return converter.from(dao);
    }
    @Override
    public ProjectDto update(Integer id, ProjectDto dto){
        ProjectDao dao = repository.updateById(id, converter.to(dto));
        return converter.from(dao);
    }
    @Override
    public void delete(Integer id){
        repository.deleteById(id);
    }

    public StringBuilder AllProjects(){
        return repository.selectAllProjects();
    }
}
