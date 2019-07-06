package org.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.o2o.BaseTest;
import org.o2o.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;

public class AreaServiceTest extends BaseTest{
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testGetAreaList() {
		List<Area> areaList=areaService.getAreaList();
		assertEquals("东苑", areaList.get(1).getAreaName());
	}
}
