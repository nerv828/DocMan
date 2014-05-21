package com.nerv828.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.nerv828.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
