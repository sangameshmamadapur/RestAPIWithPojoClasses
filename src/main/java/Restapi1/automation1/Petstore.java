package Restapi1.automation1;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

/**
 * Hello world!
 *
 */
public class Petstore {
	public static void main(String[] args) {

		order or = new order();
		or.setId(1);
		or.setPetId(2);
		or.setQuantity(2);
		or.setShipDate("2021-06-16T14:49:04.897Z");
		or.setStatus("Placed");
		or.setComplete(true);

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		String resp = given().log().all().contentType("application/json").body(or).when().post("store/order").then()
				.log().all().assertThat().statusCode(200).extract().response().asString();

		System.out.println("response" + resp);

	}
}
