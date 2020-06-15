package com.bipin.E__COMMERCE.Controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bipin.E__COMMERCE.Dao.CategoryDao;
import com.bipin.E__COMMERCE.Dao.ProductDao;
import com.bipin.E__COMMERCE.Dto.Category;
import com.bipin.E__COMMERCE.Dto.Product;




@Controller
@MultipartConfig
public class ProductController 
{
	
	
	@RequestMapping("/product")
	public String product(MultipartHttpServletRequest request,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		
		try
		{
		String title=req.getParameter("title");
		String description=req.getParameter("description");
		String price=req.getParameter("price");
        String discount=req.getParameter("discount");
		String quantity=req.getParameter("quantity");
		int cat=Integer.parseInt(req.getParameter("cat"));
		
		//file upload 
		MultipartFile multipart=request.getFile("file");
		String filename=multipart.getOriginalFilename();
		long size=multipart.getSize();
		System.out.println("file name::"+filename+"file size::"+size);
		//H:/adj/file/product_img/
		File file=new File("C:/Users/DELL/git/bipin/Web_Frontend/Web_Frontend/src/main/resources/assest/product/"+filename);
		FileOutputStream fos=null;

			fos=new FileOutputStream(file);
			byte[] bytes=multipart.getBytes();
			fos.write(bytes);
			fos.close();
			System.out.println("file uploaded succesfully done");
		
		
		CategoryDao cdao=new CategoryDao();
		Category c=cdao.getCategory(cat);
		
		System.out.println("title:"+title+"description:"+description+"price:"+price+"discount:"+discount+"quantity::"+quantity+"cat::"+cat+"photo::"+filename);
		Product p=new Product(title,description,filename,price,discount,quantity,c);
		
		
		ProductDao pdao=new ProductDao();
		int id=pdao.setProduct(p);	
		
		HttpSession h=req.getSession();
	    h.setAttribute("message","Product added succesfully! ID="+id);
        

		}
		catch(Exception e)
		{
			System.out.println("error"+e.getMessage());
		}
		
		return "admin";
	}

}
