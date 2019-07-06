package org.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.o2o.BaseTest;
import org.o2o.entity.HeadLine;
import org.springframework.beans.factory.annotation.Autowired;

public class HeadLineDaoTest extends BaseTest{
	@Autowired
	private HeadLineDao headLineDao;
	
	@Test
	public void testQueryHeadLine() {
		List<HeadLine> headLineList=headLineDao.queryHeadLine(new HeadLine());
		assertEquals(1, headLineList.size());
	}
}
