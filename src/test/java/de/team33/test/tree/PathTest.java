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
    public final void resolve() {
        final Path subject = Path.empty().resolve("abc").resolve("def").resolve("ghi");
        assertEquals("abc/def/ghi", subject.toString());
        assertEquals(3, subject.length());
        assertFalse(subject.isEmpty());
    }

    @Test
    public final void getParent() {
        fail("not yet implemented");
    }
}