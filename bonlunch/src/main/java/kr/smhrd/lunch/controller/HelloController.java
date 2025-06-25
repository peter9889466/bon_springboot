package kr.smhrd.lunch.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.lunch.entity.User;

// 기존 Spring -> 로직을 처리하고 결과를 반환할 때 view 이름 : String
// @controller -> 화면을 반환할 수 있는 component
// 비동기 통신,  화면이 아니라 데이터`만` 반환 받고자 할 때
// @ResponseBody

@RestController // 해당 컨트롤러는 무조건 데이터만 반환하는 컨트롤러다
public class HelloController {
	
	// @PathVariable : url의 경로에 포함되어 전달되는 데이터를 변수에 바인딩 하기 위해서 사용한다
	
	// 요청 매핑을 잡을 때!
	// GetMapping("/goods_detail/{id}")
	// 매개변수를 통해 값을 가지고 올 수 있다
	// 메소드명(@PathVariable("id") int id)
	
	@GetMapping("/Hello/{id}")
	public User hellorest(@PathVariable("id") int id) {
		
		System.out.println("전달받은 id 값 : "+id);
		
		// 데이터를 주로 JSON 객체 형태로 반환
		// data-bind -> 데이터를 map 혹은 list 형태로 리턴
		// Json 객체 형태로 변환하여 화면(View)에 리턴
		
		// Front와 back 개발이 완전히 분리된다
		
		// user -> 이름, 나이, 성별
		// ArrayList -> 우리 팀원의 데이터를 저장
		
		// @PathVariable -> url로 넘어온 인덱스에 저장된 팀원을
		// 데이터 형태로 전송
		
		User user1 = new User("A", 20, "남");
		User user2 = new User("B", 25, "여");
		User user3 = new User("C", 30, "남");
		
		ArrayList<User> list = new ArrayList<User>();
		
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		
		
		return list.get(id);
	}

}
