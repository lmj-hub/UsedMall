package org.gdut.idlegoods.service;

import java.util.List;

import org.gdut.idlegoods.bean.Goods;
import org.gdut.idlegoods.bean.Requirement;
import org.gdut.idlegoods.dao.RequirementsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mj
 *处理与需求相关的业务
 */
@Service
public class RequirementsService {
	@Autowired
	RequirementsDao requirementDao;

	public boolean saveRequirements(Requirement re) {
		// TODO Auto-generated method stub
		return requirementDao.saveRequirements(re);
	}

	public List<Requirement> getMyRequirements(Integer userId) {
		// TODO Auto-generated method stub
		return requirementDao.getMyRequirements(userId);
	}

	public Requirement getOneRequirement(String reId) {
		// TODO Auto-generated method stub
		return requirementDao.getOneRequirement(reId);
	}

	public boolean updateRe(Requirement re) {
		// TODO Auto-generated method stub
		return requirementDao.updateRe(re);
	}

	public boolean delete(String reId) {
		return requirementDao.delete(reId);
		
		// TODO Auto-generated method stub
		
	}

	public boolean clearRe(String userId) {
		// TODO Auto-generated method stub
		return requirementDao.clearRe(userId);
	}

}
