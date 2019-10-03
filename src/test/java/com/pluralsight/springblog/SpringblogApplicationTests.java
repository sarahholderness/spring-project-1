package com.pluralsight.springblog;

import com.pluralsight.springblog.data.PostRepository;
import com.pluralsight.springblog.model.Post;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringblogApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired(required = false)
	PostRepository postRepository;

	@Test
	public void contextLoads() {
		try {
			//this.mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string("Hello World"));

//			List<Post> postList = postRepository.getAllPosts();
			
			MvcResult result =  this.mvc.perform(get("/")).andReturn();
			MockHttpServletResponse response =  result.getResponse();
			String content = response.getContentAsString();

			Document doc = Jsoup.parse(content);
			Elements h2Elements = doc.getElementsByTag("h2");
			Elements pElements = doc.getElementsByTag("p");
			//assertEquals("Post 1", elements.first().html());

			Element h2Elem = h2Elements.first();
			Element pElem = pElements.first();

//			for (Post post: postList) {
//				System.out.println("h2Elem = " + h2Elem.html());
//				System.out.println("pElem = " + pElem.html());
//				assertEquals(post.getTitle(), h2Elem.html());
//				h2Elem = h2Elem.nextElementSibling();
//				assertEquals(post.getBody(), pElem.html());
//				pElem = pElem.nextElementSibling();
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}