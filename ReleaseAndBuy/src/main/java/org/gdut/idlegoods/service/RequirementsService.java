package org.gdut.idlegoods.service;

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

}
