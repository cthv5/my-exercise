package org.cth.designPattern.visitor;

public interface Subject {
    void accept(Visitor visitor);
    String getSubject();
}
