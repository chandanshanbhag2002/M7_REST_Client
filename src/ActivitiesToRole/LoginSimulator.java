package ActivitiesToRole;

import static com.jayway.restassured.RestAssured.given;

import java.net.HttpURLConnection;
import org.testng.Assert;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;

public class LoginSimulator {

    public static String[] getSessionId(String URL, String userName, String password) throws Exception {
        RestAssured.useRelaxedHTTPSValidation();
        String jSessionCsrfId[] = new String[2];
        String login = URL + "metricstream/auth/signin.jsp";
        System.out.println("Login:" + login);
        String basic = URL + "metricstream/auth/basic";
        System.out.println("basic:" + basic);
        Response response = given().get(login);
        Assert.assertEquals(response.getStatusCode(), HttpURLConnection.HTTP_OK, "Login page loading is failed");

        //login:
        Cookies cookie = new Cookies();
        Header header = new Header("Content-Type", "application/x-www-form-urlencoded");

        response = given().formParam("username", userName).formParam("password", password).header(header).request().post(basic);
        Assert.assertEquals(response.getStatusCode(), HttpURLConnection.HTTP_MOVED_TEMP, "Authentication Failed");
        System.out.println(response.asString() + ":" + response.getStatusLine() + ":" + response.getCookies());

        jSessionCsrfId[0] = response.getCookie("JSESSION_ID");
        jSessionCsrfId[1] = response.getCookie("Csrf-Token");

        return jSessionCsrfId;

    }
}
