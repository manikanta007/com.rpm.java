package com.wweb.app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DisplayImage() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpeg");
		ServletOutputStream out=response.getOutputStream();
		BufferedInputStream input=new BufferedInputStream(new FileInputStream("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg"));
		BufferedOutputStream output=new BufferedOutputStream(out);
		int ch=0;
		
//		if((ch=input.read())!=-1){
		while((ch=input.read())!=-1){
			
			output.write(ch);
//		}
		}
		output.close();
		input.close();
		out.close();
	}
}
