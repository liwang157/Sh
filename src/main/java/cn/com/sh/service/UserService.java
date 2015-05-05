/**
* @author liwang
* @date 2015年3月31日 下午5:44:48 
*/
package cn.com.sh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sh.dao.IUserDao;
import cn.com.sh.model.User;

/** 
 * @Description:
 * @author liwang
 * @date 2015年3月31日 下午5:44:48 
 *  
 */
@Service("userService")
@Transactional
public class UserService {

	@Autowired
	private IUserDao dao;

	public List<User> getAll() {
		return dao.queryAll();
	}

	public void save(User user) {
		dao.add(user);
	}

	public User getUserById(int id) {
		User user = new User();
		user.setAge(22);
		user.setAddresss("深圳");
		user.setName("程艳2");
		user.setNice_name("chengyan");
		save(user);
		return dao.queryOne(id);
	}
}
