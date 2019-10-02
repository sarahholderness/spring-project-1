package com.pluralsight.springblog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringblogApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {
		try {
			//this.mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string("Hello World"));


			MvcResult result =  this.mvc.perform(get("/")).andReturn();
			MockHttpServletResponse response =  result.getResponse();
			String content = response.getContentAsString();
			System.out.println("content = " + content);
			Document doc = Jsoup.parse(content);
			Elements elements = doc.getElementsByTag("h2");
			assertEquals("Post 1", elements.first().html());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}