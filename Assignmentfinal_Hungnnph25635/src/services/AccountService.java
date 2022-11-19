package services;

import Repositories.RepositoryAccount;
import models.Account;

public class AccountService {

    private Repositories.RepositoryAccount repositoryAccount;

    public AccountService() {
        this.repositoryAccount = new RepositoryAccount();
    }

    public Account login(String username, String password) {
        return this.repositoryAccount.login(username, password);
    }
}
