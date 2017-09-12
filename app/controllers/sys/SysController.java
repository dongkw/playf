package controllers.sys;

import java.util.HashMap;
import java.util.Map;

import common.controller.BaseController;



public class SysController extends BaseController {

	/**
	 * 修改密码页面
	 */
	public static void index(){
		getBigdataFromBrighteaseService().save();
		render("/dataFromBrightease/index1.html");
	}
	public static void dataCollection(){
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> sourcesMap=getBigdataSourceService().getAllData();
		Map<String,Object> countMap=getBigdataFromBrighteaseService().getCount();
		map.put("sourceList",sourcesMap.get("list"));
		map.put("num",countMap.get("num"));
		render("/dataFromBrightease/dataCollection.html",map);
	}
	public static void getData(String startTime,int pageSize){
		Map<String,Object> map= getBigdataFromBrighteaseService().getAllData(startTime,pageSize);
		renderJSON(map);

	}
}