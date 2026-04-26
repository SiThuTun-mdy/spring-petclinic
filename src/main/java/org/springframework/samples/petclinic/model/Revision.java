package org.springframework.samples.petclinic.model;

import jakarta.persistence.*;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Revision")
@RevisionEntity
@EntityListeners(RevisionListener.class)
public class Revision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@RevisionNumber
	private Integer id;

	@RevisionTimestamp
	private Long timestamp;

	String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

@Component
class RevisionListener {

	@PrePersist
	public void prePersist(Object entity) {
		Revision self = (Revision) entity;
		// implement as required
		self.setUsername("dev_user");

	}

}
