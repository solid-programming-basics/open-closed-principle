package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;

public class CookieWithDefaultHeaderCreator implements CookieCreatable {

    public Cookie create(String value) {
        Cookie cookie = new Cookie("default", value);
        cookie.setPath("/applications/" + value);
        return cookie;
    }
}
