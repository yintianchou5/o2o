package org.o2o.service.impl;

import java.util.List;

import org.o2o.dao.AreaDao;
import org.o2o.entity.Area;
import org.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	private AreaDao areaDao;
	@Override
	public List<Area> getAreaList() {
		List<Area> areaList = areaDao.queryArea();
		return areaList;
	}
	
}
