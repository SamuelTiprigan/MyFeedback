package com.feedback.repositoryImpl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.feedback.model.User;
import com.feedback.repository.UserRepository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getById(long id) {
		TypedQuery<User> q = entityManager.createQuery("select u from User u where u.id=:id", User.class);
		q.setParameter("id", id);

		List<User> users = q.getResultList();
		if (users.size() != 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		TypedQuery<User> q = entityManager.createQuery("select u from User u where u.email=:email", User.class);
		q.setParameter("email", email);

		List<User> users = q.getResultList();
		if (users.size() != 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public Collection<User> findAll() {
		TypedQuery<User> q = entityManager.createQuery("select u from User u", User.class);
		return q.getResultList();
	}

	@Override
	@Transactional
	public void createUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public User getUserByUsername(String username) {
		TypedQuery<User> q = entityManager.createQuery("select u from User u where u.username=:username", User.class);
		q.setParameter("username", username);

		List<User> users = q.getResultList();
		if (users.size() != 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

}
