package rmi;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	public Hotel(String where, int rooms, int roomcap) {
		this.where = where;
		this.availablerooms = rooms;
		this.roomcapacity = roomcap;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvailablerooms() {
		return availablerooms;
	}

	public void setAvailablerooms(int availablerooms) {
		this.availablerooms = availablerooms;
	}

	public int getRoomcapacity() {
		return roomcapacity;
	}

	public void setRoomcapacity(int roomcapacity) {
		this.roomcapacity = roomcapacity;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	String where;
	String name;

	int availablerooms;
	int roomcapacity;

	List<Room> rooms = new ArrayList<>();


	
}
