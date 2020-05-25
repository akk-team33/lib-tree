package de.team33.libs.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Path {

    private static final String DELIMITER = "/";
    private static final String QUOTED_DELIMITER = Pattern.quote(DELIMITER);

    private final List<Entry> entries;

    private Path(final Stream<Entry> fragments) {
        entries = fragments.collect(Collectors.toCollection(LinkedList::new));
    }

    public static Path empty() {
        return new Path(Stream.empty());
    }

    public final Path resolve(final String fragment) {
        return resolve(new Path(Stream.of(fragment.split(QUOTED_DELIMITER)).map(Entry::new)));
    }

    public final Path resolve(final Path tail) {
        return new Path(Stream.concat(entries.stream(), tail.entries.stream()));
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

    private final class Entry {

        private final String ident;

        private Entry(final String ident) {
            this.ident = ident;
        }

        @Override
        public int hashCode() {
            return ident.hashCode();
        }

        @Override
        public boolean equals(final Object obj) {
            return (this == obj) || ((obj instanceof Entry) && ident.equals(((Entry) obj).ident));
        }

        @Override
        public String toString() {
            return ident;
        }
    }
}
