package btgk.ltw.springboot.test;

import btgk.ltw.springboot.service.ForumService;
import junit.framework.TestCase;


public class TestForum extends TestCase {
	public void testData(){
		ForumService data = ForumService.getInstance();
		
		assertNotNull(data.checkUser("chuotcon", "chuotcon"));
		assertNotNull(data.checkUser("leb", "leb"));
		assertNotNull(data.checkUser("GSKH", "GSKH"));
		assertNull(data.checkUser("doctorQ", "abc"));
		assertNull(data.checkUser("hoang", "GSKH"));
		
		assertEquals(data.getTopics().size(), 5);
		
		assertEquals(data.findTopic(1).getMessages().size(), 1);
		assertEquals(data.findTopic(2).getMessages().size(), 0);
		assertEquals(data.findTopic(3).getMessages().size(), 0);
		assertEquals(data.findTopic(4).getMessages().size(), 1);
		assertEquals(data.findTopic(5).getMessages().size(), 3);
	}
}
