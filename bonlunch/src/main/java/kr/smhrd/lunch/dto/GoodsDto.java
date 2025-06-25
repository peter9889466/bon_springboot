package kr.smhrd.lunch.dto;

import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsDto {	
	
	private Integer id;
	private String name;
	private String price;
	private boolean isNew;
	private boolean isBest;
	private String main_thumb;
	
	private GoodsDetail detail;
	
	public static GoodsDto fromEntity(Goods goods) {
		return GoodsDto.builder()
				.id(goods.getId())
				.name(goods.getName())
				.price(goods.getPrice())
				.isNew(goods.isNew())
				.isBest(goods.isBest())
				.main_thumb(goods.getMain_thumb())
				.build();
				
	}
	
}
