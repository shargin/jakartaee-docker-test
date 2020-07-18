package org.shargin.testkuber.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("")
public class TestController {
    @GET
    public String test() {
        return "test response";
    }
}
