package org.shargin.testkuber.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Path("")
public class TestController {
    @GET
    public String test() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }
}
