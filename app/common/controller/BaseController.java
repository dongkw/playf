package common.controller;
import models.model.BigdataFromBrightease;
import models.model.BigdataSource;
import models.service.BigdataFromBrighteaseService;
import models.service.BigdataSourceService;

import play.mvc.Controller;

/**
 * <一句话简述本类作用>
 * 
 * @author rone
 * @version 创建时间：2013-6-25 下午3:18:19
 * @version 1.0
 * @since 1.0
 */

public class BaseController extends Controller {
    

	public static BigdataFromBrighteaseService getBigdataFromBrighteaseService() {
		return (BigdataFromBrighteaseService) play.modules.spring.Spring.getBeanOfType(BigdataFromBrighteaseService.class);
	}
	public static BigdataSourceService getBigdataSourceService() {
		return (BigdataSourceService) play.modules.spring.Spring.getBeanOfType(BigdataSourceService.class);
	}


}
