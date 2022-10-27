package service;

import entities.dao.CustomerDao;
import entities.dto.CustomerDto;
import repository.CustomerRepository;
import service.converter.CustomerConverter;

public class CustomerService implements Crud<CustomerDto>{
    private final CustomerRepository repository;
    private final CustomerConverter converter;

    public CustomerService(CustomerRepository repository, CustomerConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }
    @Override
    public CustomerDto create(CustomerDto dto){
        CustomerDao dao = repository.save(converter.to(dto));
        return converter.from(dao);
    }
    @Override
    public CustomerDto read(Integer id){
        CustomerDao dao = repository.selectById(id);
        return converter.from(dao);
    }
    @Override
    public CustomerDto update(Integer id, CustomerDto dto){
        CustomerDao dao = repository.updateById(id, converter.to(dto));
        return converter.from(dao);
    }
    @Override
    public void delete(Integer id){
        repository.deleteById(id);
    }
}
