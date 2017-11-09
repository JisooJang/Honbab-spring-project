package org.springframework.samples.honbab.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.honbab.domain.Account;


public interface AccountDao {

  Account getAccount(String user_id) throws DataAccessException;

  Account getAccount(String username, String password) throws DataAccessException;

  void insertAccount(Account account) throws DataAccessException;

  void updateAccount(Account account) throws DataAccessException;

  List<String> getUsernameList() throws DataAccessException;

  void updateImageOfAccount(Account account);

  void updateRestIDOfAccount(int rest_id, String user_id);
}
