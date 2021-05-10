package org.gdut.idlegoods.dao;

import org.gdut.idlegoods.bean.Requirement;

public interface RequirementsDao {

	//保存用户发布的需求
	boolean saveRequirements(Requirement re);

}
