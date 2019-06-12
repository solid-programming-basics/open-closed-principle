package edu.agh.wfiis.solid.ocp.example1;

import org.junit.Assert;

import javax.servlet.http.Cookie;

public class CookieWithDefaultHeaderCreatorTest {

    private static final String COOKIE_VALUE = "some-value";
    private CookieCreatable underTest;
    private Cookie cookieToTest;

    @org.junit.Before
    public void setUp() {
        underTest = new CookieWithDefaultHeaderCreator();
        cookieToTest = underTest.create(COOKIE_VALUE);
    }

    @org.junit.Test
    public void testCookieValue() {
        Assert.assertEquals(COOKIE_VALUE, cookieToTest.getValue());
    }

    @org.junit.Test
    public void testCookieName() {
        Assert.assertEquals("default", cookieToTest.getName());
    }

    @org.junit.Test
    public void testCookiePath() {
        Assert.assertEquals("/applications/" + COOKIE_VALUE, cookieToTest.getPath());
    }
}
