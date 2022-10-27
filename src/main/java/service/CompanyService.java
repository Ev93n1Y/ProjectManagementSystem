package service;

import entities.dao.CompanyDao;
import entities.dto.CompanyDto;
import repository.CompanyRepository;
import service.converter.CompanyConverter;

public class CompanyService implements Crud<CompanyDto>{
    private final CompanyRepository repository;
    private final CompanyConverter converter;

    public CompanyService(CompanyRepository repository, CompanyConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }
    @Override
    public CompanyDto create(CompanyDto dto){
        CompanyDao dao = repository.save(converter.to(dto));
        return converter.from(dao);
    }
    @Override
    public CompanyDto read(Integer id){
        CompanyDao dao = repository.selectById(id);
        return converter.from(dao);
    }
    @Override
    public CompanyDto update(Integer id, CompanyDto dto){
        CompanyDao dao = repository.updateById(id, converter.to(dto));
        return converter.from(dao);
    }
    @Override
    public void delete(Integer id){
        repository.deleteById(id);
    }
}
