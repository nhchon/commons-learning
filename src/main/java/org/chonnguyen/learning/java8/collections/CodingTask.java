package org.chonnguyen.learning.java8.collections;

public final class CodingTask extends Task {
  private final String spec;
  public CodingTask(String spec) {
    this.spec = spec;
  }
  public String getSpec() { return spec; }
  public String toString() { return "code " + spec; }
}
