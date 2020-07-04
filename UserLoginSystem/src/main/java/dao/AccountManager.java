package dao;

import java.util.*;

public class AccountManager {

    private final HashMap<String, String> accounts;

    public AccountManager() {
        accounts = new HashMap<>();
        createNewAccount("Patrick", "1234");
        createNewAccount("Molly", "FloPup");
    }

    public boolean accountExists(String userName) {
        return accounts.containsKey(userName);
    }

    public boolean isCorrectPassword(String userName, String password) {
        if (accountExists(userName)) {
            return password.equals(accounts.get(userName));
        }
        return false;
    }

    public void createNewAccount(String userName, String password) {
        if (!accountExists(userName)) {
            accounts.put(userName, password);
        }
    }

}
