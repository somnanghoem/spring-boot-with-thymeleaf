package vandy.page.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vandy.page.service.UserPageService;
import vandy.page.type.ResponseResultTypeCode;
import vandy.page.util.request.RequestData;
import vandy.page.util.response.ResponseData;
import vandy.page.util.response.ResponseHeader;

@RestController
@RequestMapping("/api/v1/user_page")
public class UserPageController {
	
	@Autowired
	private UserPageService userPageService;
	
	
	/**
	 * @param inputData
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/register")
	public  ResponseData< Map<String, Object> > registerUserPage( @RequestBody  RequestData<Map<String, Object>> inputData )  throws Exception {
		
		
		ResponseHeader	reponseHeader = new ResponseHeader();
		reponseHeader.setHeader( "Y", ResponseResultTypeCode.SUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.SUCCESS_MESSAGE.getDescription(), "");
		Map<String, Object> resutl = new HashMap<>();
		try {
		   
			long success = userPageService.registerUserPageInfo( inputData.getBody() );
			resutl.put("register", success );
			
		} catch ( Exception e ) {
			e.printStackTrace();
			System.out.println( ">>>>>>>>>>> error >>>>>>>>>>" + e.getMessage() );
			reponseHeader.setHeader( "N", ResponseResultTypeCode.UNSUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.UNSUCCESS_MESSAGE.getDescription(), "");
		}
		return new ResponseData< Map<String, Object> >( reponseHeader, resutl );
		
	}
	
	
	/**
	 * @param inputData
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public  ResponseData< Map<String, Object> > updateUserPage( @RequestBody  RequestData<Map<String, Object>> inputData )  throws Exception {
		
		
		ResponseHeader	reponseHeader = new ResponseHeader();
		reponseHeader.setHeader( "Y", ResponseResultTypeCode.SUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.SUCCESS_MESSAGE.getDescription(), "");
		Map<String, Object> resutl = new HashMap<>();
		try {
		   
			long success = userPageService.updateUserPageInfo( inputData.getBody() );
			resutl.put("update", success );
			
		} catch ( Exception e ) {
			e.printStackTrace();
			System.out.println( ">>>>>>>>>>> error >>>>>>>>>>" + e.getMessage() );
			reponseHeader.setHeader( "N", ResponseResultTypeCode.UNSUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.UNSUCCESS_MESSAGE.getDescription(), "");
		}
		return new ResponseData< Map<String, Object> >( reponseHeader, resutl );
		
	}
	
	
	/**
	 * @param inputData
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public  ResponseData< Map<String, Object> > retrieveList( @RequestBody  RequestData<Map<String, Object>> inputData )  throws Exception {
		
		
		ResponseHeader	reponseHeader = new ResponseHeader();
		reponseHeader.setHeader( "Y", ResponseResultTypeCode.SUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.SUCCESS_MESSAGE.getDescription(), "");
		Map<String, Object> resutl = new HashMap<>();
		try {
		   
			List< Map<String, Object> > list = userPageService.retriveListUserPageInfo( inputData.getBody() );
			resutl.put("list", list );
			
		} catch ( Exception e ) {
			e.printStackTrace();
			System.out.println( ">>>>>>>>>>> error >>>>>>>>>>" + e.getMessage() );
			reponseHeader.setHeader( "N", ResponseResultTypeCode.UNSUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.UNSUCCESS_MESSAGE.getDescription(), "");
		}
		return new ResponseData< Map<String, Object> >( reponseHeader, resutl );
		
	}
	
	/**
	 * @param inputData
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/delete")
	public  ResponseData< Map<String, Object> > deleteUserPage( @RequestBody  RequestData<Map<String, Object>> inputData )  throws Exception {
		
		
		ResponseHeader	reponseHeader = new ResponseHeader();
		reponseHeader.setHeader( "Y", ResponseResultTypeCode.SUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.SUCCESS_MESSAGE.getDescription(), "");
		Map<String, Object> resutl = new HashMap<>();
		try {
		   
			Map<String, Object> param = new HashMap<>();
			param.put("page_id", inputData.getBody().get("page_id") );
			long success = userPageService.deleteUserPage(param);
			resutl.put("success", success );
			
		} catch ( Exception e ) {
			e.printStackTrace();
			System.out.println( ">>>>>>>>>>> error >>>>>>>>>>" + e.getMessage() );
			reponseHeader.setHeader( "N", ResponseResultTypeCode.UNSUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.UNSUCCESS_MESSAGE.getDescription(), "");
		}
		return new ResponseData< Map<String, Object> >( reponseHeader, resutl );
		
	}
	
	

}
