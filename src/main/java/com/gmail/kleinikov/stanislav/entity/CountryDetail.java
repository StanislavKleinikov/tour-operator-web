package com.gmail.kleinikov.stanislav.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country_data")
public class CountryDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "description")
	private String description;

	@Column(name = "pic")
	private String pic;

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<Resort> resorts;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public List<Resort> getResorts() {
		return resorts;
	}

	public void setResorts(List<Resort> resorts) {
		this.resorts = resorts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + ((resorts == null) ? 0 : resorts.hashCode());
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
		CountryDetail other = (CountryDetail) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (resorts == null) {
			if (other.resorts != null)
				return false;
		} else if (!resorts.equals(other.resorts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CountryDetail [id=" + id + ", description=" + description + ", pic=" + pic + ", resorts=" + resorts
				+ "]";
	}

}
