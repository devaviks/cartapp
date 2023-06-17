package model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
abstract public class CommonEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@JsonIgnore
	@Column(name = "status", length = 2)
	int status = 1;

	@JsonIgnore
	@Column(name = "createdDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date();

	@JsonIgnore
	@Column(name = "modifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@JsonIgnore
	@Column(name = "deviceType")
	private String deviceType;

	@JsonIgnore
	@Column(name = "macAddress")
	private String macAddress;

	public CommonEntity(Long id, int status, Date createDate, Date modifiedDate, String deviceType, String macAddress) {
		super();
		this.id = id;
		this.status = status;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.deviceType = deviceType;
		this.macAddress = macAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public CommonEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
