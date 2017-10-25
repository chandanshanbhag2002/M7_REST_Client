/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivitiesToRole;

/**
 *
 * @author chandan.shanbhag
 */
public class RestVariables {

    public static String jsession, csrf;

    public String getJsession() {
        return jsession;
    }

    public void setJsession(String jsession) {
        this.jsession = jsession;
    }

    public String getCsrf() {
        return csrf;
    }

    public void setCsrf(String csrf) {
        this.csrf = csrf;
    }

    public static void clear() {
        jsession = null;
        csrf = null;

    }

}
