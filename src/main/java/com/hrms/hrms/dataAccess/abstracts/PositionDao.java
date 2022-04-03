package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionDao extends JpaRepository<Position,Integer> {
	Position getByName(String name);
}
