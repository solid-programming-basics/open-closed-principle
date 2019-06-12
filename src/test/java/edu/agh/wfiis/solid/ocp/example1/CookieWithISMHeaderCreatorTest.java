package edu.agh.wfiis.solid.ocp.example1;

import org.junit.Assert;

import javax.servlet.http.Cookie;

public class CookieWithISMHeaderCreatorTest {

    private static final String COOKIE_VALUE = "some-value";
    private CookieCreatable underTest;
    private Cookie cookieToTest;

    @org.junit.Before
    public void setUp() {
        underTest = new CookieWithISMHeaderCreator();
        cookieToTest = underTest.create(COOKIE_VALUE);
    }

    @org.junit.Test
    public void testCookieValue() {
        Assert.assertEquals(COOKIE_VALUE, cookieToTest.getValue());
    }

    @org.junit.Test
    public void testCookieName() {
        Assert.assertEquals(HeaderType.ISM.name(), cookieToTest.getName());
    }

    @org.junit.Test
    public void testIfCookieSecure() {
        Assert.assertTrue(cookieToTest.getSecure());
    }

    @org.junit.Test
    public void testCookieDomain() {
        Assert.assertEquals("ism", cookieToTest.getDomain());
    }
}
