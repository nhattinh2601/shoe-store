package vn.iotstar.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Slides database table.
 * 
 */
@Entity
@Table(name="Slides")
@NamedQuery(name="Slide.findAll", query="SELECT s FROM Slide s")
public class Slide implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slideid;

	private String slidedescription;

	private String slideimages;

	private String slidelink;

	private String slidename;

	private int slidetype;

	private int status;

	public Slide() {
	}

	public int getSlideid() {
		return this.slideid;
	}

	public void setSlideid(int slideid) {
		this.slideid = slideid;
	}

	public String getSlidedescription() {
		return this.slidedescription;
	}

	public void setSlidedescription(String slidedescription) {
		this.slidedescription = slidedescription;
	}

	public String getSlideimages() {
		return this.slideimages;
	}

	public void setSlideimages(String slideimages) {
		this.slideimages = slideimages;
	}

	public String getSlidelink() {
		return this.slidelink;
	}

	public void setSlidelink(String slidelink) {
		this.slidelink = slidelink;
	}

	public String getSlidename() {
		return this.slidename;
	}

	public void setSlidename(String slidename) {
		this.slidename = slidename;
	}

	public int getSlidetype() {
		return this.slidetype;
	}

	public void setSlidetype(int slidetype) {
		this.slidetype = slidetype;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}