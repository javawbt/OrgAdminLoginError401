package OnboardCloudAccount;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test14LOGINasOrgAdminToCreateGroupONboardOrganizationAsOrgAdminA08_14 {
	HttpClient client;
	HttpPost httpPost;
	HttpPut httpPut;
	HttpResponse response;
	HttpGet httpGet;
	HttpEntity httpEntity;
	JSONParser parser;
	InputStream inputStream;
	Object obj;
	JSONObject jsonObject;
	String actualStatus;
	String actualErrorCode;
	String errorMessage;
	String success;
	String failure;
	String thisMethodName;
	String filePath = "C:/";
	
	
	@Test
	public void beforeEachIdividualTest() throws ClientProtocolException, IOException, ParseException {
		thisMethodName = "beforeEachIdividualTest";
		client = HttpClients.createDefault();

		httpPost = new HttpPost("http://10.10.8.32:8080/AppCenter/services/rest/login");
		String json = "{\"username\":\"xxxxx\",\"password\":\"xxxxx\"}";
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);
		httpPost.setHeader("Content-type", "application/json");
		response = client.execute(httpPost);
 
 		httpEntity = response.getEntity();
		InputStream is = httpEntity.getContent();
		
		String logFilePath = filePath + "/LogFile.txt";
		FileOutputStream fos = new FileOutputStream(new File(logFilePath));
		int inByte;
		while ((inByte = is.read()) != -1)
			fos.write(inByte);
		
		
		
		parser = new JSONParser();

		obj = parser.parse(new FileReader(logFilePath));

		jsonObject = (JSONObject) obj;
		 
		 
		System.out.println("jsonObject: \t\t\t" + jsonObject );
		actualStatus = (String) jsonObject.get("status");
		actualErrorCode = (String) jsonObject.get("errorCode");
		errorMessage = (String) jsonObject.get("errorMessage");
		// String data = (String) jsonObject.get("data");
		success = "success";
		failure = "failure";
		 
		System.out.println("Status:		" + actualStatus);
		System.out.println("Error Code:	" + actualErrorCode);

		assertEquals(success, actualStatus);
		 
	}


}
