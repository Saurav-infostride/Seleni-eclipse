package Requestdemo;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
public class CreateCustomer {
//	@Test
//public void Postrequest()
//{
//	given().auth().basic("sk_test_QbRiu7Hnvf9JMlTO1TmLtcoT", "").
//	formParam("email", "jain.sampada@gmail.com")
//	.formParam("name", "Sampada").when().post("https://api.stripe.com/v1/customers");
//}
//	@Test
//	public void checkdata()
//	{
//		String email=given().auth().basic("sk_test_QbRiu7Hnvf9JMlTO1TmLtcoT", "").when()
//		.get("https://api.stripe.com/v1/customers").then()
//		.extract().path("data.email[3]");
//		System.out.println(email);
//	}
	@Test
	public void validatedata()
	{
		given().auth().basic("sk_test_QbRiu7Hnvf9JMlTO1TmLtcoT", "")
		.when().get("https://api.stripe.com/v1/customers").then().
		body("data.email", hasItem("jain.sampada@gmail.com"));
		
	}
}
