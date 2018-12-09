# protobuf_gradle_example
A sample protocol buffer project for java and python UDP communication
All dependencies and message generation are handled by gradle

## RUNNING PYTHON APPS
```bash
gradle runPythonClient #Hardcoded IP and Port for now.
gradle runPythonServer #Hardcoded IP and Port. NOT QUITE WORKING YET
```

## RUNNING JAVA APPS
```bash
gradle runJavaServer --args '[IP_ADDRESS] [PORT]'
gradle runJavaClient --args '[IP_ADDRESS] [PORT]'
```

## Dependencies
- Protocol Buffers v3.6.1 
   - Install Protocol Buffer Binaries. Add bin to system path. https://github.com/protocolbuffers/protobuf/releases

- Java 8+
- Gradle 4+

## References

### Protocol Buffer
- https://developers.google.com/protocol-buffers/docs/overview
- https://blog.marcgravell.com/2010/10/datatable-life-in-old-beast.html


### Network Tables
- https://robotpy.readthedocs.io/en/stable/guide/nt.html
- http://wpilib.screenstepslive.com/s/3120/m/7912/l/80205-writing-a-simple-networktables-program-in-c-and-java-with-a-java-client-pc-side
- http://wpilib.screenstepslive.com/s/4485/m/24194/l/479908-reading-array-values-published-by-networktables
- https://www.codeproject.com/Articles/1132742/%2fArticles%2f1132742%2fIn-Search-of-the-Ultimate-DataTable-Serializer

