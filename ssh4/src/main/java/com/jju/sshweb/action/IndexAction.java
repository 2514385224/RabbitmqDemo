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
	//��Ʒע��
	@Autowired
	private ProductService productService;
	
	//��Ʒһ���˵�ע��
	@Autowired
	private CategoryService categoryService;
	@RequestMapping("index")
	public String index(Model model)
	{
		//��Ʒһ���˵���ѯ
		List<Category> clist=categoryService.selectAll();
		model.addAttribute("clist", clist);
		
		
		//��������Ʒ���в�ѯ
//		Page<Product> page1=PageHelper.startPage(1, 10);
		
		List<Product> hList=productService.selectByPrimaryHot(1);
//		System.out.println(hList.size());
//		for(Product p : hList)
//		{
//			System.out.println(p);
//		}
		model.addAttribute("hList", hList);
		
		//��������Ʒ���в�ѯ
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
