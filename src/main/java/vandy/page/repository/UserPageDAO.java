package vandy.page.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPageDAO {

	public long registerUserPageInfo( Map<String, Object> param ) throws Exception;
	public long updateUserPageInfo( Map<String, Object> param ) throws Exception;
	public Map<String, Object> retriveUserPageInfo( Map<String, Object > param ) throws Exception;
	public List< Map<String, Object>  > retriveListUserPageInfo( Map<String, Object > param ) throws Exception;
	public Map<String, Object > retrieveMaxPageID( ) throws Exception;
	public long deleteUserPage( Map<String, Object> param ) throws Exception;
}
