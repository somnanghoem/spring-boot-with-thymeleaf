package vandy.page.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageOwnerDAO {

	public long registerPageOwnerInfo( Map<String, Object> param ) throws Exception;
	public long updatePageOwnerInfo( Map<String, Object> param ) throws Exception;
	public Map<String, Object> retrivePageOwnerInfo( Map<String, Object > param ) throws Exception;
	public List< Map<String, Object>  > retriveListPageOwnerInfo( Map<String, Object > param ) throws Exception;
	public Map<String, Object > retrieveMaxPageID( ) throws Exception;
	public long deletePageOwner( Map<String, Object> param ) throws Exception;
}
