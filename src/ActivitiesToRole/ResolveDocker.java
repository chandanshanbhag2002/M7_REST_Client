/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivitiesToRole;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 *
 * @author chandan.shanbhag
 */
public class ResolveDocker {

    public String get(String instance) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setContentType("application/json; charset=UTF-8");
        builder.addHeader("accept", "application/json");
        RequestSpecification requestSpec = builder.build();
        Response r = given().spec(requestSpec).when().get("http://172.27.140.5:3000/instance/" + instance);
        System.out.println(r.asString());
        return r.asString();
    }
}
