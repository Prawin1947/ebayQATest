package steps.api.functional;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.Map;
import java.util.Set;


public class BitCoinSteps {

    RequestSpecification requestSpecification;
    Response response;
    JsonObject jsonObject;

    @Given("the initiates the request")
    public void initiateTheRequest() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("http://api.coingecko.com")
                .basePath("api/v3/coins")
                .header("content-type", ContentType.JSON);

        requestSpecification.log().all();
    }

    @When("the user makes the get call")
    public void makeGetCall() {
        response = requestSpecification.get("bitcoin");
        response.then().log().all();
    }


    @Then("the get call is success")
    public void verifyStatus() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @And("the verify the marketCap and total volume")
    public void verifyMarketCapAndTotalVolume() {
        jsonObject = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();
        JsonObject marketCapJsonObject = jsonObject.getAsJsonObject("market_data").getAsJsonObject("market_cap");
        Map<String, JsonElement> marketCapMap = marketCapJsonObject.asMap();

        JsonObject totalVolume = jsonObject.getAsJsonObject("market_data").getAsJsonObject("total_volume");
        Map<String, JsonElement> volumeMap = totalVolume.asMap();

        Set<String> currency = marketCapMap.keySet();

        for (String key : currency) {
            String marketCap = marketCapMap.get(key).getAsString();
            String volume = volumeMap.get(key).getAsString();
            String detail = String.format("For " + key + " currency " + "Market Cap is " + marketCap + " and Volume is " + volume);
            System.out.println(detail);
        }
    }

    @And("the user verifies the price change percentage in 24hr")
    public void priceChange() {
        String priceChange = jsonObject.getAsJsonObject("market_data").get("price_change_percentage_24h").getAsString();
        System.out.println(priceChange);
    }


    @And("the user verifies Home page link is not empty")
    public void homePageLink() {
        String link;
        boolean linkIsAvailable = jsonObject.getAsJsonObject("links").get("homepage").isJsonNull();
        if (!linkIsAvailable) {
            link = jsonObject.getAsJsonObject("links").get("homepage").getAsString();
            System.out.println("Link is " + link);
        }
    }


   // Dummy Test
    public void verifyBitCoinDetails() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("http://api.coingecko.com")
                .basePath("api/v3/coins")
                .header("content-type", ContentType.JSON);

        requestSpecification.log().all();

        Response response = requestSpecification.get("bitcoin");
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonObject jsonObject = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();

        JsonObject marketCapJsonObject = jsonObject.getAsJsonObject("market_data").getAsJsonObject("market_cap");
        Map<String, JsonElement> marketCapMap = marketCapJsonObject.asMap();

        JsonObject totalVolume = jsonObject.getAsJsonObject("market_data").getAsJsonObject("total_volume");
        Map<String, JsonElement> volumeMap = totalVolume.asMap();


        Set<String> currency = marketCapMap.keySet();

        for (String key : currency) {
            String marketCap = marketCapMap.get(key).getAsString();
            String volume = volumeMap.get(key).getAsString();
            String detail = String.format("For " + key + " currency " + "Market Cap is " + marketCap + " and Volume is " + volume);
            System.out.println(detail);
        }

        String priceChange = jsonObject.getAsJsonObject("market_data").get("price_change_percentage_24h").getAsString();
        System.out.println(priceChange);

        String link;
        boolean linkIsAvailable = jsonObject.getAsJsonObject("links").get("homepage").isJsonNull();
        if (!linkIsAvailable) {
            link = jsonObject.getAsJsonObject("links").get("homepage").getAsString();
            System.out.println("Link is " + link);

        }

    }

}
