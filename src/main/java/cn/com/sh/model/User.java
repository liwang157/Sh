/**
* @author liwang
* @date 2015年3月31日 下午4:50:29 
*/
package cn.com.sh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** 
 * @Description:
 * @author liwang
 * @date 2015年3月31日 下午4:50:29 
 *  
 */
@Entity(name = "user")
public class User implements Serializable, Cloneable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -8179423974073525038L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name", length = 32)
	private String name;

	@Column(name = "nice_name", length = 32)
	private String nice_name;

	@Column(name = "age")
	private int age;
	
	@Column(name = "address", length = 100)
	private String addresss;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNice_name() {
		return nice_name;
	}

	public void setNice_name(String nice_name) {
		this.nice_name = nice_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getAddresss() {
		return addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", nice_name=" + nice_name
				+ ", age=" + age + ", addresss=" + addresss + "]";
	}


	public Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

}
