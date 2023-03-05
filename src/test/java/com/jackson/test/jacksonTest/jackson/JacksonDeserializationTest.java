package com.jackson.test.jacksonTest.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
public class JacksonDeserializationTest {

    @Test
    void public_object_field_by_access_modifier_deserialization()
            throws JsonProcessingException {
        String jsonRequest = "{" +
                // "\"privateString\":\"privateString\"," +
                // "\"packageString\":\"packageString\"," +
                // "\"protectedString\":\"protectedString\"," +
                "\"publicString\":\"publicString\"" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        AccessLevelPublicObject request = mapper.readValue(jsonRequest, AccessLevelPublicObject.class);

//        assertThat(response, not(containsString("privateString")));
//        assertThat(response, not(containsString("packageString")));
//        assertThat(response, not(containsString("protectedString")));
        assertThat(request.publicString, equalTo("publicString"));
    }

    @Test
    void with_getter_package_private_object_field_by_access_modifier_deserialization()
            throws JsonProcessingException {
        String jsonRequest = "{" +
                "\"privateString\":\"privateString\"," +
                "\"packageString\":\"packageString\"," +
                "\"protectedString\":\"protectedString\"," +
                "\"publicString\":\"publicString\"" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        AccessLevelPackageObjectGetter request = mapper.readValue(jsonRequest, AccessLevelPackageObjectGetter.class);

        assertThat(request.getPrivateString(), equalTo("privateString"));
        assertThat(request.packageString, equalTo("packageString"));
        assertThat(request.protectedString, equalTo("protectedString"));
        assertThat(request.publicString, equalTo("publicString"));

        // private, package-default, protected 's getter must be public.
    }

    @Test
    void with_private_setter_package_private_object_field_by_access_modifier_deserialization()
            throws JsonProcessingException {
        String jsonRequest = "{" +
                "\"privateString\":\"privateString\"," +
                "\"packageString\":\"packageString\"," +
                "\"protectedString\":\"protectedString\"," +
                "\"publicString\":\"publicString\"" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        AccessLevelPackageObjectSetter request = mapper.readValue(jsonRequest, AccessLevelPackageObjectSetter.class);

        assertThat(request.getPrivateString(), equalTo("privateString"));
        assertThat(request.packageString, equalTo("packageString"));
        assertThat(request.protectedString, equalTo("protectedString"));
        assertThat(request.publicString, equalTo("publicString"));

        // private setter로도 된다.
    }
}
