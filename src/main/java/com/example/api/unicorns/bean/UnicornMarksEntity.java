package com.example.api.unicorns.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "unicorn_marks")
public class UnicornMarksEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "unicorn_id")
	private UnicornEntity unicorn;
	
	@Column(name = "side")
	private String side;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "marks")
	private String marks;
	
	@Column(name = "color")
	private String color;
	
}
