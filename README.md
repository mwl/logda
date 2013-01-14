Logda logging bridges
===

NOTE: Logda's API is not final yet. Although the library is fairly funcional, this is still beta-quality code. Do not rely on it for production code just yet. Feedback is very welcome!

What is it?
---

Logda is currently a Log4j logging bridge with support for Java 8 Lamdas.

Features
---

* Log4j equivalent api (Means same method signatures)
* Less code overhead for adaptive logging

How do I use it?
---

Assuming you are using Log4j today

1. Checkout this projekt and run ```mvn install``` in the root of this projekt
2. Add the following dependency to your Maven projekt

   ```xml
   <dependency>
      <groupId>dk.mwl.logda</groupId>
      <artifactId>logda-log4j</artifactId>
      <version>1.0-SNAPSHOT</version>
   </dependency>
   ```
3. Start replacing your *org.apache.log4j.Logger* and *org.apache.log4j.LoggerFactory* imports with *dk.mwl.logda.Logger* and *dk.mwl.logda.LoggerFactory*
4. Start logging with

   ```java
   logger.debug(() -> "Queue size=" + queue.size())
   ```
   
As this example is using Java 8's Lambda expressions it will only calculate the queue size if debug logging is enable for this context.