package spring.Security.spring.Security.repositry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.Security.spring.Security.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
