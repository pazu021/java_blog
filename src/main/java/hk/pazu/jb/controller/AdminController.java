package hk.pazu.jb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("index")
	public String index() {
		return "index";
	}

}
