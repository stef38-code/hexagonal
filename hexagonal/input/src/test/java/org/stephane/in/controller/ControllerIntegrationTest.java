package org.stephane.in.controller;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.UnsupportedEncodingException;

public class ControllerIntegrationTest {
    protected String getContent(ResultActions resultActions) throws UnsupportedEncodingException {
        return resultActions.andReturn().getResponse().getContentAsString();
    }

    protected ResultActions getResult(MockHttpServletRequestBuilder requestBuilder, Object controller) throws Exception {
        return MockMvcBuilders.standaloneSetup(controller)
                .build()
                .perform(requestBuilder);
    }
}
