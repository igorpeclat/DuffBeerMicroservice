package com.duff.client.controller.test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DuffControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void findAllTest() throws Exception {
		this.mvc.perform(get("/beer")).andExpect(status().isOk()).andExpect(content().string(containsString("style")));
	}

	@Test
	public void findTest() throws Exception {
		this.mvc.perform(get("/beer/Weissbier")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Weissbier")));
	}

	@Test
	public void getBeerByAverageTemperatureTest() throws Exception {
		this.mvc.perform(post("/beer/temperature").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"temperature\" : \"-1\"}")).andExpect(status().isOk())
				.andExpect(content().string(containsString("beerStyle")))
				.andExpect(content().string(containsString("playlist")));
	}

	@Test
	public void saveTest() throws Exception {
		this.mvc.perform(post("/beer").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"style\" : \"Skol\", \"minTemperature\": -3, \"maxTemperature\" : 2 }"))
				.andExpect(status().isCreated());
	}

	@Test
	public void updateTest() throws Exception {
		this.mvc.perform(put("/beer").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"style\" : \"Weissbier\", \"minTemperature\": -3, \"maxTemperature\" : 2 }"))
				.andExpect(status().isNoContent());
	}

	@Test
	public void deleteTest() throws Exception {
		this.mvc.perform(delete("/beer/Weissbier")).andExpect(status().isNoContent());
	}
}
