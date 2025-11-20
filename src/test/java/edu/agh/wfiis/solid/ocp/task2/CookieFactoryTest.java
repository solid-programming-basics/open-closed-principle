package edu.agh.wfiis.solid.ocp.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.servlet.http.Cookie;

public class CookieFactoryTest {

    private static final String COOKIE_VALUE = "some-value";

    private CookieFactory underTest = new CookieFactory() ;

    @Test
    public void testForSessionHeader() {
        Cookie result = underTest.create(HeaderType.SESSION, COOKIE_VALUE);
        Assertions.assertEquals(COOKIE_VALUE, result.getValue());
        Assertions.assertEquals(HeaderType.SESSION.name(), result.getName());
        Assertions.assertEquals(1000, result.getMaxAge());
        Assertions.assertTrue(result.getSecure());
        Assertions.assertEquals("security", result.getDomain());
    }

    @Test
    public void testForISMHeader() {
        Cookie result = underTest.create(HeaderType.ISM, COOKIE_VALUE);
        Assertions.assertEquals(COOKIE_VALUE, result.getValue());
        Assertions.assertEquals(HeaderType.ISM.name(), result.getName());
        Assertions.assertTrue(result.getSecure());
        Assertions.assertEquals("ism", result.getDomain());
    }

    @Test
    public void testForDefaultHeader() {
        Cookie result = underTest.create(HeaderType.REQUEST, COOKIE_VALUE);
        Assertions.assertEquals(COOKIE_VALUE, result.getValue());
        Assertions.assertEquals("default", result.getName());
        Assertions.assertEquals("/applications/" + COOKIE_VALUE, result.getPath());
    }


}