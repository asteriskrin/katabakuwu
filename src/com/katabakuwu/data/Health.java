package com.katabakuwu.data;

/**
 * Health class.
 * @author Ryan Garnet Andrianto
 */
public class Health {
	private float value;
	
	/**
	 * Constructor
	 */
	public Health() {
		this.value = (float) 100.0;
	}
	
	/**
	 * Get health.
	 * 
	 * @return Health
	 */
	public float getValue() {
		return this.value;
	}
	
	/**
	 * Set health.
	 * 
	 * @param value Health
	 */
	public void setValue(float value) {
		this.value = value;
	}
}
