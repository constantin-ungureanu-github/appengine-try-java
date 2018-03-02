package com.masterminds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws
      IOException {
    resp.setContentType("text/plain");

    try (final PrintWriter writer = resp.getWriter()) {
      writer.println("{ \"name\": \"MasterMinds!\" }");
      log.info("Get request handled.");
    } catch (final Exception e) {
      log.error("{}", e.getMessage(), e);
    }
  }
}
