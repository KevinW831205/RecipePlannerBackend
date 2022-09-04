package com.github.kevinw831205.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.model.SignupInfo;
import com.github.kevinw831205.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.github.kevinw831205")
@RunWith(SpringRunner.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountRepository repository;

    @Before
    public void setUp() {
        Assert.assertNotNull(mvc);
        Assert.assertNotNull(repository);
    }

    @Test
    public void testCreateAccount() throws Exception {

        SignupInfo signupInfo = new SignupInfo();
        signupInfo.setUsername("test123");
        signupInfo.setPassword("pw1234");

        Account account = new Account();
        account.setUsername(signupInfo.getUsername());
        account.setPassword(signupInfo.getPassword());


        Account savedAccount =  repository.save(any(Account.class));
        System.out.println("saved account: "+savedAccount);
        BDDMockito
                .given(savedAccount)
                .willReturn(account);

        String postContent = new ObjectMapper().writeValueAsString(signupInfo);
        System.out.println(postContent);
        //        String expectedContent="{\"id\":0,\"username\":\"test123\",\"password\":\"pw1234\"}";
        MockHttpServletRequestBuilder operationToPerform = MockMvcRequestBuilders
                .post("/api/account/")
                .content(postContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        ResultActions performanceResult = this.mvc.perform(operationToPerform);
        performanceResult.andExpect(MockMvcResultMatchers.status().isCreated());
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

//    @Test
//    public void testShow() throws Exception {
//        Long givenId = 1L;
//        BDDMockito
//                .given(repository.findById(givenId))
//                .willReturn(Optional.of(new Baker("New Baker!", null, null)));
//
//        String expectedContent = "{\"id\":null,\"name\":\"New Baker!\",\"employeeId\":null,\"specialty\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .get("/bakers/" + givenId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }


}
