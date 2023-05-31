package vandy.page.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vandy.page.service.PageOwnerService;
import vandy.page.type.ResponseResultTypeCode;
import vandy.page.util.request.RequestData;
import vandy.page.util.response.ResponseData;
import vandy.page.util.response.ResponseHeader;

@RestController
@RequestMapping("/api/v1/page_owner")
public class PageOwnerController {
	
	@Autowired
	private PageOwnerService pageOwnerService;
	
	/**
	 * @param inputData
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/register")
	public  ResponseData< Map<String, Object> > registerPageOwner( @RequestBody  RequestData<Map<String, Object>> inputData )  throws Exception {
		
		ResponseHeader	reponseHeader = new ResponseHeader();
		reponseHeader.setHeader( "Y", ResponseResultTypeCode.SUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.SUCCESS_MESSAGE.getDescription(), "");
		Map<String, Object> resutl = new HashMap<>();

		try {
		
			long success = pageOwnerService.registerPageOwnerInfo( inputData.getBody() );
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
	public  ResponseData< Map<String, Object> > updatePageOwner( @RequestBody  RequestData<Map<String, Object>> inputData )  throws Exception {
		
		ResponseHeader	reponseHeader = new ResponseHeader();
		reponseHeader.setHeader( "Y", ResponseResultTypeCode.SUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.SUCCESS_MESSAGE.getDescription(), "");
		Map<String, Object> resutl = new HashMap<>();
		try {
		
			long success = pageOwnerService.updatePageOwnerInfo( inputData.getBody() );
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
		   
			List< Map<String, Object> > list = pageOwnerService.retriveListPageOwnerInfo( inputData.getBody() );
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
	public  ResponseData< Map<String, Object> > deletePageOwner( @RequestBody  RequestData<Map<String, Object>> inputData )  throws Exception {
		
		ResponseHeader	reponseHeader = new ResponseHeader();
		reponseHeader.setHeader( "Y", ResponseResultTypeCode.SUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.SUCCESS_MESSAGE.getDescription(), "");
		Map<String, Object> resutl = new HashMap<>();
		try {
		
			Map<String, Object> param = new HashMap<>();
			param.put("id", inputData.getBody().get("id") );
			long success = pageOwnerService.deletePageOwner(param);
			resutl.put("success", success );
			
		} catch ( Exception e ) {
			e.printStackTrace();
			System.out.println( ">>>>>>>>>>> error >>>>>>>>>>" + e.getMessage() );
			reponseHeader.setHeader( "N", ResponseResultTypeCode.UNSUCCESS_MESSAGE.getValue(),  ResponseResultTypeCode.UNSUCCESS_MESSAGE.getDescription(), "");
		}
		return new ResponseData< Map<String, Object> >( reponseHeader, resutl );
		
	}

}
