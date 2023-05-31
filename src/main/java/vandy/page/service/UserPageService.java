package vandy.page.service;

import java.util.List;
import java.util.Map;

public interface UserPageService {
	
	public long registerUserPageInfo( Map<String, Object> param ) throws Exception;
	public long updateUserPageInfo( Map<String, Object> param ) throws Exception;
	public Map<String, Object> retriveUserPageInfo( Map<String, Object > param ) throws Exception;
	public List< Map<String, Object>  > retriveListUserPageInfo( Map<String, Object > param ) throws Exception;
	public long deleteUserPage( Map<String, Object> param ) throws Exception;

}
