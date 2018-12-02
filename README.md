# protobuf_gradle_example
A sample protocol buffer project for java and python UDP communication
All dependencies and message generation are handled by gradle

## RUNNING PYTHON APPS
gradle runPythonClient #Hardcore IP and Port for now..
gradle runPythonServer #Hardcore IP and Port. NOT WORKING YET

## RUNNING JAVA APPS
gradle runJavaServer --args '[IP_ADDRESS] [PORT]'
gradle runJavaClient --args '[IP_ADDRESS] [PORT]'

## Dependencies
- Protocol Buffers v3.6.1 
   - Install Protocol Buffer Binaries. Add bin to system path. https://github.com/protocolbuffers/protobuf/releases

- Java 8+
- Gradle 4+