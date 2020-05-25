package de.team33.test.tree;

import de.team33.libs.tree.Path;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public final void empty() {
        final Path empty = Path.empty();
        assertEquals("", empty.toString());
        assertEquals(0, empty.length());
        assertTrue(empty.isEmpty());
    }

    @Test
    public final void resolveString() {
        final Path expected = Path.empty().resolve("abc/def/ghi");
        final Path subject = Path.empty().resolve("abc").resolve("def").resolve("ghi");
        assertEquals(expected, subject);
        assertEquals(3, subject.length());
        assertFalse(subject.isEmpty());
    }

    @Test
    public final void resolveExtensiveString() {
        final Path expected = Path.empty().resolve("abc").resolve("def").resolve("ghi");
        final Path subject = Path.empty().resolve("/abc/def//ghi//");
        assertEquals(expected, subject);
        assertEquals(3, subject.length());
        assertFalse(subject.isEmpty());
    }

    @Test
    public final void getParent() {
        fail("not yet implemented");
    }
}