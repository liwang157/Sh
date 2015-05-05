/**
* @author liwang
* @date 2015年4月1日 上午11:37:22 
*/
package cn.com.sh.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.sh.model.User;
import cn.com.sh.model.dto.Address;
import cn.com.sh.model.dto.UserDTO;
import cn.com.sh.service.UserService;

/** 
 * @Description:
 * @author liwang
 * @date 2015年4月1日 上午11:37:22 
 *  
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String aa() {
		System.out.println(userService.getUserById(30));
		return "user/list";
	}

	@ResponseBody
	@RequestMapping(value = "/body/{id}", method = RequestMethod.GET)
	public UserDTO bb(@PathVariable("id") String id) {
		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setName("张三");
		List<String> list = new ArrayList<String>();
		list.add("深圳");
		list.add("广州");
		Address address = new Address();
		address.setCity(list);
		UserDTO dto = new UserDTO();
		try {
			BeanUtils.copyProperties(dto, user); // 克隆
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setCitys(address);
		return dto;
	}

	public String cc() {
		return "redirect:/appointments";
	}

}

