package com.alekseysamoylov.mbean;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * To JMX connection between different servers add the following params to your jvm:
 *
 *  -Dcom.sun.management.jmxremote.port=8090 \
 *  -Dcom.sun.management.jmxremote.authenticate=false \
 *  -Dcom.sun.management.jmxremote.ssl=false \
 *
 *  for example:
 *   java -Dcom.sun.management.jmxremote.port=8090 \
 *        -Dcom.sun.management.jmxremote.authenticate=false \
 *        -Dcom.sun.management.jmxremote.ssl=false \
 *        -jar mbean-0.0.1-SNAPSHOT.jar
 */
@Component
@ManagedResource(
        objectName = "learn:bean=MyMbeanService,type=service",
        description = "Simple object with one method to invoke via JMX"
)
public class MbeanService {

    static volatile boolean waitMbeanMethodInvoke = true;

    @ManagedOperation(description = "Print a message to the console")
    @ManagedOperationParameters({@ManagedOperationParameter(name = "message",
            description = "Message to print into the console")})
    public void triggerOnce(String message) {
        System.out.println("JMX: " + message);
        waitMbeanMethodInvoke = false;
    }
}
