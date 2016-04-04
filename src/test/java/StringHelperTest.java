import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StringHelperTest {

    @Test
    public void testAbbreviate() throws Exception {
        assertEquals("a10n-i18n b4n", StringHelper.abbreviate("abbreviation-internationalization batman"));
        assertNull("Must return null when the arg is null", StringHelper.abbreviate(null));
        assertNull("Must return null when the arg is null", StringHelper.abbreviate(""));
    }

    @Test
    public void testToJadenCase() throws Exception {
        assertEquals("toJadenCase doesn't return a valide JadenCase String! try again please :)",
                StringHelper.toJadenCase("most trees are blue"), "Most Trees Are Blue");
        assertNull("Must return null when the arg is null", StringHelper.toJadenCase(null));
        assertNull("Must return null when the arg is null", StringHelper.toJadenCase(""));

    }
}