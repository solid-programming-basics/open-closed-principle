package edu.agh.wfiis.solid.ocp.example1;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class CookieCreatorChooserTest {

    @org.junit.Test
    public void testIfISMCreatorChosen() {
        CookieCreatable creatorToTest = CookieCreatorChooser.getCreator(HeaderType.ISM);
        assertThat(creatorToTest, instanceOf(CookieWithISMHeaderCreator.class));
    }

    @org.junit.Test
    public void testIfSessionCreatorChosen() {
        CookieCreatable creatorToTest = CookieCreatorChooser.getCreator(HeaderType.SESSION);
        assertThat(creatorToTest, instanceOf(CookieWithSessionHeaderCreator.class));
    }

}
