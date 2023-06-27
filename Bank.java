package test3;

import java.util.Scanner;

//Bank class
public class Bank {
	private Manager manager;
	private User[] users;
	private int userCount;
	private Scanner scanner;

	public Bank() {
		manager = new Manager("mg123", "pw123");
		users = new User[3];
		userCount = 0;
		scanner = new Scanner(System.in);
	}

	public void run() {
		System.out.println("Welcome to the Gueye Bank!");

		while (true) {
			System.out.println("Choose an option:");
			System.out.println("1. Manager login");
			System.out.println("2. User login");
			System.out.println("3. Exit");

			int option = scanner.nextInt();

			if (option == 1) {
				managerLogin();
			} else if (option == 2) {
				userLogin();
			} else if (option == 3) {
				System.out.println("Thank you for using the Gueye Bank. Goodbye!");
				break;
			} else {
				System.out.println("Invalid option. Please choose again.");
			}
		}

		scanner.close();
	}

	private void managerLogin() {
		System.out.println("Enter manager ID:");
		String managerId = scanner.next();
		System.out.println("Enter manager password:");
		String managerPassword = scanner.next();

		if (manager.authenticate(managerId, managerPassword)) {
			while (true) {
				System.out.println("Manager Menu:");
				System.out.println("1. Add User");
				System.out.println("2. Modify User");
				System.out.println("3. Delete User");
				System.out.println("4. Search User by ID");
				System.out.println("5. List All Users");
				System.out.println("6. Exit");

				int managerOption = scanner.nextInt();

				if (managerOption == 1) {
					addUser();
				} else if (managerOption == 2) {
					modifyUser();
				} else if (managerOption == 3) {
					deleteUser();
				} else if (managerOption == 4) {
					searchUser();
				} else if (managerOption == 5) {
					listAllUsers();
				} else if (managerOption == 6) {
					System.out.println("Exiting manager menu.");
					break;
				} else {
					System.out.println("Invalid option. Please choose again.");
				}
			}
		} else {
			System.out.println("Invalid manager ID or password. Access denied.");
		}
	}

	private void addUser() {
		if (userCount < 3) {
			try {
				System.out.println("Enter user ID:");
				String userId = scanner.next();
				System.out.println("Enter user password:");
				String userPassword = scanner.next();
				System.out.println("Enter user name:");
				String userName = scanner.next();
				System.out.println("Enter user address:");
				String userAddress = scanner.next();
				System.out.println("Enter user account balance:");
				double userAccountBalance = scanner.nextDouble();
				System.out.println("Enter user account number:");
				String userAccountNumber = scanner.next();
				System.out.println("Enter user email:");
				String userEmail = scanner.next();
				System.out.println("Enter user phone number:");
				String userPhoneNumber = scanner.next();

				User newUser = new User(userId, userPassword, userName, userAddress, userAccountBalance,
						userAccountNumber, userEmail, userPhoneNumber);
				users[userCount] = newUser;
				userCount++;

				System.out.println("User added successfully!");
			} catch (Exception e) {
				System.out.println("Error: Invalid input. Please try again.");
				scanner.nextLine();
			}
		} else {
			System.out.println("Maximum number of users reached.");
		}
	}

	private void modifyUser() {
		System.out.println("Enter user ID to modify:");
		String userId = scanner.next();

		User user = findUserById(userId);

		if (user != null) {
			System.out.println("User found! Enter new user address:");
			String newAddress = scanner.next();
			System.out.println("Enter new user email:");
			String newEmail = scanner.next();
			System.out.println("Enter new user phone number:");
			String newPhoneNumber = scanner.next();

			user.setAddress(newAddress);
			user.setEmail(newEmail);
			user.setPhoneNumber(newPhoneNumber);

			System.out.println("User information modified successfully!");
		} else {
			System.out.println("User not found.");
		}
	}

	private void deleteUser() {
		System.out.println("Enter user ID to delete:");
		String userId = scanner.next();

		User user = findUserById(userId);

		if (user != null) {
			for (int i = 0; i < userCount; i++) {
				if (users[i].getId().equals(userId)) {
					// Shift the remaining elements to the left
					for (int j = i; j < userCount - 1; j++) {
						users[j] = users[j + 1];
					}

					users[userCount - 1] = null;
					userCount--;

					System.out.println("User deleted successfully!");
					return;
				}
			}
		} else {
			System.out.println("User not found.");
		}
	}

	private void searchUser() {
		System.out.println("Enter user ID to search:");
		String userId = scanner.next();

		User user = findUserById(userId);

		if (user != null) {
			System.out.println("User found!");
			user.displayPersonalInformation();
		} else {
			System.out.println("User not found.");
		}
	}

	private void listAllUsers() {
		System.out.println("User List:");

		for (int i = 0; i < userCount; i++) {
			User user = users[i];
			System.out.println("User ID: " + user.getId());
			System.out.println("Name: " + user.getName());
			System.out.println("Account Number: " + user.getAccountNumber());
			System.out.println("-----------------------------");
		}
	}

	private User findUserById(String userId) {
		for (int i = 0; i < userCount; i++) {
			if (users[i].getId().equals(userId)) {
				return users[i];
			}
		}

		return null;
	}

	private void userLogin() {
		System.out.println("Enter user ID:");
		String userId = scanner.next();
		System.out.println("Enter user password:");
		String userPassword = scanner.next();

		boolean userFound = false;
		User loggedInUser = null;

		for (int i = 0; i < userCount; i++) {
			if (users[i].authenticate(userId, userPassword)) {
				userFound = true;
				loggedInUser = users[i];
				break;
			}
		}

		if (userFound) {
			while (true) {
				System.out.println("User Menu:");
				System.out.println("1. Display Account Balance");
				System.out.println("2. Display Personal Information");
				System.out.println("3. Exit");

				int userOption = scanner.nextInt();

				if (userOption == 1) {
					System.out.println("Account Balance: " + loggedInUser.getAccountBalance());
				} else if (userOption == 2) {
					loggedInUser.displayPersonalInformation();
				} else if (userOption == 3) {
					System.out.println("Exiting user menu.");
					break;
				} else {
					System.out.println("Invalid option. Please choose again.");
				}
			}
		} else {
			System.out.println("Invalid user ID or password. Access denied.");
		}
	}
}