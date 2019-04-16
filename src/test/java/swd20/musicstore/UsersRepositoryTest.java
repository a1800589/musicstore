package swd20.musicstore;


import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import swd20.musicstore.domain.UserRepository;
import swd20.musicstore.domain.Users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RunWith(SpringRunner.class)
@DataJpaTest


public class UsersRepositoryTest {

    @Autowired
    private UserRepository repository;

   
    @Test
    public void createNewUser() {
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	Users user = new Users ("test", "$2a$04$XTB4CvcaCl//KtgxnlNEqO33fEgyNx/BDtYTNwG57HaGv9fiY/g8u","USER");
    	repository.save(user);
    	
    	assertThat(user.getId()).isNotNull();
    }    

    @Test
	public void deleteUser() {
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	Users user = new Users("testi",encoder.encode("testi"),"USER");
    	repository.save(user);

    	repository.deleteById(user.getId());
    	user = repository.findById(user.getId()).orElse(null);
    	
    	assertThat(user).isNull();
	}
	
}