package org.total.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-web.xml"})
public class AllTest {
    @Autowired
    private WebApplicationContext webContext;

    private MockMvc mockMvc;
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
    }
    @Test
    public void testLocalLogin() throws Exception{
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/test1")

                .param("username", "372993"));
        MvcResult mvcResult = resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
//        TreeFrogMsg.UserLoginResponse userLoginResponse = TreeFrogMsg.UserLoginResponse.parseFrom(mvcResult.getResponse()
//                .getContentAsByteArray());
//        System.out.println(userLoginResponse.getResultCode());
//        System.out.println(userLoginResponse.getWebKey());
//        System.out.println(userLoginResponse.getUserBaseInfo().getNickName());
    }

}
