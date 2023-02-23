package rest_assured;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Class_02 {
	public String url = "https://trello.com";	
	public String id ;
	@Test
	public void Get_Boards() {
		baseURI =url;
		Response response = given().queryParam("key","52078aae0d661d7db3381da0d1b5ec89")
				.queryParam("token", "ATTA5e273ee3306e20d3d81ecbb614b679d78ad8a05490823c4977693634d224e129D9D0820C")
				.header("Content-Type","application/json").when().get("/b/Dw1Vi6v5/aditya-vadlamani").then().extract().response();
		System.out.println(response.getBody());		
	}	
	@Test
	public void Create_Board() {
		baseURI =url;		
		Response response = given().queryParam("name", "Shoto").queryParam("key","52078aae0d661d7db3381da0d1b5ec89")
				.queryParam("token", "ATTA5e273ee3306e20d3d81ecbb614b679d78ad8a05490823c4977693634d224e129D9D0820C")
		.header("Content-Type","application/json").when().post("/1/boards/").then().extract().response();		
		JsonPath jp = new JsonPath(response.asString());
		 id = jp.get("id");
		System.out.println(id);
		System.out.println(response);		
	}	
	@Test	
	public void Delete_Board() {		
		baseURI =url;		
		Response response = given().queryParam("key","52078aae0d661d7db3381da0d1b5ec89")
				.queryParam("token", "ATTA5e273ee3306e20d3d81ecbb614b679d78ad8a05490823c4977693634d224e129D9D0820C")
				.header("Content-Type","application/json").when().delete("/1/boards/"+id).then().extract().response();
		System.out.println(response);		
	}
	
	@Test
	
	public void Update_a_Board() {		
		Response response = given().queryParam("name", "Todoroki").queryParam("key","52078aae0d661d7db3381da0d1b5ec89")
				.queryParam("token", "ATTA5e273ee3306e20d3d81ecbb614b679d78ad8a05490823c4977693634d224e129D9D0820C")
				.header("Content-Type","application/json").when().put("/1/boards/"+id).then().extract().response();
		System.out.println(response);		
	}
}