package org.chonnguyen.learning.parallelstreams;

/**
 *
 * @author mmueller
 */
public interface Condition<T> {
  boolean test(T t);
}