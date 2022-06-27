package com.example.api.unicorns.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "unicorn")
public class UnicornEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unicorn_id")
    private Long unicornId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "hair_color")
	private String hairColor;
	
	@Column(name = "horn_length")
	private int hornLength;
	
	@Column(name = "horn_color")
	private String hornColor;
	
	@Column(name = "eye_color")
	private String eyeColor;
	
	@Column(name = "height")
	private int height;
	
	@Column(name = "height_unit")
	private String heightUnit;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name = "weight_unit")
	private String weightUnit;
	
	@OneToMany(mappedBy = "unicorn")
	@Cascade(CascadeType.ALL)
	private List<UnicornMarksEntity> identifiableMarks;
}
