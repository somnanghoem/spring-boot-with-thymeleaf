package vandy.page.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vandy.page.repository.PageOwnerDAO;
import vandy.page.service.PageOwnerService;

@Service
public class PageOwnerServiceImpl implements PageOwnerService {

	@Autowired
	private PageOwnerDAO  pageOwnerDAO;
	
	@Override
	public long registerPageOwnerInfo(Map<String, Object> param) throws Exception {
		try {
			
			// maxPageID
			Map<String, Object > maxInfo = pageOwnerDAO.retrieveMaxPageID();
			String maxID = StringUtils.leftPad( maxInfo.get("maxID").toString() , 6, "0" );
			
			Map<String, Object > registerParam = new HashMap<>();
			registerParam.put("id",		maxID );
			registerParam.put("name",	param.get("name") );
			registerParam.put("phone", 	param.get("phone") );
			registerParam.put("age", 	param.get("age") );
			
			return pageOwnerDAO.registerPageOwnerInfo( registerParam );
			
		} catch ( Exception e) {
			throw e;
		}
	}

	@Override
	public long updatePageOwnerInfo(Map<String, Object> param) throws Exception {
		return pageOwnerDAO.updatePageOwnerInfo(param);
	}

	@Override
	public Map<String, Object> retrivePageOwnerInfo(Map<String, Object> param) throws Exception {
		return pageOwnerDAO.retrivePageOwnerInfo(param);
	}

	@Override
	public List<Map<String, Object>> retriveListPageOwnerInfo(Map<String, Object> param) throws Exception {
		return pageOwnerDAO.retriveListPageOwnerInfo(param);
	}

	@Override
	public long deletePageOwner(Map<String, Object> param) throws Exception {
		return pageOwnerDAO.deletePageOwner(param);
	}

}
