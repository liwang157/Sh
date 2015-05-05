package cn.com.sh.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sh.service.UserService;

public class UserDaoTest extends JUnitDaoBase {

	@Autowired
	private UserService userService;

	@Test
	public void testGetAll() {
		System.out.println(userService.getAll().size());
		System.out.println("test");
	}

}
