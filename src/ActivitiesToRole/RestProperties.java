/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivitiesToRole;

import com.jayway.restassured.builder.RequestSpecBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chandan.shanbhag
 */
public class RestProperties {

    public static RequestSpecBuilder setHeader(String contentType) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        Map<String, String> cooky = new HashMap<String, String>();

        String csrfToken = RestVariables.csrf;

        System.out.println(csrfToken);
        //System.out.println("jsession received : " + XMLSuite.jSessionId);

        builder.addHeader("X-Csrf-Token", csrfToken);
        cooky.put("JSESSION_ID", RestVariables.jsession);
        builder.addCookies(cooky);

        if (contentType.equalsIgnoreCase("json")) {
            builder.setContentType("application/json; charset=UTF-8");
            builder.addHeader("accept", "application/json");

        } else if (contentType.equalsIgnoreCase("multipart")) {
            builder.setContentType("multipart/form-data");
            builder.addHeader("accept", "application/json");

        } else if (contentType.equalsIgnoreCase("xml")) {
            builder.setContentType("application/xml; charset=UTF-8");
            builder.addHeader("accept", "application/xml");

        }
        return builder;
    }

}
