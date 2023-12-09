package service.yourbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.yourbookspring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
