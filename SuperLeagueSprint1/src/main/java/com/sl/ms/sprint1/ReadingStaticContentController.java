package com.sl.ms.sprint1;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadingStaticContentController implements CommandLineRunner{

	final Logger LOGGER = LoggerFactory.getLogger(getClass());	
	static String data1 = null;
	 
	 @Override
	    public void run(String... args) throws Exception 
	    {
	        Resource resource = new ClassPathResource("static/data.txt");
	        InputStream inputStream = resource.getInputStream();
	        try {
	            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
	            String data = new String(bdata, StandardCharsets.UTF_8);
	            data1 = data;
	            LOGGER.info(data);
	        } catch (IOException e) {
	            LOGGER.error("IOException", e);
	        }
	        
	    }
	 
	 @RequestMapping("/data")
	 @ResponseBody
	 public static String Data() {
		 return data1;
		}
	 
	 
}
