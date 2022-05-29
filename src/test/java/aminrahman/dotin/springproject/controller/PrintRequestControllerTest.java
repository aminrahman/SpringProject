package aminrahman.dotin.springproject.controller;

import aminrahman.dotin.springproject.SpringProjectApplication;
import aminrahman.dotin.springproject.TestConfig;
import aminrahman.dotin.springproject.entity.PrintPK;
import aminrahman.dotin.springproject.entity.PrintRequest;
import aminrahman.dotin.springproject.service.PrintRequestService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith({SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SpringProjectApplication.class)
@Import(TestConfig.class)
@EnableWebMvc
class PrintRequestControllerTest {

    @MockBean
    PrintRequestService service;

    @Autowired
    MockMvc mockMvc;

    private static PrintRequest printRequest;

    @BeforeAll
    private static void setup() {
        printRequest = PrintRequest.builder().cardPAN("5859831098767594").personnelCode("445544").printId(PrintPK.builder().ipAddress("10.20.30.40").branchCode("12345").build()).build();
    }


    @Order(1)
    @Test
    void testGet() throws Exception {
        when(service.getPrintRequestById(any(PrintPK.class))).thenReturn(printRequest);

        mockMvc.perform(get("/get/{ip-address}/{branch-code}", printRequest.getPrintId().getIpAddress(), printRequest.getPrintId().getBranchCode())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(printRequest.getCardPAN())));
    }

    @Order(2)
    @Test
    void testGetAll() throws Exception {
        List<PrintRequest> printRequests = new ArrayList<>();
        printRequests.add(printRequest);
        when(service.getAll()).thenReturn(printRequests);

        mockMvc.perform(get("/get-all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].cardPAN", Matchers.is(printRequest.getCardPAN())))
                .andExpect(jsonPath("$[0].personnelCode", Matchers.is(printRequest.getPersonnelCode())));
    }

    @Order(3)
    @Test
    void post() throws Exception {
        when(service.saveRecord(any(PrintRequest.class))).thenReturn(printRequest);
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(printRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonElement.toString()))
                .andDo(print())
                .andExpect(content().string(containsString(printRequest.getCardPAN())));
    }

    @Order(4)
    @Test
    void patch() throws Exception {
        when(service.patch(any(PrintRequest.class))).thenReturn(printRequest);
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(printRequest);
        mockMvc.perform(MockMvcRequestBuilders.patch("/patch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonElement.toString()))
                .andDo(print())
                .andExpect(content().string(containsString(printRequest.getCardPAN())));
    }

    @Order(5)
    @Test
    void put() throws Exception {
        when(service.update(any(PrintRequest.class))).thenReturn(printRequest);
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(printRequest);
        mockMvc.perform(MockMvcRequestBuilders.put("/put")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonElement.toString()))
                .andDo(print())
                .andExpect(content().string(containsString(printRequest.getCardPAN())));
    }
}