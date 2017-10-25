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
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

/**
 *
 * @author chandan.shanbhag
 */
public class actionDELETE {

    public Response getResponse(String endpoint, String body) {

        JSONParser parser = new JSONParser();
        JSONObject jsonObj = null;
        JSONArray jsonArray = null;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder = RestProperties.setHeader("json");
        try {
            if (parser.parse(body) instanceof JSONObject) {
                jsonObj = (JSONObject) parser.parse(body);
                builder.setBody(jsonObj.toString());
            } else if (parser.parse(body) instanceof JSONArray) {
                jsonArray = (JSONArray) parser.parse(body);
                System.out.println(jsonArray.toJSONString());
                builder.setBody(jsonArray.toJSONString());
            }
        } catch (ParseException ex) {
            Logger.getLogger(actionPOST.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestSpecification requestSpec = builder.build();
        Response r = given().spec(requestSpec).when().delete(endpoint);
        return r;

    }
}
