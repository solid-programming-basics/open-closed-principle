package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;

public class IsmBuilder implements CookieTypeBuilder{

    private final HeaderType headerType = HeaderType.ISM;

    @Override
    public Cookie build(String value) {
        Cookie cookie = new Cookie(headerType.name(), value);
        cookie.setDomain("ism");
        cookie.setSecure(true);
        return cookie;
    }
}