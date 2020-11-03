# Jetty with WebApp using log4j

This project is a demonstration of using Jetty with Log4j2.

To build the project use maven ...

``` shell
$ mvn clean install
```

To run the project, you will need a `jetty-home` downloaded and unpacked somewhere.

https://search.maven.org/artifact/org.eclipse.jetty/jetty-home

Example download and install of jetty-home

``` shell 
$ cd $HOME/tmp
$ curl -O https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/9.4.33.v20201020/jetty-home-9.4.33.v20201020.tar.gz
$ tar -zxf jetty-home-9.4.33.v20201020.tar.gz
```

To run the example, use the normal jetty start procedures.

``` shell
$ cd /path/to/this/git/clone
$ java -jar $HOME/tmp/jetty-home-9.4.33.v20201020/start.jar
```

There is now a server listening on port 9090, so hit it with your http client of choice and observe the output.

```
$ java -jar ~/code/jetty/distros/jetty-home-9.4.33.v20201020/start.jar 
2020-11-03 14:33:46.240:INFO::main: Logging initialized @354ms to org.eclipse.jetty.util.log.StdErrLog
2020-11-03 14:33:46.476:INFO:oejs.Server:main: jetty-9.4.33.v20201020; built: 2020-10-20T23:39:24.803Z; git: 1be68755656cef678b79a2ef1c2ebbca99e25420; jvm 11.0.8+10
2020-11-03 14:33:46.489:INFO:oejdp.ScanningAppProvider:main: Deployment monitor [file:///home/joakim/code/jetty/github/jetty-and-log4j-example/webapps/] at interval 1
2020-11-03 14:33:46.759:INFO:oeja.AnnotationConfiguration:main: Scanning elapsed time=118ms
2020-11-03 14:33:46.763:INFO:oejw.StandardDescriptorProcessor:main: NO JSP Support for /demo, did not find org.eclipse.jetty.jsp.JettyJspServlet
2020-11-03 14:33:46.778:INFO:oejs.session:main: DefaultSessionIdManager workerName=node0
2020-11-03 14:33:46.778:INFO:oejs.session:main: No SessionScavenger set, using defaults
2020-11-03 14:33:46.779:INFO:oejs.session:main: node0 Scavenging every 600000ms
2020-11-03 14:33:46.798:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@71075444{demo,/demo,file:///tmp/jetty-0_0_0_0-9090-demo_war-_demo-any-6832432338461527336/webapp/,AVAILABLE}{/home/joakim/code/jetty/github/jetty-and-log4j-example/webapps/demo.war}
2020-11-03 14:33:46.816:INFO:oejs.AbstractConnector:main: Started ServerConnector@2f7773b5{HTTP/1.1, (http/1.1)}{0.0.0.0:9090}
2020-11-03 14:33:46.818:INFO:oejs.Server:main: Started @932ms
[webapp-config] 14:34:01.456 [qtp1307904972-47] INFO  org.eclipse.jetty.examples.logging.DumpServlet - Got GET request from [0:0:0:0:0:0:0:1] using Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.183 Safari/537.36
```

The entries prefixed with `[webapp-config]` are coming from a configuration present in the WAR file itself.