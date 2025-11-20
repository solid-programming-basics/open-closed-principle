package edu.agh.wfiis.solid.ocp.task2;

import javax.servlet.http.Cookie;

public class CookieFactory {

    public Cookie create(HeaderType headerType, String value) {
        switch (headerType) {
            case SESSION: {
                Cookie cookie = new Cookie(headerType.name(), value);
                cookie.setMaxAge(1000);
                cookie.setSecure(true);
                cookie.setDomain("security");
                return cookie;
            }
            case ISM: {
                Cookie cookie = new Cookie(headerType.name(), value);
                cookie.setDomain("ism");
                cookie.setSecure(true);
                return cookie;
            }
            default: {
                Cookie cookie = new Cookie("default", value);
                cookie.setPath("/applications/" + value);
                return cookie;


            }
        }
    }
}