package com.gmail.kleinikov.stanislav.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Simple JavaBean domain object that represents a {@code TourDetail}. This
 * class contains additional information about {@link Tour}.
 *
 * @author Stanislav Kleinikov
 * @version 1.0
 */
@Entity
@Table(name = "tour_data")
public class TourDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "departure")
	private Departure departure;

	@ManyToOne
	@JoinColumn(name = "nutrition")
	private Nutrition nutrition;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Calendar startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Calendar endDate;

	public long getTourId() {
		return id;
	}

	public void setTourId(Long id) {
		this.id = id;
	}

	public Departure getDeparture() {
		return departure;
	}

	public void setDeparture(Departure departure) {
		this.departure = departure;
	}

	public Nutrition getNutrition() {
		return nutrition;
	}

	public void setNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nutrition == null) ? 0 : nutrition.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TourDetail other = (TourDetail) obj;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nutrition == null) {
			if (other.nutrition != null)
				return false;
		} else if (!nutrition.equals(other.nutrition))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TourDetail [id=" + id + ", departure=" + departure.getTown() + ", nutrition=" + nutrition.getName()
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
