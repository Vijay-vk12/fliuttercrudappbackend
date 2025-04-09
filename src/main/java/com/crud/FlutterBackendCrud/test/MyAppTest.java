package com.crud.FlutterBackendCrud.test;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("myAppTest")
public class MyAppTest {
	
	@Autowired
	MyAppTestServiceImpl myAppTestServiceImpl;
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody Model model,
			HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> responseMap = new HashMap<>();
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(responseMap, new HttpHeaders(),
				HttpStatus.OK);
		
		
		System.err.println(model.toString());
		HttpSession session = request.getSession();
        session.setAttribute("dataSourceName", "fluttercrud");
        
        MyAppTestEntity myAppTestEntity = new MyAppTestEntity();
        myAppTestEntity.setUserName(model.getUserName());
        myAppTestEntity.setEmailId(model.getEmailId());
        myAppTestEntity.setMobileNumber(model.getMobileNumber());
        Boolean isSaved =  myAppTestServiceImpl.saveData(myAppTestEntity);
		if(isSaved) {
			responseMap.put("succesMsg", "Data Added Success");
		}else {
			responseMap.put("errorMsg", "Error!!!!!!!!!");
		}
		return responseEntity;
	}

}
