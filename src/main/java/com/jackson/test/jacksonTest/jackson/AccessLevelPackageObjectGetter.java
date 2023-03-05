package com.jackson.test.jacksonTest.jackson;

class AccessLevelPackageObjectGetter {
    private String privateString;
    String packageString;
    protected String protectedString;
    public String publicString;

    public String getPrivateString() {
        return privateString;
    }

    public String getPackageString() {
        return packageString;
    }

    public String getProtectedString() {
        return protectedString;
    }

    String getPublicString() {
        return publicString;
    }
}
