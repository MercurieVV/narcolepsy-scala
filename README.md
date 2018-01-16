[![](https://jitpack.io/v/MercurieVV/narcolepsy-scala.svg)](https://jitpack.io/#MercurieVV/narcolepsy-scala)

# Narcolepsy - A Scala framework for building typesafe API clients

Narcolepsy is a Scala framework to help you build clients for third-party RESTful web services with maximum typesafety and minimal moving parts. Narcolepsy is modelled closely after [Squeryl](http://squeryl.org/): it provides a typesafe, ORM-like abstraction layer on top of HTTP method-based, resource-oriented web services. As such it works best with APIs which conform closely to the [RESTful ideal](http://blog.steveklabnik.com/posts/2011-07-03-nobody-understands-rest-or-http).

# Health warning

Narcolepsy is highly incomplete. Error handling, non-HTTP-based authentication, POST, PUT and HEAD support are all still to come. Apologies - we wanted to release early (not least because SBT doesn't support private GitHub repositories as dependencies). If there is a specific feature you would like to see sooner rather than later, please create a [GitHub issue](https://github.com/orderly/narcolepsy-scala/issues) for it.

# How Narcolepsy works

Narcolepsy is designed as a framework which you extend and configure on a per-web service basis. An example of a Narcolepsy-based client library is [Prestasac, v2 branch](https://github.com/orderly/prestashop-scala-client/tree/v2), a Scala client for the PrestaShop web service.

**The rest of this section coming soon**

# Who shouldn't use Narcolepsy

Narcolepsy probably isn't for you if any of the following things is true:

* Your target web service is fragile or frequently changing
* You only need to extract a small subset of data from your target web service
* Your target web service is non-RESTful - for example, it is RPC- or SOAP-like

In these cases, we strongly recommend using the excellent [Unfiltered](http://unfiltered.databinder.net/Unfiltered.html) Scala toolkit instead of Narcolepsy. 

# Technologies

Narcolepsy uses [Jackson](http://jackson.codehaus.org/) for JSON (un)marshalling, and JAXB for XML (un)marshalling. In theory Narcolepsy can work with any JAXB implementation - it has been tested with the Oracle Glassfish [JAXB reference implementation](http://jaxb.java.net/), and also with the Eclipse Foundation's [EclipseLink MOXy](http://eclipse.org/eclipselink/moxy.php). A small subset of Narcolepsy's XML functionality is only compatible with MOXy, but this functionality is sandboxed in the [moxy sub-package](https://github.com/orderly/narcolepsy-scala/tree/master/src/main/scala/co/orderly/narcolepsy/marshallers/xml/moxy).

Although we write our binding classes for Typesafe mode in Scala, Jackson and JAXB are pure-Java technologies, so writing your bindings in Java (or generating them using e.g. [xjc](http://docs.oracle.com/javase/6/docs/technotes/tools/share/xjc.html)) should work fine as well.

By default Narcolepsy uses the Apache HttpComponents [HttpClient](http://hc.apache.org/httpcomponents-client-ga/) for HTTP communication with the target web service. However, Narcolepsy has been designed so that HttpClient can be swapped out for an alternative 'adapter' at the point of configuring your Narcolepsy-based client library. We plan on bundling a second adapter for [spray-client](https://github.com/spray/spray/wiki/spray-client) in due course.

# License

Like its main component technologies, Narcolepsy is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html). 
