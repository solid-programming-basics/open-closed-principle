package edu.agh.wfiis.solid.ocp.example1;

import java.util.HashMap;
import java.util.Map;

class CookieCreatorChooser {

    private static final Map<HeaderType, CookieCreatable> HEADER_TYPES = new HashMap<>();

    static {
        HEADER_TYPES.put(HeaderType.SESSION, new CookieWithSessionHeaderCreator());
        HEADER_TYPES.put(HeaderType.ISM, new CookieWithISMHeaderCreator());
    }

    static CookieCreatable getCreator(HeaderType headerType) {

        CookieCreatable cookieCreatorType = HEADER_TYPES.get(headerType);
        if (cookieCreatorType != null) {
            return cookieCreatorType;
        }
        else {
            return new CookieWithDefaultHeaderCreator();
        }

    }
}
