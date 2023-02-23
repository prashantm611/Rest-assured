package rest_assured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class Class_01 {
	public String url = "https://reqres.in/api/users?page=2";
	@Test(enabled = false)
	public void testcase1(){
		Response rep = get(url);
		int status_code = rep.statusCode();
		Assert.assertEquals(status_code, 201);
		System.out.println(rep.asString());
		System.out.println(rep.getBody());
	}
	@Test(enabled = false)
	public void testcase2() {
		given().get(url).then().statusCode(200).body("data.id", equalTo(45)).log().all();
	}
	@Test(enabled = false)
	public void testcase3() {
		JSONObject js = new JSONObject();
		js.put("name", "Aditya");
		js.put("job", "CEO");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
		
	}
	@Test(enabled = false)
	public void testcase4() {
		JSONObject js = new JSONObject();
		js.put("name", "Aditya");
		js.put("job", "Chairman");
		given().body(js.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
	}
	@Test(enabled = false)
	public void testcase5() {
		given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
		
	}
	@Test(enabled = false)
	public void testcase6() {
		baseURI = "http://localhost:3000";
		JSONObject js = new JSONObject();
		js.put("name", "Moolya");
		given().body(js.toJSONString()).when().put("/users/11").then().statusCode(200).log().all();
	}
	@Test
	public void testcase7() {
		baseURI = "http://localhost:3000";
		JSONObject js = new JSONObject();
		js.put("id", 5);
		js.put("name", "Manual Tester");
		given().body(js.toJSONString()).when().post("/Job_Type").then().log().all();
	}

}
