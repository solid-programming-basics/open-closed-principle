package edu.agh.wfiis.solid.ocp.example1;


import org.junit.Assert;

import javax.servlet.http.Cookie;

public class CookieFactoryTest {

    private static final String COOKIE_VALUE = "some-value";


    private static CookieFactory cookieFactory;

    @org.junit.BeforeClass
    public static void setUp() {
        cookieFactory = new CookieFactory();
    }

    @org.junit.Test
    public void testForSessionHeader() {
        Cookie result = cookieFactory.create(HeaderType.SESSION, COOKIE_VALUE);
        Assert.assertEquals(COOKIE_VALUE, result.getValue());
        Assert.assertEquals(HeaderType.SESSION.name(), result.getName());
        Assert.assertEquals(1000, result.getMaxAge());
        Assert.assertTrue(result.getSecure());
        Assert.assertEquals("security", result.getDomain());
    }

    @org.junit.Test
    public void testForISMHeader() {
        Cookie result = cookieFactory.create(HeaderType.ISM, COOKIE_VALUE);
        Assert.assertEquals(COOKIE_VALUE, result.getValue());
        Assert.assertEquals(HeaderType.ISM.name(), result.getName());
        Assert.assertTrue(result.getSecure());
        Assert.assertEquals("ism", result.getDomain());
    }

    @org.junit.Test
    public void testForDefaultHeader() {
        Cookie result = cookieFactory.create(HeaderType.REQUEST, COOKIE_VALUE);
        Assert.assertEquals(COOKIE_VALUE, result.getValue());
        Assert.assertEquals("default", result.getName());
        Assert.assertEquals("/applications/" + COOKIE_VALUE, result.getPath());
    }


}