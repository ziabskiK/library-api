package test.controller;

import com.app.spring.controller.AuthController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;


    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(authController).build();
    }

    @Test
    public void login() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/login")).andReturn();
        assertEquals("login", result.getResponse().getContentAsString());
        assertEquals(200, result.getResponse().getStatus());

    }

    @Test
    public void register() {
    }
}