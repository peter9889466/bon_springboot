package kr.smhrd.lunch.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import kr.smhrd.lunch.entity.User;

// 기존 Spring -> 로직을 처리하고 결과를 반환할 때 view 이름 : String
// @controller -> 화면을 반환할 수 있는 component
// 비동기 통신 , 화면이 아니라 데이터만 반환받고자 할 때
// @ResponseBody 추가
@RestController // 해당 컨트롤러는 무조건 데이터만 반환가능한 컨트롤러다
public class HelloController {

	@GetMapping("/Hello/{id}")
	public User HelloRest(@PathVariable("id") int id) {

		System.out.println("전달받은 id값" + id);
		// 데이터를 주로 JSON 객체 형태로 반환
		// data-bind -> 데이터를 map 혹은 list 형태로 리턴
		// Json 객체 형태로 변환하여 화면(View)에 리턴

		// front와 back 개발이 완전히 분리된다.

		// user -> 이름, 나이, 성별
		User user1 = new User("김승혁", 25, "남");
		// ArrayList -> 우리 팀원의 데이터를 저장!
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(new User("박수현", 20, "여"));
		userList.add(new User("류이수", 20, "남"));
		userList.add(new User("신정욱", 20, "남"));

		// @PathVariable -> url로 넘어온 인덱스에 저장된 팀원을
		// 데이터 형태로 전송!
		return userList.get(id);
	}
}
