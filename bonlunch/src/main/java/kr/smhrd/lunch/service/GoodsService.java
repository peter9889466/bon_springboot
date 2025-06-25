package kr.smhrd.lunch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.lunch.dto.GoodsDto;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import kr.smhrd.lunch.repository.GoodsDetailRepository;
import kr.smhrd.lunch.repository.GoodsRepository;

@Service
public class GoodsService {

	@Autowired
	GoodsRepository repo;
	
	@Autowired
	GoodsDetailRepository detailRepo;
	
	public List<GoodsDto> getGoodsList() {
		// TODO Auto-generated method stub
		List<Goods> list = repo.findAll();
		ArrayList<GoodsDto> list2 = new ArrayList<GoodsDto>();
		
		for (Goods goods: list) {
			list2.add(GoodsDto.fromEntity(goods));
		}
		
		return list2;
	}

	public GoodsDto getGoodsDetail(int id) {
		
		// 1. id 값을 가지고 제품 정보 Goods 가지고 오기
		Goods goods = repo.findById(id).orElse(null);
		GoodsDetail detail = detailRepo.findById(id).orElse(null);
		
		if(goods == null || detail == null) {
			return null;
		}
		
		GoodsDto dto = new GoodsDto();
		dto.setId(goods.getId());
		dto.setPrice(goods.getPrice());
		dto.setName(goods.getName());
		dto.setNew(goods.isNew());
		dto.setBest(goods.isBest());
		dto.setMain_thumb(goods.getMain_thumb());
		dto.setDetail(detail);
	
		
		return dto;
	}

	
}
