package com.github.kevinw831205.controller;

import com.github.kevinw831205.model.Account;
import com.github.kevinw831205.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AccountController {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountRepository repository;

    @Test
    public void testCreateAccount() throws Exception {
        Account account = new Account();
        account.setUsername("test1");
        account.setPassword("pw1234");

        BDDMockito
                .given(repository.save(account))
                .willReturn(account);

        String expectedContent="{\"id\":0,\"username\":\"test1\",\"password\":\"pw1234\"}";
        this.mvc.perform(MockMvcRequestBuilders
                .post("api/account/")
                .content(expectedContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
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
