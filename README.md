cb2json
=======

[Copybook][1] to [JSON][2] conversion. 

This library converts a fixed-width data stream into its JSON
equivalent using a Copybook to define both structures.

Install
=======

    git clone https://github.com/devstopfix/cb2java.git
    cd cb2java
    mvn install
    cd ..
    git clone https://github.com/devstopfix/cb2json.git
    cd cb2json
    mvn install

Include the JAR file in your Java project pom.xml:

    <dependency>
        <groupId>net.devstopfix.cb2json</groupId>
        <artifactId>cb2json</artifactId>
        <version>1.1</version>
    </dependency>

or your [Leiningen](https://github.com/technomancy/leiningen) project.clj:

    [net.devstopfix.cb2json/cb2json "1.1"]


Workflow
========

* Create an instance of the `Copybook` class using the `CopybookParser` object or the `Copybooks` helper
* Use the functions of `CB2JSON`, one parameter will be your `Copybook`, the others will be your input and output streams


Roadmap
=======

This library is currently in the first of three versions. The 
functionality remains the same but the implementation details and 
performance vary:

Version 1
---------

A simple prototype that makes many internal data conversions:

* Uses a [fork][3] of the [cb2java][4] library to parse a Copybook into a tree of [cb2java Data objects][5]
* Convert the [Data tree](5) into a [POJO][7] tree of [Maps][8] and [Lists][9] using [toMap][6]
* Convert the POJO tree to JSON using [Jacksons][10] [ObjectMapper][11]

Version 2
---------

Possible improvements:

* skip the conversion from [Data][5] to POJOs
* write the data directly to the [Jackson streaming API][12]

Version 3
---------

* Make one pass over the Copybook stream, do not generate the intermediate [cb2java Data objects][5] but write JSON directly to the output stream using [Jackson streaming API][12]


[1]: http://en.wikipedia.org/wiki/Copybook_(programming)
[2]: http://json.org
[3]: https://github.com/devstopfix/cb2java.git
[4]: http://sourceforge.net/projects/cb2java/
[5]: https://github.com/devstopfix/cb2java/tree/master/src/main/java/net/sf/cb2java/data
[6]: https://github.com/devstopfix/cb2java/blob/master/src/main/java/net/sf/cb2java/data/Record.java
[7]: http://en.wikipedia.org/wiki/Plain_Old_Java_Object
[8]: http://docs.oracle.com/javase/6/docs/api/java/util/Map.html
[9]: http://docs.oracle.com/javase/6/docs/api/java/util/List.html
[10]: https://github.com/FasterXML/jackson-databind
[11]: https://github.com/FasterXML/jackson-databind/blob/master/src/main/java/com/fasterxml/jackson/databind/ObjectMapper.java
[12]: http://wiki.fasterxml.com/JacksonStreamingApi

