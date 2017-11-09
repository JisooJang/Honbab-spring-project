package org.springframework.samples.honbab.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.honbab.dao.AccountDao;
import org.springframework.samples.honbab.dao.mybatis.mapper.AccountMapper;
import org.springframework.samples.honbab.domain.Account;
import org.springframework.stereotype.Repository;

/**
 * @author Juergen Hoeller
 * @author Colin Sampaleanu
 */
@Repository
public class MybatisAccountDao implements AccountDao {

	@Autowired
	private AccountMapper accountMapper;
	
	public Account getAccount(String user_id) throws DataAccessException {
		return accountMapper.getAccountByUserID(user_id);
	}

	public Account getAccount(String username, String password) 
			throws DataAccessException {
		return accountMapper.getAccountByUsernameAndPassword(username, password);
	}

	public void insertAccount(Account account) throws DataAccessException {
		accountMapper.insertAccount(account);
		//accountMapper.insertProfile(account);
		//accountMapper.insertSignon(account);
	}

	public void updateAccount(Account account) throws DataAccessException {
		accountMapper.updateAccount(account);
		
		
	}
 
	public List<String> getUsernameList() throws DataAccessException {
		return accountMapper.getUsernameList();
	}
	
	@Override
	public void updateImageOfAccount(Account account) {
		// TODO Auto-generated method stub
		accountMapper.updateImageOfAccount(account);
	}

	@Override
	public void updateRestIDOfAccount(int rest_id, String user_id) {
		// TODO Auto-generated method stub
		accountMapper.updateRestIDOfAccount(rest_id, user_id);
	}
}
