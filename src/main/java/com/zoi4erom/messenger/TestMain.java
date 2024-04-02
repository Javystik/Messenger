package com.zoi4erom.messenger;

import com.zoi4erom.messenger.dto.UserReadDto;
import com.zoi4erom.messenger.mapper.UserReadMapper;
import com.zoi4erom.messenger.repository.impl.UserRepoImpl;
import com.zoi4erom.messenger.service.UserService;
import com.zoi4erom.messenger.util.HibernateUtil;
import java.lang.reflect.Proxy;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestMain {
	public static void main(String[] args) {
		try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
			var session = (Session) Proxy.newProxyInstance(
			    SessionFactory.class.getClassLoader(), new Class[]{Session.class},
			    ((proxy, method, args1) -> method.invoke(sessionFactory.getCurrentSession(), args1)));

			session.beginTransaction();

			UserRepoImpl userRepo = new UserRepoImpl(session);
			UserReadMapper userReadMapper = new UserReadMapper();

			UserService userService = new UserService(userRepo, userReadMapper);

			var test = userService.getUserByLogin("Test");


			session.getTransaction().commit();

			System.out.println(test);
		}

	}
}
