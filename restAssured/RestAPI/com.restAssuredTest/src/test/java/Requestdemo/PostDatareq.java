package Requestdemo;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class PostDatareq {
	@Test
	public void Create()
	{
		Postreq req=new Postreq();
		req.setName("morpheus");
		req.setJob("leader");
		
		Response resp=given().contentType(ContentType.JSON).when().body(req)
		.post("https://reqres.in/api/users");
	}
}
