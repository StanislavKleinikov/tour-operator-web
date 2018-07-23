package com.gmail.kleinikov.stanislav.service;

/**
 * Service for Security.
 *
 * @author Stanislav Kleinikov
 * @version 1.0
 */

public interface SecurityService {

	String findLoggedInUsername();

	void autoLogin(String username, String password);
}
