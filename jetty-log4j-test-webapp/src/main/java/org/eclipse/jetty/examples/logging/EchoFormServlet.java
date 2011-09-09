package org.eclipse.jetty.examples.logging;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@SuppressWarnings("serial")
public class EchoFormServlet extends HttpServlet
{
    private static final Logger LOG = Logger.getLogger(EchoFormServlet.class);

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        LOG.info("Got request from " + req.getRemoteAddr() + " using " + req.getHeader("User-Agent"));

        PrintWriter out = null;

        try
        {
            out = new PrintWriter(resp.getWriter());

            out.println("<html>");
            out.println("<head><title>Echo</title></head>");
            out.println("<style> h2 { border-bottom: 1px solid gray; width: 50%; }</style>");
            out.println("<body>");

            out.println("<h2>Request Headers</h2>");

            out.println("<pre>");
            Enumeration<String> names = req.getHeaderNames();
            while (names.hasMoreElements())
            {
                String name = names.nextElement();
                String value = req.getHeader(name);
                out.printf("%s: %s%n",name,value);
            }
            out.println("</pre>");

            out.println("<h2>Form Data</h2>");

            out.println("<pre>");
            names = req.getParameterNames();
            while (names.hasMoreElements())
            {
                String name = names.nextElement();
                String value = req.getParameter(name);
                String msg = String.format("%s = \"%s\"",name,value);
                LOG.info("[form] " + msg);
            }
            out.println("</pre>");

            out.println("</body>");
            out.println("</html>");

            out.flush();
        }
        finally
        {
            close(out);
        }
    }

    private static void close(Closeable c)
    {
        if (c == null)
        {
            return;
        }

        try
        {
            c.close();
        }
        catch (IOException ignore)
        {
            /* ignore */
        }
    }
}
