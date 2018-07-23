package com.gmail.kleinikov.stanislav.entity;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_CATEGORY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_COUNTRY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_DEPARTURE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_ENDDATE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_MAXDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_MINDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_NUTRITION;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_STARTDATE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_SQL_STATEMENT_CATEGORY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_SQL_STATEMENT_COUNTRY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_SQL_STATEMENT_DEPARTURE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_SQL_STATEMENT_ENDDATE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_SQL_STATEMENT_MAXDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_SQL_STATEMENT_MINDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_SQL_STATEMENT_NUTRITION;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_SQL_STATEMENT_STARTDATE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_CATEGORY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_COUNTRY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_DEPARTURE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_ENDDATE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_MAXDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_MINDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_NUTRITION;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_STARTDATE;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

@FilterDefs({
		@FilterDef(name = FILTER_TOUR_DEPARTURE, parameters = {
				@ParamDef(name = FILTER_PARAM_DEPARTURE, type = "java.lang.String") }),
		@FilterDef(name = FILTER_TOUR_COUNTRY, parameters = {
				@ParamDef(name = FILTER_PARAM_COUNTRY, type = "java.lang.String") }),
		@FilterDef(name = FILTER_TOUR_STARTDATE, parameters = {
				@ParamDef(name = FILTER_PARAM_STARTDATE, type = "java.util.Date") }),
		@FilterDef(name = FILTER_TOUR_ENDDATE, parameters = {
				@ParamDef(name = FILTER_PARAM_ENDDATE, type = "java.util.Date") }),
		@FilterDef(name = FILTER_TOUR_NUTRITION, parameters = {
				@ParamDef(name = FILTER_PARAM_NUTRITION, type = "java.lang.String") }),
		@FilterDef(name = FILTER_TOUR_CATEGORY, parameters = {
				@ParamDef(name = FILTER_PARAM_CATEGORY, type = "java.lang.String") }),
		@FilterDef(name = FILTER_TOUR_MINDAY, parameters = {
				@ParamDef(name = FILTER_PARAM_MINDAY, type = "java.lang.Integer") }),
		@FilterDef(name = FILTER_TOUR_MAXDAY, parameters = {
				@ParamDef(name = FILTER_PARAM_MAXDAY, type = "java.lang.Integer") }) })
@Filters({ @Filter(name = FILTER_TOUR_DEPARTURE, condition = FILTER_SQL_STATEMENT_DEPARTURE),
		@Filter(name = FILTER_TOUR_COUNTRY, condition = FILTER_SQL_STATEMENT_COUNTRY),
		@Filter(name = FILTER_TOUR_STARTDATE, condition = FILTER_SQL_STATEMENT_STARTDATE),
		@Filter(name = FILTER_TOUR_ENDDATE, condition = FILTER_SQL_STATEMENT_ENDDATE),
		@Filter(name = FILTER_TOUR_NUTRITION, condition = FILTER_SQL_STATEMENT_NUTRITION),
		@Filter(name = FILTER_TOUR_CATEGORY, condition = FILTER_SQL_STATEMENT_CATEGORY),
		@Filter(name = FILTER_TOUR_MINDAY, condition = FILTER_SQL_STATEMENT_MINDAY),
		@Filter(name = FILTER_TOUR_MAXDAY, condition = FILTER_SQL_STATEMENT_MAXDAY) })

@Entity
@Table(name = "tour")
public class Tour implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "status")
	private Status status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country")
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resort")
	private Resort resort;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel")
	private Hotel hotel;

	@Column(name = "price")
	private BigDecimal price;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "tour_detail")
	private TourDetail tourDetail;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Resort getResort() {
		return resort;
	}

	public void setResort(Resort resort) {
		this.resort = resort;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public TourDetail getTourDetail() {
		return tourDetail;
	}

	public void setTourDetail(TourDetail tourDetail) {
		this.tourDetail = tourDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((resort == null) ? 0 : resort.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tourDetail == null) ? 0 : tourDetail.hashCode());
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
		Tour other = (Tour) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (resort == null) {
			if (other.resort != null)
				return false;
		} else if (!resort.equals(other.resort))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tourDetail == null) {
			if (other.tourDetail != null)
				return false;
		} else if (!tourDetail.equals(other.tourDetail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tour [id=" + id + ", status=" + status.getName() + ", country=" + country.getName() + ", resort="
				+ resort.getName() + ", hotel=" + hotel.getName() + ", price=" + price + ", tourDetail=" + tourDetail
				+ "]";
	}

}
