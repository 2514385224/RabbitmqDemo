package com.jju.sshweb.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jju.sshweb.model.Category;
import com.jju.sshweb.model.Categorysecond;
import com.jju.sshweb.model.Product;
import com.jju.sshweb.service.CategorySecondService;
import com.jju.sshweb.service.CategoryService;
import com.jju.sshweb.service.ProductService;

@SessionAttributes(value="csMap")
@Controller
public class CategorySecondAction {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategorySecondService categorySecondService;
	@RequestMapping("product_findByCid")
	public String product_findByCid(Integer cid,Model model) {
		Map<Category,List<Categorysecond>> csMap=new LinkedHashMap<>();
		
		List<Category> clist=categoryService.selectAll();
		for(Category c:clist)
		{
			int categoryid=c.getCid();
			System.out.println(categoryid);
			List<Categorysecond> cslist=categorySecondService.selectByPrimaryCid(categoryid);
			csMap.put(c,cslist);
		}
		model.addAttribute("csMap", csMap);
		
		System.out.println(csMap);
		//按照传过来的cid进行查询二级分类所有商品
		List<Categorysecond> CategorySecondList=categorySecondService.selectByPrimaryCid(cid);
		
		Page<Product> page=PageHelper.startPage(1, 5) ;
		List<Product> plists=new ArrayList<>();
		for(Categorysecond cs:CategorySecondList)
		{
			int CategorySecondId=cs.getCsid();
			System.out.println("按照一级分类查询出来的二级分类信息"+CategorySecondId);
			List<Product> plist=productService.selectByPrimaryCsid(CategorySecondId);
			for(Product p : plist)
			{
				System.out.println(p);
				plists.add(p);
			}
		}
		PageInfo<Product> pageInfo = new PageInfo<>(plists);
		
		
		model.addAttribute("pageInfo", pageInfo);
		System.out.println(plists.size());
		System.out.println(page.getEndRow());
		
		
		//按照一级分类查询的所有商品信息
		model.addAttribute("plists", plists);
		return "productList";
	}
	@RequestMapping("product_findByCsid")
	public String product_findByCsid(Integer csid,Model model)
	{
		List<Product> plists=productService.selectByPrimaryCsid(csid);
		
		//按照一级分类查询的所有商品信息
		model.addAttribute("plists", plists);
		return "productList";
	}
	
}
