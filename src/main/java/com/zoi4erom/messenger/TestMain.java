package com.zoi4erom.messenger;

import com.zoi4erom.messenger.entity.Chat;
import com.zoi4erom.messenger.entity.Friend;
import com.zoi4erom.messenger.entity.Message;
import com.zoi4erom.messenger.entity.User;
import com.zoi4erom.messenger.repository.ChatRepo;
import com.zoi4erom.messenger.repository.FriendRepo;
import com.zoi4erom.messenger.repository.MessageRepo;
import com.zoi4erom.messenger.repository.UserRepo;
import java.time.LocalDateTime;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMain {

	public static void main(String[] args) {
		try (SessionFactory sessionFactory = new Configuration()
		    .configure()
		    .addAnnotatedClass(User.class)
		    .addAnnotatedClass(Message.class)
		    .addAnnotatedClass(Chat.class)
		    .addAnnotatedClass(Friend.class)
		    .buildSessionFactory()) {

			MessageRepo messageRepo = new MessageRepo(sessionFactory, Message.class);
			ChatRepo chatRepo = new ChatRepo(sessionFactory, Chat.class);
			UserRepo userRepo = new UserRepo(sessionFactory);
			FriendRepo friendRepo = new FriendRepo(sessionFactory, Friend.class);

			var byId = friendRepo.getById(2);

			System.out.println(byId);

		}

	}
}
