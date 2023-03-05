package com.jackson.test.jacksonTest.jackson;

class AccessLevelPackageObjectSetter {
    private String privateString;
    String packageString;
    protected String protectedString;
    public String publicString;

    private void setPrivateString(String privateString) {
        this.privateString = privateString;
    }

    private void setPackageString(String packageString) {
        this.packageString = packageString;
    }

    private void setProtectedString(String protectedString) {
        this.protectedString = protectedString;
    }

    private void setPublicString(String publicString) {
        this.publicString = publicString;
    }

    String getPrivateString() {
       return this.privateString;
    }
}
