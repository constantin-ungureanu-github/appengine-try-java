package com.example.appengine;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.utils.SystemProperty;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "HelloAppEngine", value = "/hello")
public class HelloAppEngine extends HttpServlet {
    private static final long serialVersionUID = 7744344535645638041L;

    public static String getInfo() {
        return "Version: " + System.getProperty("java.version") + " OS: " + System.getProperty("os.name") + " User: " + System.getProperty("user.name");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final Properties properties = System.getProperties();

        response.setContentType("text/plain");
        try(PrintWriter writer = response.getWriter()) {
            writer.println("Hello AppEngine " + SystemProperty.version.get() + " Java " + properties.get("java.specification.version"));
            log.info("Get request handled.");
        } catch (final Exception e) {
            log.error("{}", e.getMessage(), e);
        }
    }
}
