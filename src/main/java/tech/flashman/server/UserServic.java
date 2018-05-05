package tech.flashman.server;

import org.springframework.stereotype.Service;

import tech.flashman.entity.User;

@Service
public class UserServic {

	int deleteByPrimaryKey(Long userid) {

		return 0;
	}

	int insert(User record) {

		return 0;
	}

	int insertSelective(User record) {

		return 0;
	}

	User selectByPrimaryKey(Long userid) {

		return new User();
	}

	int updateByPrimaryKeySelective(User record) {
		return 0;
	}

	int updateByPrimaryKey(User record) {

		return 0;
	}
}
