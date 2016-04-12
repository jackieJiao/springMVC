package com.jiao.controller;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpDownloadController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5176141422652252510L;

	@RequestMapping(value="upload.action")
	public void upload(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//上传的路径：uploadpath
		String uploadpath= "D:\\";
		
		DiskFileItemFactory factory= new DiskFileItemFactory();
		factory.setSizeThreshold(1000*1024);
		ServletFileUpload sfu= new ServletFileUpload(factory);
		List<FileItem> items= sfu.parseRequest(request);
		byte[] bs=new byte[items.get(0).getInputStream().available()];
		items.get(0).getInputStream().read(bs);
		FileOutputStream fos=new FileOutputStream(uploadpath+"test.txt");
		fos.write(bs);
		fos.close();
	}
}
