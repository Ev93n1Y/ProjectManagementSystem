package service;

import entities.dao.DeveloperDao;
import entities.dto.DeveloperDto;
import repository.DeveloperRepository;
import service.converter.DeveloperConverter;

public class DeveloperService implements Crud<DeveloperDto> {
    private final DeveloperRepository repository;
    private final DeveloperConverter converter;

    public DeveloperService(DeveloperRepository repository, DeveloperConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }
    @Override
    public DeveloperDto create(DeveloperDto dto){
        DeveloperDao dao = repository.save(converter.to(dto));
        return converter.from(dao);
    }
    @Override
    public DeveloperDto read(Integer id){
        DeveloperDao dao = repository.selectById(id);
        return converter.from(dao);
    }
    @Override
    public DeveloperDto update(Integer id, DeveloperDto dto){
        DeveloperDao dao = repository.updateById(id, converter.to(dto));
        return converter.from(dao);
    }
    @Override
    public void delete(Integer id){
        repository.deleteById(id);
    }

    public StringBuilder TotalDevelopersSalaryByProject(Integer id){
        return repository.selectTotalSalaryByProjectId(id);
    }
    public StringBuilder AllDevelopersByProject(Integer id){
        return repository.selectAllDevelopersByProjectId(id);
    }
    public StringBuilder AllJavaDevelopers(){
        return repository.selectAllJavaDevelopers();
    }
    public StringBuilder AllMiddleDevelopers(){
        return repository.selectAllMiddleDevelopers();
    }
}
