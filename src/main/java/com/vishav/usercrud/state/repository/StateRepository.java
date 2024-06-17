package com.vishav.usercrud.state.repository;

import com.vishav.usercrud.state.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long> {
    List<StateEntity> findByName(String name);
}