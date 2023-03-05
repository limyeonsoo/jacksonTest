package com.jackson.test.jacksonTest.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@ExtendWith(MockitoExtension.class)
public class JacksonSerializationTest {

    @Test
    void public_object_field_by_access_modifier_serialization()
            throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        AccessLevelPublicObject object  = new AccessLevelPublicObject();

        String response = mapper.writeValueAsString(object);
        System.out.println(response);
        // {"publicString":null}

        assertThat(response, not(containsString("privateString")));
        assertThat(response, not(containsString("packageString")));
        assertThat(response, not(containsString("protectedString")));
        assertThat(response, containsString("publicString"));
    }

    @Test
    void package_private_object_field_by_access_modifier_serialization()
            throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        AccessLevelPackageObject object  = new AccessLevelPackageObject();

        String response = mapper.writeValueAsString(object);
        System.out.println(response);
        // {"publicString":null}

        assertThat(response, not(containsString("privateString")));
        assertThat(response, not(containsString("packageString")));
        assertThat(response, not(containsString("protectedString")));
        assertThat(response, containsString("publicString"));
    }

    @Test
    void with_getter_package_private_object_field_by_access_modifier_serialization()
            throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        AccessLevelPackageObjectGetter object  = new AccessLevelPackageObjectGetter();

        String response = mapper.writeValueAsString(object);
        System.out.println(response);
        // {"publicString":null}

        assertThat(response, containsString("privateString"));
        assertThat(response, containsString("packageString"));
        assertThat(response, containsString("protectedString"));
        assertThat(response, containsString("publicString"));

        // getter가 public이여야 된다.
    }

    @Test
    void with_setter_package_private_object_field_by_access_modifier_serialization()
            throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        AccessLevelPackageObjectSetter object  = new AccessLevelPackageObjectSetter();

        String response = mapper.writeValueAsString(object);
        System.out.println(response);
        // {"publicString":null}

        assertThat(response, not(containsString("privateString")));
        assertThat(response, not(containsString("packageString")));
        assertThat(response, not(containsString("protectedString")));
        assertThat(response, containsString("publicString"));
    }
}
