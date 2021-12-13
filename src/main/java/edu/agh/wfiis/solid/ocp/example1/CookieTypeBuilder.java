package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;

public interface CookieTypeBuilder {
    Cookie build(String value);
}