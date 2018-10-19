package rmi;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {

		String clientname = "name";
		Client client = null;
		try {
			client = new ClientImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Registry refSN;
		try {
			refSN = LocateRegistry.getRegistry(5005);
			System.out.println("got ref");
			for (String s : refSN.list()) {
				System.out.println(s + " l");
			}

			Server a = (Server) refSN.lookup("server");
			refSN.rebind(clientname, client);
			System.out.println("b");

			client.lookUpFlights(a);
			client.buyFlight(a, 1, 51);
			client.lookUpFlights(a);
			client.lookUpHotels(a);
			client.registerInterestFlight(a, "sp", "cwb", 10, "name");

			while (true) {
				System.out.println("Waiting for client input");
				Scanner scanner = new Scanner(System.in);
				String input = scanner.nextLine();
				if (input.contains("help")) {
					System.out.println("lookupallflights");
					System.out.println("buyflight-id-seats");
					System.out.println("lookupallhotels");
					System.out.println("arif-to-from-price-clientname");
					System.out.println("arih-where-seats-price-clientname");
					System.out.println("drif-to-from-price-clientname");
					System.out.println("drih-where-seats-price-clientname");
					System.out.println("apck-to-from-where-maxprice-seats-clientname");
					System.out.println("rpck-to-from-where-maxprice-seats-clientname");

				}
				if (input.contains("lookupallflights")) {
					client.lookUpFlights(a);
				}
				if (input.contains("buyflight-")) {
					client.buyFlight(a, Integer.valueOf(input.split("-")[1]), Integer.valueOf(input.split("-")[2]));
				}
				if (input.contains("lookupallhotels")) {
					client.lookUpHotels(a);
				}
				if (input.contains("arif")) {
					client.registerInterestFlight(a, input.split("-")[1], input.split("-")[2],
							Integer.valueOf(input.split("-")[3]), clientname);
				}
				if (input.contains("arih")) {
					client.registerInterestRooms(a, input.split("-")[1], Integer.valueOf(input.split("-")[2]),
							Integer.valueOf(input.split("-")[3]), clientname);
				}
				if (input.contains("drif")) {
					client.removeFlightIntl(a, input.split("-")[1], input.split("-")[2],
							Integer.valueOf(input.split("-")[3]), clientname);
				}
				if (input.contains("drih")) {
					client.removeRoomsIntl(a, input.split("-")[1], Integer.valueOf(input.split("-")[2]),
							Integer.valueOf(input.split("-")[3]), clientname);
				}
				if (input.contains("apck")) {
					client.registerInterestPackage(a, input.split("-")[1], input.split("-")[2], input.split("-")[3],
							Integer.valueOf(input.split("-")[4]), Integer.valueOf(input.split("-")[5]), clientname);
				}
				if (input.contains("rpck")) {
					client.removeInterestPackage(a, input.split("-")[1], input.split("-")[2], input.split("-")[3],
							Integer.valueOf(input.split("-")[4]), Integer.valueOf(input.split("-")[5]), clientname);
				}

			}
		} catch (RemoteException | NotBoundException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
