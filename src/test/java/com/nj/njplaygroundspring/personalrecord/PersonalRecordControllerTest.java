package com.nj.njplaygroundspring.personalrecord;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nj.njplaygroundspring.personalrecord.model.PersonalRecord;
import com.nj.njplaygroundspring.personalrecord.entities.PersonalRecordEntity;
import com.nj.njplaygroundspring.personalrecord.model.PersonalRecordChange;
import com.nj.njplaygroundspring.personalrecord.service.PersonalRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
class PersonalRecordControllerTest {

    private MockMvc mvc;

    @Mock
    PersonalRecordService service;

    @InjectMocks
    private PersonalRecordController personalRecordController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private List<PersonalRecord> personalRecordsMock;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(personalRecordController).build();

        this.personalRecordsMock = new ArrayList<>();
        Map<String, Short> record = new HashMap<>();
        record.put("3x12", (short) 25);
        personalRecordsMock.add(new PersonalRecord("exercise1", record));
    }

    @Test
    void getAll() throws Exception {
        given(service.findAll()).willReturn(this.personalRecordsMock);

        MockHttpServletResponse response = mvc.perform(
                get("/personalrecords")
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        verify(service).findAll();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                objectMapper.writeValueAsString(this.personalRecordsMock)
        );
    }

    @Test
    void update() throws Exception {
        PersonalRecordChange change = new PersonalRecordChange("exercise1", "3x12", (short) 55);

        given(service.update(change)).willReturn(new PersonalRecordEntity());
        given(service.findAll()).willReturn(personalRecordsMock);

        MockHttpServletResponse response = mvc.perform(
                post("/personalrecords")
                        .content(objectMapper.writeValueAsString(change))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        verify(service).update(change);
        assertThat(response.getContentAsString()).isEqualTo(
                objectMapper.writeValueAsString(personalRecordsMock)
        );
    }
}
