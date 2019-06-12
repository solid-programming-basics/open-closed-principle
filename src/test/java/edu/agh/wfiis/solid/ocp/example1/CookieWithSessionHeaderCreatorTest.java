package edu.agh.wfiis.solid.ocp.example1;

import org.junit.Assert;

import javax.servlet.http.Cookie;

public class CookieWithSessionHeaderCreatorTest  {

    private static final String COOKIE_VALUE = "some-value";
    private CookieCreatable underTest;
    private Cookie cookieToTest;

    @org.junit.Before
    public void setUp() {
        underTest = new CookieWithSessionHeaderCreator();
        cookieToTest = underTest.create(COOKIE_VALUE);
    }

    @org.junit.Test
    public void testCookieValue() {
        Assert.assertEquals(COOKIE_VALUE, cookieToTest.getValue());
    }

    @org.junit.Test
    public void testCookieName() {
        Assert.assertEquals(HeaderType.SESSION.name(), cookieToTest.getName());
    }

    @org.junit.Test
    public void testCookieMaxAge() {
        Assert.assertEquals(1000, cookieToTest.getMaxAge());
    }

    @org.junit.Test
    public void testIfCookieSecure() {
        Assert.assertTrue(cookieToTest.getSecure());
    }

    @org.junit.Test
    public void testCookieDomain() {
        Assert.assertEquals("security", cookieToTest.getDomain());
    }

}
