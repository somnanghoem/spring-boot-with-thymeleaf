package vandy.page.controller.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vandy.page.service.PageOwnerService;
import vandy.page.service.UserPageService;

@Controller
@RequestMapping("/view/user_page")
public class UserPageViewController {
	
	@Autowired
	private UserPageService userPageService;
	@Autowired
	private PageOwnerService pageOwnerService;
	
	@RequestMapping({"/", ""})
	public String userIndex( Model model ) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		List <Map<String, Object> > list = userPageService.retriveListUserPageInfo( param );
		List<Map<String, Object> > ownerList = pageOwnerService.retriveListPageOwnerInfo(param);
		
		model.addAttribute("ownerList", ownerList );
		model.addAttribute("pageList", list );
		// return page
		return "page/pagecontroll";
	}
	
	@RequestMapping("/report")
	public String report(  ) {
		return "page/report";
	}

}
