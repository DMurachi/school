package com.bucares.boilerplate.controller;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.bucares.boilerplate.URLConstants.APP_VERSION_URL;
import static com.bucares.boilerplate.URLConstants.HEALTH_ENDPOINT_URL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

@WithMockUser
@RunWith(SpringRunner.class)
@WebMvcTest(AppController.class)
public class AppControllerTest extends TestCase {

    @Autowired
    private MockMvc mvc;

    @Value("${build.version}")
    private String buildVersion;

    @Test
    public void testGetVersion() throws Exception {
        mvc.perform(get(APP_VERSION_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.version", is(buildVersion)));
    }

    @Test
    public void testGetIndex() throws Exception {
        mvc.perform(get("/"))
                .andExpect(view().name("index"))
                .andExpect(status().isOk());
    }

    @Test
    public void testHealth() throws Exception {
        mvc.perform(get(HEALTH_ENDPOINT_URL))
                .andExpect(view().name("redirect:/"))
                .andExpect(status().isFound());
    }
}