package com.jju.sshweb.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jju.sshweb.model.Product;
import com.jju.sshweb.service.ProductService;

@Controller
public class ProductAction {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("product_findByPid")
	public String product_findByPid(Integer pid,Model model)
	{
		Product product=productService.selectByPrimaryKey(pid);
		
		model.addAttribute("product", product);
		return "product";
	}
}
