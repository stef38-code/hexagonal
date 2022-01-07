package org.stephane.in.controller;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.stephane.tools.FileTools;
import org.stephane.tools.JsonMapper;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class ControllerIntegrationTest extends JsonMapper {
    protected String getJsonStringWithFile(String fileName) {
        Optional<String> value = FileTools.getResourceFileAsString(fileName);
        assertThat(value).isPresent();
        String content = value.get();
        return content;
    }
    protected String getContent(ResultActions resultActions) throws UnsupportedEncodingException {
        return resultActions.andReturn().getResponse().getContentAsString();
    }

    protected ResultActions getResult(MockHttpServletRequestBuilder requestBuilder, Object controller) throws Exception {
        return MockMvcBuilders.standaloneSetup(controller)
                .build()
                .perform(requestBuilder);
    }
}
