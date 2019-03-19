package com.jju.sshweb.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jju.sshweb.model.Category;
import com.jju.sshweb.model.Product;
import com.jju.sshweb.service.CategoryService;
import com.jju.sshweb.service.ProductService;

@SessionAttributes(value="clist")
@Controller
public class IndexAction {
	//商品注入
	@Autowired
	private ProductService productService;
	
	//商品一级菜单注入
	@Autowired
	private CategoryService categoryService;
	@RequestMapping("index")
	public String index(Model model)
	{
		//商品一级菜单查询
		List<Category> clist=categoryService.selectAll();
		model.addAttribute("clist", clist);
		
		
		//对热门商品进行查询
//		Page<Product> page1=PageHelper.startPage(1, 10);
		
		List<Product> hList=productService.selectByPrimaryHot(1);
//		System.out.println(hList.size());
//		for(Product p : hList)
//		{
//			System.out.println(p);
//		}
		model.addAttribute("hList", hList);
		
		//对最新商品进行查询
		List<Product> nList=productService.selectByPrimaryPdate();
//		for(Product p : nList)
//		{
//			System.out.println(p);
//		}
		model.addAttribute("nList", nList);
		
		
		
		return "index";
	}
	@RequestMapping("user_quit")
	public String user_quit(HttpServletRequest request)
	{
		request.getSession().removeAttribute("user");
		
		return "login";
	}
	@RequestMapping("user_loginPage")
	public String login()
	{
		return "login";
	}
	@RequestMapping("user_registPage")
	public String resgist()
	{
		return "regist";
	}
	

}
