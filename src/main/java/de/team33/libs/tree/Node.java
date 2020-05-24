package de.team33.libs.tree;

import java.util.Optional;

public interface Node<V> {

    Node<V> get(Path path);

    Optional<V> asValue();

    public interface Mutable<V> extends Node<V> {

        Mutable<V> set(Path path, V value);
    }
}
