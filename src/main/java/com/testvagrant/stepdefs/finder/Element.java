package com.testvagrant.stepdefs.finder;

public class Element {

    private String name;

    private String waitFor;

    private String value;

    private String identifier;

    private String referTo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWaitFor() {
        return waitFor;
    }

    public void setWaitFor(String waitFor) {
        this.waitFor = waitFor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getReferTo() {
        return referTo;
    }

    public void setReferTo(String referTo) {
        this.referTo = referTo;
    }
}
