package services;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.staff;
import helper.EncryptDecryptPass;

public class staffService {
	private EncryptDecryptPass encryptDecryptPass;

	public staffService() {
		encryptDecryptPass = new EncryptDecryptPass();
	}
	
}
