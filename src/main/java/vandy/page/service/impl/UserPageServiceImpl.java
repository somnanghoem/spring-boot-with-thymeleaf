package vandy.page.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vandy.page.repository.UserPageDAO;
import vandy.page.service.UserPageService;
import vandy.page.util.DataUtil;

@Service
public class UserPageServiceImpl implements UserPageService {

	@Autowired
	private UserPageDAO userPageDAO;
	
	@Override
	public long registerUserPageInfo(Map<String, Object> param) throws Exception {
		
		try {
			
			// maxPageID
			Map<String, Object > maxInfo = userPageDAO.retrieveMaxPageID();
			String maxPageID = StringUtils.leftPad( maxInfo.get("maxPageID").toString() , 6, "0" );
			
			BigDecimal totalPageEarning = DataUtil.getBigDecimal( param.get("page_earning") ) ;
			BigDecimal office_percent = totalPageEarning.multiply( BigDecimal.valueOf( 0.4  ) ); // 40%
			BigDecimal owner_percent = totalPageEarning.multiply( BigDecimal.valueOf( 0.6  ) ); // 40%
			
			Map<String, Object > registerParam = new HashMap<>();
			registerParam.put("page_id",		 	maxPageID );
			registerParam.put("owner_id",			param.get("owner_id") );
			registerParam.put("userPage_name",		param.get("userPage_name") );
			registerParam.put("page_name", 			param.get("page_name") );
			registerParam.put("page_earning", 		param.get("page_earning") );
			registerParam.put("office_percent",   	office_percent );
			registerParam.put("owner_percent",  	owner_percent );
			
			return userPageDAO.registerUserPageInfo( registerParam );
			
		} catch (Exception e) {
			throw e;
		}
		
		
	}

	@Override
	public long updateUserPageInfo(Map<String, Object> param) throws Exception {
		
		try {
			
			Map<String, Object > updateParam = new HashMap<>();
			
			BigDecimal totalPageEarning = DataUtil.getBigDecimal( param.get("page_earning") ) ;
			BigDecimal office_percent = totalPageEarning.multiply( BigDecimal.valueOf( 0.4  ) ); // 40%
			BigDecimal owner_percent = totalPageEarning.multiply( BigDecimal.valueOf( 0.6  ) ); // 40%
			
			updateParam.put("page_id", 			param.get("page_id") );
			updateParam.put("owner_id", 		param.get("owner_id") );
			updateParam.put("userPage_name", 	param.get("userPage_name") );
			updateParam.put("page_name", 		param.get("page_name") );
			updateParam.put("page_earning", 	param.get("page_earning") );
			updateParam.put("office_percent",  	office_percent );
			updateParam.put("owner_percent",  	owner_percent );
			return userPageDAO.updateUserPageInfo(updateParam);
			
		} catch ( Exception e ) {
			throw e;
		}
		
		
	}

	@Override
	public Map<String, Object> retriveUserPageInfo(Map<String, Object> param) throws Exception {
		return userPageDAO.retriveUserPageInfo(param);
	}

	@Override
	public List<Map<String, Object>> retriveListUserPageInfo(Map<String, Object> param) throws Exception {
		return userPageDAO.retriveListUserPageInfo(param);
	}

	@Override
	public long deleteUserPage(Map<String, Object> param) throws Exception {
		return userPageDAO.deleteUserPage(param);
	}

}
