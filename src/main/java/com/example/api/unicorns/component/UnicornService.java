package com.example.api.unicorns.component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.api.unicorns.bean.UnicornDto;
import com.example.api.unicorns.bean.UnicornEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnicornService {
	private UnicornMapper mapper;
	
	private UnicornRepository repository;
	
	public Integer createUnicorn(final UnicornDto dto) {
		UnicornEntity entity = mapper.mapToEntity(dto);
		entity = repository.save(entity);
		Long unicornId = entity.getUnicornId();
		return unicornId.intValue();
	}
	
	public List<UnicornDto> getAllUnicorn(){
		List<UnicornEntity> entities = repository.findAll();
		return entities.stream().map(entity -> mapper.mapToDto(entity)).collect(Collectors.toList());
	}
	
	public UnicornDto getUnicorn(final Long unicornId){
		UnicornEntity entity = repository.findById(unicornId).get();
		return mapper.mapToDto(entity);
	}
	
	public UnicornDto updateUnicorn(final Long unicornId, final UnicornDto dto) {
		UnicornEntity entity = repository.findById(unicornId).get();
		if(Objects.nonNull(entity)) {
			entity = repository.saveAndFlush(mapper.mapToEntity(entity, dto));	
		}else {
			entity = repository.save(mapper.mapToEntity(dto));
		}
		return mapper.mapToDto(entity);
	}
}
