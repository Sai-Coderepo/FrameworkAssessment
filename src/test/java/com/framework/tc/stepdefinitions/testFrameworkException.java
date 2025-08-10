package com.framework.tc.stepdefinitions;

import customframework.exceptionhandling.FrameworkException;

public class testFrameworkException {
    public static void main(String[] args) throws FrameworkException {
        throw new FrameworkException("First custom exception");
    }
}
