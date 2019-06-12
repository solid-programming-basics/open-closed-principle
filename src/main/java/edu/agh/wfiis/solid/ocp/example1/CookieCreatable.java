package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;

public interface CookieCreatable {

    Cookie create(String value);
}
