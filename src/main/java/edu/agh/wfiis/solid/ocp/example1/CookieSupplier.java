package edu.agh.wfiis.solid.ocp.example1;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class CookieSupplier {
    private static final Map<HeaderType, CookieTypeBuilder> COOKIE_SUPPLIER;
    private static final CookieTypeBuilder DEFAULT_BUILDER;

    static {
        COOKIE_SUPPLIER = new HashMap<>();
        COOKIE_SUPPLIER.put(HeaderType.SESSION, new SessionBuilder());
        COOKIE_SUPPLIER.put(HeaderType.ISM, new IsmBuilder());

        DEFAULT_BUILDER = new DefaultBuilder();
    }

    public Cookie supplyCookie(HeaderType headerType, String value) {
        CookieTypeBuilder cookieTypeBuilder = COOKIE_SUPPLIER.get(headerType);
        if(cookieTypeBuilder == null) {
            return DEFAULT_BUILDER.build(value);
        }
        return cookieTypeBuilder.build(value);
    }
}
