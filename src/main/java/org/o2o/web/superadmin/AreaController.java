package org.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.o2o.entity.Area;
import org.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping("/superadmin")
public class AreaController {
	Logger logger=LoggerFactory.getLogger(AreaController.class);
	
	@Autowired
	private AreaService areaService;
	
	@ResponseBody
	@RequestMapping(value="/listarea",method=RequestMethod.GET)
	private Map<String,Object> listArea(){
		logger.info("====start====");
		long startTime=System.currentTimeMillis();//获取当前时间
		Map<String,Object> modelMap=new HashMap<>();
		List<Area> list=new ArrayList<>();
		list = areaService.getAreaList();
		try {
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		}catch(Exception e){
			e.printStackTrace();
			modelMap.put("success",false);
			modelMap.put("errMsg",e.toString());
		}
		logger.error("test error!");
		long endTime=System.currentTimeMillis();//获取当前时间
		logger.debug("costTime:[{}ms]",endTime-startTime);
		logger.info("====end====");
		return modelMap;
	}

}
