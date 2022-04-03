package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Position;

import java.util.List;

public interface PositionService {
	DataResult<List<Position>> getAll();
    Result add(Position position);
}
