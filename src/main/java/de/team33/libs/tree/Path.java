package de.team33.libs.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Path {

    private static final String DELIMITER = "/";

    private final List<Entry> entries = new LinkedList<>();

    public static Path empty() {
        return new Path();
    }

    public final Path resolve(final String fragment) {
        //return new Path();
        throw new UnsupportedOperationException("not yet implemented");
    }

    public final Path getParent() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public final int length() {
        return entries.size();
    }

    public final boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public final int hashCode() {
        return entries.hashCode();
    }

    @Override
    public final boolean equals(final Object obj) {
        return (this == obj) || ((obj instanceof Path) && entries.equals(((Path) obj).entries));
    }

    @Override
    public final String toString() {
        return entries.stream()
                      .map(Entry::toString)
                      .collect(Collectors.joining(DELIMITER));
    }

    private final class Entry {}
}
