package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;
import java.util.Map;

interface CookieCreator {
    public Cookie create(String value);
}

public class CookieFactory {
    Map<HeaderType, CookieCreator> headerTypesToCookieCreators = Map.of(
            HeaderType.SESSION, new SessionCookieCreator(),
            HeaderType.ISM, new ISMCookieCreator(),
            HeaderType.REQUEST, new DefaultCookieCreator()
    );

    public Cookie create(HeaderType headerType, String value) {
        return headerTypesToCookieCreators.getOrDefault(headerType, new DefaultCookieCreator()).create(value);
    }
}

class SessionCookieCreator implements CookieCreator {

    @Override
    public Cookie create(String value) {
        Cookie cookie = new Cookie(HeaderType.SESSION.name(), value);
        cookie.setMaxAge(1000);
        cookie.setSecure(true);
        cookie.setDomain("security");
        return cookie;
    }
}

class ISMCookieCreator implements CookieCreator {

    @Override
    public Cookie create(String value) {
        Cookie cookie = new Cookie(HeaderType.ISM.name(), value);
        cookie.setDomain("ism");
        cookie.setSecure(true);
        return cookie;
    }
}

class DefaultCookieCreator implements CookieCreator {

    @Override
    public Cookie create(String value) {
        Cookie cookie = new Cookie("default", value);
        cookie.setPath("/applications/" + value);
        return cookie;
    }
}