package com.nerv828.service.group;

import com.nerv828.entity.Group;
import com.nerv828.entity.User;
import com.nerv828.repository.GroupDao;
import com.nerv828.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.utils.DateProvider;

import java.util.List;
import java.util.Set;

/**
 * 群组管理类.
 * 
 * @author nerv828
 */
// Spring Service Bean的标识.
@Component
@Transactional
public class GroupService {


	private static Logger logger = LoggerFactory.getLogger(GroupService.class);
    @Autowired
	private UserDao userDao;
    @Autowired
	private  GroupDao groupDao;
	private DateProvider dateProvider = DateProvider.DEFAULT;

	public List<User> getAllUser() {
		return (List<User>) userDao.findAll();
	}

	public User getUser(Long id) {
		return userDao.findOne(id);
	}

	public Group findGroupByName(String name) {
		return groupDao.findByName(name);
	}

    /**
     * 新建群组
     * @param group
     */
	public void createGroup(Group group) {

		group.setCreateDate(dateProvider.getDate());

		groupDao.save(group);
	}

	public void addUsers2Group(Group group,Set<User> users) {

        group.setUsers(users);

		groupDao.save(group);

	}

	public void deleteGroup(Long id) {

		groupDao.delete(id);

	}






}
