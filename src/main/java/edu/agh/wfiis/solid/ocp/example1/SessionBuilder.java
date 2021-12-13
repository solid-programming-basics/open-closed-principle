package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;

public class SessionBuilder implements CookieTypeBuilder{

    private final HeaderType headerType = HeaderType.SESSION;

    @Override
    public Cookie build(String value) {
        Cookie cookie = new Cookie(headerType.name(), value);
        cookie.setMaxAge(1000);
        cookie.setSecure(true);
        cookie.setDomain("security");
        return cookie;
    }
}
