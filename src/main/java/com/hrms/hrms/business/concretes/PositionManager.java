package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.PositionService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.PositionDao;
import com.hrms.hrms.entities.concretes.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionManager implements PositionService {
    private PositionDao positionDao;

    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<List<Position>> (positionDao.findAll(),"İş listesi getirildi");
    }
    
    @Override
    public Result add(Position position) {
    	
    	if(!this.ifPositionExists(position.getName()).isSuccess()) {
			return new ErrorResult("This position is already exist.");
		}
		
		this.positionDao.save(position);
		return new SuccessResult("Position successfully added.");
    	
    }
    public Result ifPositionExists(String name) {
    	if(positionDao.getByName(name)!=null) {
    		return new ErrorResult();
    	}
    	return new SuccessResult();
    }
}
