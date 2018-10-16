package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements Client {

	protected ClientImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 /**
  * Lists every flight (represented by a string of data) registered on a server
  */
	@Override
	public void lookUpFlights(Server a) throws RemoteException {
		System.out.println("Looking up flights...");

		for (String s : a.getFlights()) {
			System.out.println(s);
		}

	}
/**
 * Lists every flight (represented by a string of data) registered on a server that meets the input data
 * 
 */
	@Override
	public void lookUpFlights(Server a, String to, String from, long fftimestamp, long sftimestamp, int seats)
			throws RemoteException {
		System.out.println("Looking up flights...");

		for (String s : a.getFlights()) {
			System.out.println(s);
		}

	}
	/**
	 * Lists every hotel (represented by a string of data) registered on a server 
	 * 
	 */
	@Override
	public void lookUpHotels(Server a) throws RemoteException {
		System.out.println("Looking up hotels...");
		for (String s : a.getHotels()) {
			System.out.println(s);
		}
	}
	
	/**
	 * Registers a purchase of seats on a flight
	 * 
	 */

	@Override
	public void buyFlight(Server a, int id, int seats) throws RemoteException {
		boolean t = a.sellFlight(id, seats);
		if (t == true)
			System.out.println("Bought " + seats + " at flight " + id);
		else
			System.out.println("Failed to buy " + seats + " at flight " + id);

	}

	@Override
	public void buyRooms(Server a, int id, int seats, long startdate, long enddate) throws RemoteException {
		boolean t = a.sellRooms(id, seats, startdate, enddate);
		if (t == true)
			System.out.println("Bought " + seats + " beds at hotel " + id);
		else
			System.out.println("Failed to buy " + seats + " beds at hotel " + id);

	}

	@Override
	public boolean registerInterestFlight(Server a, String to, String from, int maxprice, String client)
			throws RemoteException {
		System.out.println("Registering interest...");

		return a.registerFlightIntl(to, from, maxprice, client);

	}

	@Override
	public boolean registerInterestRooms(Server a, String where, int seats, int maxprice, String client)
			throws RemoteException {
		System.out.println("Registering interest...");

		return a.registerRoomsIntl(where, seats, maxprice, client);

	}

	@Override
	public void purchaseFlight() throws RemoteException {
		// TODO Auto-generated method stub

	}

	public void notifyEvent(String s) throws RemoteException {
		System.out.println("Notified of event: " + s);
	}

	@Override
	public void buyPackage(Server a, int flightid, int hotelid, int seats, long startdate, long enddate)
			throws RemoteException {
		System.out.println("Buying package...");

		buyFlight(a, flightid, seats);
		buyRooms(a, hotelid, seats, startdate, enddate);

	}

	@Override
	public boolean removeFlightIntl(Server a, String to, String from, int maxprice, String client)
			throws RemoteException {
		System.out.println("Removed Flight interest");

		a.removeFlightIntl(to, from, maxprice, client);	
		return false;
	}

	@Override
	public boolean removeRoomsIntl(Server a, String where, int seats, int maxprice, String client)
			throws RemoteException {
		System.out.println("Removed Room interest");

		a.removeRoomsIntl(where, seats, maxprice, client);
		return false;
	}

}
