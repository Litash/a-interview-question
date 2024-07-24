package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;
    

    @Test
    void testGetCustomers() throws Exception {
        Customer customer = new Customer();
        customer.setName("John Doe");
        
        given(customerService.getCustomers(0, 10, "name", "asc"))
                .willReturn(new org.springframework.data.domain.PageImpl<>(java.util.List.of(customer)));
        
        mockMvc.perform(MockMvcRequestBuilders.get("/customers")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sortBy", "name")
                        .param("direction", "asc")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").value("John Doe"));
    }

    @Test
    void testGetCustomers_no_param() throws Exception {
        Customer customer = new Customer();
        customer.setName("John Doe");
        
        given(customerService.getCustomers(0, 10, "name", "asc"))
                .willReturn(new org.springframework.data.domain.PageImpl<>(java.util.List.of(customer)));
        
        mockMvc.perform(MockMvcRequestBuilders.get("/customers")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").value("John Doe"));
    }
    
}