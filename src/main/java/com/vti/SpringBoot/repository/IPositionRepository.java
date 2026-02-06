package com.vti.SpringBoot.repository;

import com.vti.SpringBoot.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {

}
