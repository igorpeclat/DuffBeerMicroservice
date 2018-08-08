package com.duff.client.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Beer.
 */
@Entity
public class Beer {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	/** The style. */
	private String style;
	
	/** The min temperature. */
	private Integer minTemperature;
	
	/** The max temperature. */
	private Integer maxTemperature;
	
	/** The average temperature. */
	@JsonIgnore
	@Transient
	private Integer averageTemperature;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the style.
	 *
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * Sets the style.
	 *
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * Gets the min temperature.
	 *
	 * @return the minTemperature
	 */
	public Integer getMinTemperature() {
		return minTemperature;
	}

	/**
	 * Sets the min temperature.
	 *
	 * @param minTemperature the minTemperature to set
	 */
	public void setMinTemperature(Integer minTemperature) {
		this.minTemperature = minTemperature;
	}

	/**
	 * Gets the max temperature.
	 *
	 * @return the maxTemperature
	 */
	public Integer getMaxTemperature() {
		return maxTemperature;
	}

	/**
	 * Sets the max temperature.
	 *
	 * @param maxTemperature the maxTemperature to set
	 */
	public void setMaxTemperature(Integer maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	/**
	 * Gets the average temperature.
	 *
	 * @return the averageTemperature
	 */
	public Integer getAverageTemperature() {
		return averageTemperature;
	}

	/**
	 * Sets the average temperature.
	 *
	 * @param averageTemperature the averageTemperature to set
	 */
	public void setAverageTemperature(Integer averageTemperature) {
		this.averageTemperature = averageTemperature;
	}
	
	
	
	
}