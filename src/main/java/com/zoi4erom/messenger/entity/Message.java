package com.zoi4erom.messenger.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

//TODO реалізувати MessageStatus(DELIVERED, READ, PENDING),
// можливо MessageType(file, image, text...)
@Table(name = "message")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Message implements BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "text")
	private String text;

	@Column(name = "timestamp")
	private LocalDateTime timestamp;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chat_id")
	private Chat chat;

	public Message(String text, LocalDateTime timestamp) {
		this.text = text;
		this.timestamp = timestamp;
	}
}
