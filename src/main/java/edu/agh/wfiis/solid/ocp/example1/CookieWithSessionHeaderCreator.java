package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;

public class CookieWithSessionHeaderCreator implements CookieCreatable {

    private static final HeaderType HEADER_TYPE = HeaderType.SESSION;

    public Cookie create(String value) {
        Cookie cookie = new Cookie(HEADER_TYPE.name(), value);
        cookie.setMaxAge(1000);
        cookie.setSecure(true);
        cookie.setDomain("security");
        return cookie;
    }
}
