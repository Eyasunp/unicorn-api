package com.example.api.unicorns.bean;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnicornDto {
	
    private Long unicornId;
	
	
	private String name;
	
	
	private String hairColor;
	
	
	private int hornLength;
	
	
	private String hornColor;
	
	
	private String eyeColor;
	
	
	private int height;
	
	
	private String heightUnit;
	
	
	private int weight;
	
	
	private String weightUnit;
	
	
	private List<UnicornMarksDto> identifiableMarks;
}
