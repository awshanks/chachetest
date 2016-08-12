package com.example;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {

    private static final Logger log = Logger.getLogger(ExampleController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @Cacheable("calculateResult")
    public String calculateResult() {
        log.debug("Performing expensive calculation...");
        // perform computationally expensive calculation
        simulateSlowService();

        Books b = new Books();

        Gson gson = new Gson();
        String json = gson.toJson(b);

        return json;
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            log.debug("Performing expensive calculation...");
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}