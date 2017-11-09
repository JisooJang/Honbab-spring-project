package org.springframework.samples.honbab.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/filedown")
public class FileController {
	@RequestMapping(method = RequestMethod.GET)
	public void viewImage(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		String root_path = request.getSession().getServletContext().getRealPath("/");  
		String attach_path = "images\\restr\\";


		String fileName = request.getParameter("file_name");
        String sDownloadPath = "C://menu/";
        String sFilePath = root_path+attach_path + fileName;
        
        File file = new File(sFilePath);
        
        response.setContentType("application/download; charset=utf-8");
        response.setContentLength((int) file.length());
        String userAgent = request.getHeader("User-Agent");
        
 
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        OutputStream out = response.getOutputStream();
 
        FileInputStream fis = null;
 
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
        } finally {
            if(fis != null)
                try {
                    fis.close();
                } catch(IOException ex) {
                }
        }
        out.flush();

	}
}
