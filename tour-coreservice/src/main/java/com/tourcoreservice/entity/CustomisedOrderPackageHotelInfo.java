package com.tourcoreservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class CustomisedOrderPackageHotelInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	private String heading;
	
	private String hotelName;
	private String hotelPlace;
	private String roomType;
	private Date roomCheckIn;
	private String roomCheckinStartTime;
	private Date roomCheckoutDate;
	private String roomCheckoutTime;
	private String hotelNote;
	private String bookingMembersRoom;
	@Lob
	private String hotelImageurl1;
	@Lob
	private String hotelImageurl2;
	@Lob
	private String hotelImageurl3;
	private int star;
	private int reviews;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelPlace() {
		return hotelPlace;
	}
	public void setHotelPlace(String hotelPlace) {
		this.hotelPlace = hotelPlace;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Date getRoomCheckIn() {
		return roomCheckIn;
	}
	public void setRoomCheckIn(Date roomCheckIn) {
		this.roomCheckIn = roomCheckIn;
	}
	public String getRoomCheckinStartTime() {
		return roomCheckinStartTime;
	}
	public void setRoomCheckinStartTime(String roomCheckinStartTime) {
		this.roomCheckinStartTime = roomCheckinStartTime;
	}
	public Date getRoomCheckoutDate() {
		return roomCheckoutDate;
	}
	public void setRoomCheckoutDate(Date roomCheckoutDate) {
		this.roomCheckoutDate = roomCheckoutDate;
	}
	public String getRoomCheckoutTime() {
		return roomCheckoutTime;
	}
	public void setRoomCheckoutTime(String roomCheckoutTime) {
		this.roomCheckoutTime = roomCheckoutTime;
	}
	public String getHotelNote() {
		return hotelNote;
	}
	public void setHotelNote(String hotelNote) {
		this.hotelNote = hotelNote;
	}
	public String getBookingMembersRoom() {
		return bookingMembersRoom;
	}
	public void setBookingMembersRoom(String bookingMembersRoom) {
		this.bookingMembersRoom = bookingMembersRoom;
	}
	public String getHotelImageurl1() {
		return hotelImageurl1;
	}
	public void setHotelImageurl1(String hotelImageurl1) {
		this.hotelImageurl1 = hotelImageurl1;
	}
	public String getHotelImageurl2() {
		return hotelImageurl2;
	}
	public void setHotelImageurl2(String hotelImageurl2) {
		this.hotelImageurl2 = hotelImageurl2;
	}
	public String getHotelImageurl3() {
		return hotelImageurl3;
	}
	public void setHotelImageurl3(String hotelImageurl3) {
		this.hotelImageurl3 = hotelImageurl3;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	
	
	
	
}
