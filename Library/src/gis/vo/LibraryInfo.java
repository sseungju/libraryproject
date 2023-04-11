package gis.vo;

public class LibraryInfo {
	public LibraryInfo() {
		super();
	}
	public LibraryInfo(String name, String region, String address, String phone, String closed, String libraryone, int borrowbook, int borrowdate, String type, int seat) {
		super();
		this.name = name;
		this.region = region;
		this.address = address;
		this.phone = phone;
		this.closed = closed;
		this.libraryone = libraryone;
		this.borrowbook = borrowbook;
		this.borrowdate = borrowdate;
		this.type = type;
		this.seat = seat;
	}
	private String name;
	private String region;
	private String address;
	private String phone;
	private String closed;
	private String libraryone;
	private int borrowbook;
	public int borrowdate;
	public String type;
	public int seat;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getClosed() {
		return closed;
	}
	public void setClosed(String closed) {
		this.closed = closed;
	}
	public String getLibraryone() {
		return libraryone;
	}
	public void setLibraryone(String libraryone) {
		this.libraryone = libraryone;
	}
	public int getBorrowbook() {
		return borrowbook;
	}
	public void setBorrowbook(int borrowbook) {
		this.borrowbook = borrowbook;
	}
	public int getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(int borrowdate) {
		this.borrowdate = borrowdate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
}
