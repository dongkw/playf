package models.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import models.dao.BigdataSourceDao;

import models.model.BigdataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





@Service
@Transactional
public class BigdataSourceService {


	@Autowired
	private BigdataSourceDao bigdataSourceDao;

	public Map<String, Object> getAllData() {
		Map<String, Object> map = new HashMap<>();
		List list = bigdataSourceDao.findList(null);
		map.put("list", list);
		return map;
	}
}
