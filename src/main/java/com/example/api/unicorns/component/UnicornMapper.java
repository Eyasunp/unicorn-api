package com.example.api.unicorns.component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.api.unicorns.bean.UnicornDto;
import com.example.api.unicorns.bean.UnicornEntity;
import com.example.api.unicorns.bean.UnicornMarksDto;
import com.example.api.unicorns.bean.UnicornMarksEntity;

@Component
public class UnicornMapper {
	
	public UnicornDto mapToDto(final UnicornEntity entity) {
		UnicornDto dto = UnicornDto.builder()
				.unicornId(entity.getUnicornId())
				.name(entity.getName())
				.hairColor(entity.getHairColor())
				.hornLength(entity.getHornLength())
				.hornColor(entity.getHornColor())
				.eyeColor(entity.getEyeColor())
				.height(entity.getHeight())
				.heightUnit(entity.getHeightUnit())
				.weight(entity.getWeight())
				.weightUnit(entity.getWeightUnit())
				.build();
		if(Objects.nonNull(entity.getIdentifiableMarks()) && !entity.getIdentifiableMarks().isEmpty()) {
			dto.setIdentifiableMarks(mapToUnicornMarksDto(entity));
		}
		return dto;
	}
	public UnicornEntity mapToEntity(final UnicornDto dto) {
		UnicornEntity entity = UnicornEntity.builder()
				.name(dto.getName())
				.hairColor(dto.getHairColor())
				.hornLength(dto.getHornLength())
				.hornColor(dto.getHornColor())
				.eyeColor(dto.getEyeColor())
				.height(dto.getHeight())
				.heightUnit(dto.getHeightUnit())
				.weight(dto.getWeight())
				.weightUnit(dto.getWeightUnit())
				.build();
		if(Objects.nonNull(dto.getIdentifiableMarks()) && !dto.getIdentifiableMarks().isEmpty()) {
			entity.setIdentifiableMarks(mapToUnicornMarksEntity(dto, entity));
		}
		return entity;
	}
	
	public List<UnicornMarksDto> mapToUnicornMarksDto(final UnicornEntity entity){
		List<UnicornMarksEntity> entityList = entity.getIdentifiableMarks();
		return entityList.stream().map(umEntity -> {
			UnicornMarksDto umDto = UnicornMarksDto.builder()
					.side(umEntity.getSide())
					.location(umEntity.getLocation())
					.marks(umEntity.getMarks())
					.color(umEntity.getColor())
					.build();
			return umDto;
		}).collect(Collectors.toList());
	}
	
	public List<UnicornMarksEntity> mapToUnicornMarksEntity(final UnicornDto dto, final UnicornEntity entity) {
		List<UnicornMarksDto> dtoList = dto.getIdentifiableMarks();
		return dtoList.stream().map(umDto -> {
			UnicornMarksEntity umEntity = UnicornMarksEntity.builder()
					.unicorn(entity)
					.side(umDto.getSide())
					.location(umDto.getLocation())
					.marks(umDto.getMarks())
					.color(umDto.getColor())
					.build();
			return umEntity;
		}).collect(Collectors.toList());
	}
	
	public UnicornEntity mapToEntity(final UnicornEntity entity, final UnicornDto dto) {
		entity.setName(dto.getName());
		entity.setEyeColor(dto.getEyeColor());
		entity.setHairColor(dto.getHairColor());
		entity.setHeight(dto.getHeight());
		entity.setHeightUnit(dto.getHeightUnit());
		entity.setHornColor(dto.getHornColor());
		entity.setHornLength(dto.getHornLength());
		entity.setWeight(dto.getWeight());
		entity.setWeightUnit(dto.getWeightUnit());
		if(Objects.nonNull(dto.getIdentifiableMarks()) && !dto.getIdentifiableMarks().isEmpty()) {
			entity.setIdentifiableMarks(mapToUnicornMarksEntity(dto, entity));
		}
		return entity;
	}
}
