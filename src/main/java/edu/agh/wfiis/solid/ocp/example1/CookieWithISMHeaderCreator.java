package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;

public class CookieWithISMHeaderCreator implements CookieCreatable {

    private static final HeaderType HEADER_TYPE = HeaderType.ISM;

    public Cookie create(String value) {
        Cookie cookie = new Cookie(HEADER_TYPE.name(), value);
        cookie.setDomain("ism");
        cookie.setSecure(true);
        return cookie;
    }
}
