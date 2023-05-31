package vandy.page.controller.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vandy.page.service.PageOwnerService;

@Controller
@RequestMapping("/view/page_owner")
public class PageOwnerViewController {
	
	
	@Autowired
	private PageOwnerService  pageOwnerService;
	
	
	@RequestMapping({"/", ""})
	public String userIndex( Model model ) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		List <Map<String, Object> > list = pageOwnerService.retriveListPageOwnerInfo( param );
		model.addAttribute("pageOwnerList", list );
		// return page
		return "page/pageowner";
	}

}
