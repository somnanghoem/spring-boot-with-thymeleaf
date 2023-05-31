package vandy.page.service;

import java.util.List;
import java.util.Map;

public interface PageOwnerService {
	
	public long registerPageOwnerInfo( Map<String, Object> param ) throws Exception;
	public long updatePageOwnerInfo( Map<String, Object> param ) throws Exception;
	public Map<String, Object> retrivePageOwnerInfo( Map<String, Object > param ) throws Exception;
	public List< Map<String, Object>  > retriveListPageOwnerInfo( Map<String, Object > param ) throws Exception;
	public long deletePageOwner( Map<String, Object> param ) throws Exception;
	
}
