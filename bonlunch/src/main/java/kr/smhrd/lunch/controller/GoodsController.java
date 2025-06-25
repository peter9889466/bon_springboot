package kr.smhrd.lunch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.lunch.dto.GoodsDto;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.service.GoodsService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class GoodsController {
	
	@Autowired
	GoodsService service;
	
	@GetMapping("/goods_list")
	public List<GoodsDto> getGoodsList() {
		System.out.println("[list 출력 컨트롤러]");
		
		List<GoodsDto> list = service.getGoodsList();
		
		if(list != null) {
			System.out.println("목록 가져오기 성공");
		}else {
			System.out.println("가져오기 실패");
		}
		
		System.out.println(list.get(0).toString());
		
		return list;
	}
	
	@GetMapping("/goods_list/{id}")
	public GoodsDto getGoodsDetail(@PathVariable("id") int id) {
		System.out.println("굿즈 출력");
		
		GoodsDto goodsDetail = service.getGoodsDetail(id);
		
		return goodsDetail;
	}
	
	
}
