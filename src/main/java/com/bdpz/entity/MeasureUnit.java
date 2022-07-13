package com.bdpz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MeasureUnit {

	TEASPOON ("teaspoon", "tsp"),
	TABLESPOON ("tablespoon", "tbsp"),
	FLUID_OUNCE ("fluid ounce", "fl oz"),
	CUP ("cup", "c"),
	PINT ("pint", "pt"),
	QUART ("quart", "qt"),
	MILLILITER ("milliliter", "ml"),
	DECILITER ("deciliter", "dl"),
	LITER ("liter", "l"),
	POUND ("pound", "lb"),
	MILLIGRAM ("milligram", "mg"),
	GRAM ("gram", "g"),
	KILOGRAM ("kilogram", "kg"),
	MILLIMETER ("millimeter", "mm"),
	CENTIMETER ("centimeter", "cm"),
	METER ("meter", "m"),
	INCH ("inch", "in"),
	NONE ("", "");
	
	private String description;
	private String unit;
}
