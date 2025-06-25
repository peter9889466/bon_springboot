package kr.smhrd.lunch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "goods_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDetail {
	
	//@OneToOne, @JoinColumn("goods_id")
	// Goods -> Goods_detail
	
	@Id
	private Integer goods_id;
	
	@Column(name = "sub_thumb")
	private String sub_thumb;
	
	@Column(name = "txt")
	private String txt;
	
	@Column(name = "summary")
	private String summary;
}
