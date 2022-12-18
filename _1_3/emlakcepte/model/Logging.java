package emlakcepte.model;

public class Logging {
	private User user;
	private String province;
	private String district;
	
	
	public Logging(User user, String province, String district) {
		super();
		this.user = user;
		this.province = province;
		this.district = district;
	}

	public Logging() {

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}
