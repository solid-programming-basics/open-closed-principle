package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;

public class CookieFactory {

    public static Cookie create(HeaderType headerType, String value) {
        CookieCreatable cookieCreator = CookieCreatorChooser.getCreator(headerType);
        return cookieCreator.create(value);
    }
}