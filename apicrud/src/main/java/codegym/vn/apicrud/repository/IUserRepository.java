package codegym.vn.apicrud.repository;

import codegym.vn.apicrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
