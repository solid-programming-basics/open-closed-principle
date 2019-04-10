package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;

public class CookieFactory {

    private CookieSupplier cookieSupplier = new CookieSupplier();

    public Cookie create(HeaderType headerType, String value) {
        return cookieSupplier.supplyCookie(headerType, value);
    }
}