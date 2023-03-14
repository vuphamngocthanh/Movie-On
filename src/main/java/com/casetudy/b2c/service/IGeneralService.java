package com.casetudy.b2c.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    T findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
