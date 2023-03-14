package com.casetudy.admin.service;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    T findById(Integer id);

    void save(T t);

    void remove(Integer id);

}
