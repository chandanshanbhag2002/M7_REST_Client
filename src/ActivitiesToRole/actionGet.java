/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivitiesToRole;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 *
 * @author chandan.shanbhag
 */
public class actionGet {

    public Response getResponse(String endpoint, String content_type) {

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder = RestProperties.setHeader(content_type);
        RequestSpecification requestSpec = builder.build();
        Response r = given().spec(requestSpec).when().get(endpoint);
        return r;
    }

}
