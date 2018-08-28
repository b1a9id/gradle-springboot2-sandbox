package com.example.sandbox.entity;

import com.example.sandbox.model.Gender;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Brand implements Serializable {

	private Integer id;

	private String name;

	private Gender gender;
}
