package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {
	/**
	 * Registers a flight interest
	 * 
	 * @param a
	 *            Server remote object
	 * @param to
	 *            destination
	 * @param from
	 *            home
	 * @param maxprice
	 *            max package price
	 * @param client
	 *            client name-service reference
	 * @return
	 * @throws RemoteException
	 */

	public boolean registerInterestFlight(Server a, String to, String from, int maxprice, String client)
			throws RemoteException;

	public void purchaseFlight() throws RemoteException;

	/**
	 * Prints all flights available on a server
	 * 
	 * @param a
	 *            server remote object
	 * @throws RemoteException
	 */
	public void lookUpFlights(Server a) throws RemoteException;

	/**
	 * purchase seats on a flight
	 * 
	 * @param a
	 *            server remote object
	 * @param id
	 *            flight id
	 * @param seats
	 *            seats on the flight
	 * @throws RemoteException
	 */
	public void buyFlight(Server a, int id, int seats) throws RemoteException;

	/**
	 * purchases a package
	 * 
	 * @param a
	 *            server remote object
	 * @param flightid
	 * @param hotelid
	 * @param seats
	 *            how many people
	 * @param startdate
	 *            hotel check in date
	 * @param enddate
	 *            hotel checkout date
	 * @throws RemoteException
	 */
	public void buyPackage(Server a, int flightid, int hotelid, int seats, long startdate, long enddate)
			throws RemoteException;

	/**
	 * Prints all flights that match the given parameters
	 * 
	 * @param a
	 *            Server remote object
	 * @param to
	 * @param from
	 * @param fftimestamp
	 *            flight start time
	 * @param sftimestamp
	 *            second flight start time
	 * @param seats
	 * @throws RemoteException
	 */

	public void lookUpFlights(Server a, String to, String from, long fftimestamp, long sftimestamp, int seats)
			throws RemoteException;

	/**
	 * Prints all the hotels on the server
	 * 
	 * @param a
	 *            Server remote object
	 * @throws RemoteException
	 */
	void lookUpHotels(Server a) throws RemoteException;

	/**
	 * This function is called by a server method, used to print a notification
	 * on the client's console
	 * 
	 * @param s
	 *            Server remote object
	 * @throws RemoteException
	 */

	void notifyEvent(String s) throws RemoteException;

	/**
	 * Purchases rooms on a hotel
	 * 
	 * @param a
	 *            server remote objct
	 * @param id
	 *            hotel id
	 * @param seats
	 *            number of people
	 * @param startdate
	 *            check in
	 * @param enddate
	 *            check ou
	 * @throws RemoteException
	 */
	void buyRooms(Server a, int id, int seats, long startdate, long enddate) throws RemoteException;

	/**
	 * Registers interest in rooms
	 * 
	 * @param a
	 *            Server remote object
	 * @param where
	 *            hotel location
	 * @param seats
	 *            how many people
	 * @param maxprice
	 *            max price
	 * @param client
	 *            client name-service identification
	 * @return
	 * @throws RemoteException
	 */
	boolean registerInterestRooms(Server a, String where, int seats, int maxprice, String client)
			throws RemoteException;

	/**
	 * Removes a flight interest
	 * 
	 * @param a
	 *            Server remote obj
	 * @param to
	 *            dest
	 * @param from
	 *            home
	 * @param maxprice
	 *            maxprice
	 * @param client
	 *            name-service id
	 * @return
	 * @throws RemoteException
	 */
	boolean removeFlightIntl(Server a, String to, String from, int maxprice, String client) throws RemoteException;

	/**
	 * Remove a room interest
	 * 
	 * @param a
	 *            Server remote obj
	 * @param where
	 *            hotel name
	 * @param seats
	 *            how many people
	 * @param maxprice
	 *            max price
	 * @param client
	 *            client name-service id
	 * @return
	 * @throws RemoteException
	 */
	boolean removeRoomsIntl(Server a, String where, int seats, int maxprice, String client) throws RemoteException;

	/**
	 * Registers a package interest
	 * 
	 * @param a
	 *            server remote object
	 * @param to
	 *            destination
	 * @param from
	 *            home
	 * @param where
	 *            hotel location
	 * @param maxprice
	 * @param seats
	 * @param client
	 *            client name-service id
	 * @return
	 * @throws RemoteException
	 */
	boolean registerInterestPackage(Server a, String to, String from, String where, int maxprice, int seats,
			String client) throws RemoteException;

	/**
	 * removes a package interest
	 * 
	 * @param a
	 *            server remote object
	 * @param to
	 *            destination
	 * @param from
	 *            home
	 * @param where
	 *            hotel location
	 * @param maxprice
	 * @param seats
	 * @param client
	 *            client name-service id
	 * @return
	 * @throws RemoteException
	 */
	boolean removeInterestPackage(Server a, String to, String from, String where, int maxprice, int seats,
			String client) throws RemoteException;

	/** 
	 * Prints all packages listed on a server
	 * @param a
	 * @return
	 * @throws RemoteException
	 */
	boolean lookUpPackages(Server a) throws RemoteException;

}
