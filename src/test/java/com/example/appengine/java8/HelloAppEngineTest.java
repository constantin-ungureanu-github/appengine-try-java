package com.example.appengine.java8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.appengine.HelloAppEngine;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public class HelloAppEngineTest {
    private static final String FAKE_URL = "fake.fk/hello";

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;


    private HelloAppEngine servlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        servlet = new HelloAppEngine();
    }

    @Test
    public void doGetWritesResponse() throws IOException {
        when(mockRequest.getRequestURI()).thenReturn(FAKE_URL);
        final Writer responseWriter = new StringWriter();
        when(mockResponse.getWriter()).thenReturn(new PrintWriter(responseWriter));

        servlet.doGet(mockRequest, mockResponse);
        final String string = responseWriter.toString();

        assertThat(string).contains("Hello AppEngine");
    }

    @Test
    public void helloInfoTest() {
        final String result = HelloAppEngine.getInfo();
        assertThat(result).containsSubsequence("Version: ", "OS: ", "User: ");
    }
}
