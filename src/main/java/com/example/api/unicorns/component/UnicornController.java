package com.example.api.unicorns.component;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.unicorns.bean.UnicornDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/unicorns")
@RequiredArgsConstructor
public class UnicornController {
	private UnicornService service;
	
	@PostMapping()
	public Integer createUnicorn(@RequestBody final UnicornDto dto) {
		return service.createUnicorn(dto);
	}
	
	@GetMapping()
	public List<UnicornDto> getAllUnicorn(){
		return service.getAllUnicorn();
	}
	
	@GetMapping("/{unicornId}")
	public UnicornDto getUnicorn(@PathVariable final Long unicornId){
		return service.getUnicorn(unicornId);
	}
	
	@PutMapping("/{unicornId}")
	public UnicornDto updateUnicorn(@PathVariable final Long unicornId, @RequestBody final UnicornDto dto) {
		return service.updateUnicorn(unicornId, dto);
	}
}
