package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Flight extends UnicastRemoteObject {

	String from = "";
	String to = "";

	long fftimestamp;
	int price;
	int seats;


	public Flight(int seats, String to, String from, long fftimestamp, int price) throws RemoteException {
		this.to = to;
		this.from = from;
		this.fftimestamp = fftimestamp;
		this.price = price;
		this.seats = seats;

	}
	/* (non-Javadoc)
	 * @see rmi.FlightI#getPrice()
	 */
	
	public int getPrice() {
		return price;
	}
	
	/* (non-Javadoc)
	 * @see rmi.FlightI#setPrice(int)
	 */
	
	public void setPrice(int price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see rmi.FlightI#getFrom()
	 */
	
	public String getFrom() {
		return from;
	}

	/* (non-Javadoc)
	 * @see rmi.FlightI#setFrom(java.lang.String)
	 */
	
	public void setFrom(String from) {
		this.from = from;
	}

	/* (non-Javadoc)
	 * @see rmi.FlightI#getTo()
	 */
	
	public String getTo() {
		return to;
	}

	/* (non-Javadoc)
	 * @see rmi.FlightI#setTo(java.lang.String)
	 */
	
	public void setTo(String to) {
		this.to = to;
	}


	/* (non-Javadoc)
	 * @see rmi.FlightI#getFftimestamp()
	 */
	
	public long getFftimestamp() {
		return fftimestamp;
	}

	/* (non-Javadoc)
	 * @see rmi.FlightI#setFftimestamp(long)
	 */
	
	public void setFftimestamp(long fftimestamp) {
		this.fftimestamp = fftimestamp;
	}


	/* (non-Javadoc)
	 * @see rmi.FlightI#getSeats()
	 */
	
	public int getSeats() {
		return seats;
	}
	/* (non-Javadoc)
	 * @see rmi.FlightI#setSeats(int)
	 */
	
	public void setSeats(int seats) {
		this.seats = seats;
	}
}
