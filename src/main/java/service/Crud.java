package service;

import java.util.Optional;

public interface Crud <T> {
    T create(T t);
    T read(Integer id);
    T update(Integer id, T t);
    void delete(Integer id);
}
