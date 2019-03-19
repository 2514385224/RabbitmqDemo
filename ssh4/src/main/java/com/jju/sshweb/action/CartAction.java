package com.jju.sshweb.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jju.sshweb.model.Orderitem;
import com.jju.sshweb.model.Orders;
import com.jju.sshweb.model.Product;
import com.jju.sshweb.service.ProductService;
@SessionAttributes("cart")
@Controller
public class CartAction {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("cart_addCart")
	public String cart_addCart(int pid,int count,Model model,HttpSession session)
	{
		
		System.out.println(pid+"-----"+count);
		Map<Product,Orderitem> cart=(Map<Product, Orderitem>) session.getAttribute("cart");
		
		if(cart==null)
		{
			cart=new LinkedHashMap<>();
		}
		System.out.println("session cart"+cart);
		int i=0;
		Set<Product> setProduct=cart.keySet();
		System.out.println("set product"+setProduct);
		
		for(Product p:setProduct)
		{
			if(p.getPid()==pid)
			{
				Orderitem orderitem=cart.get(p);
				cart.remove(p);
				orderitem.setCount(orderitem.getCount()+count);
				cart.put(p, orderitem);
				i++;
			}
		}
		System.out.println("i:"+i);
		if(i==0)
		{
			Product p=productService.selectByPrimaryKey(pid);
			Orderitem orderitem=new Orderitem();
			orderitem.setCount(count);
			orderitem.setPid(p.getPid());
			orderitem.setSubtotal(count*p.getShopPrice());
			cart.put(p,orderitem);
		}
		
		System.out.println("cart :"+cart);
		model.addAttribute("cart",cart);
		return "cart";
	}
}
