package com.example.api.unicorns.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnicornMarksDto {
	private Long id;
	
	//private Long unicorn;
	
	
	private String side;
	
	
	private String location;
	
	
	private String marks;
	
	
	private String color;
}
