package org.gdut.idlegoods.dao;

import java.util.List;

import org.gdut.idlegoods.bean.Goods;
import org.gdut.idlegoods.bean.Requirement;

public interface RequirementsDao {

	//保存用户发布的需求
	boolean saveRequirements(Requirement re);

	List<Requirement> getMyRequirements(Integer userId);

	Requirement getOneRequirement(String reId);

	boolean updateRe(Requirement re);

	boolean delete(String reId);

	boolean clearRe(String userId);
	
	
	

}
