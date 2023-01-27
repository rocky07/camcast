package com.ff.camcast.camcast.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.commons.io.FileUtils;
import java.util.Base64;
import java.io.File;
import java.io.*;

@RestController
class DataController{

	@PostMapping("/saveImg")
	public void saveImg(@RequestBody String dataImg) throws IOException{
		//System.out.println(dataImg);
		String str = dataImg;
		byte[] decodedBytes = Base64.getDecoder().decode(str.substring(23));
		FileUtils.writeByteArrayToFile(new File("files/"+Math.random()*2000+"img.jpg"), decodedBytes);
	   	System.out.println("image files completed");
		FileWriter myWriter = new FileWriter("files/"+Math.random()*10000+".txt");
      		myWriter.write(dataImg);
      		myWriter.close();
		System.out.println("text file completed!");
	}
}

