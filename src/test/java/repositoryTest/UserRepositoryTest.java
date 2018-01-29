/*
package repositoryTest;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.mockito.Mockito.*;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

*/
/**
 * Created by Kriszu on 29.10.2017.
 *//*


@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories(basePackages = {"com.hellokoding.auth.repository"})
@SpringBootTest(classes=com.hellokoding.auth.repository.UserRepository.class)
@Import(UserRepository.class)
@ContextConfiguration(locations = {
        "classpath*:spring/applicationContext.xml",
        "classpath*:spring/applicationContext-jpa.xml",
        "classpath*:spring/applicationContext-security.xml" })
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Mock
    private UserRepository userRepository;

    @Test
    public void findByUsernameShouldReturnUser(){
        User exampleUser = new User();
        exampleUser.setUsername("usernameTest");
        testEntityManager.persist(exampleUser);
        testEntityManager.flush();
        //when
        User found = userRepository.findByUsername(exampleUser.getUsername());

        //then
        assertSame(exampleUser.getUsername(),found.getUsername());
    }
}
*/
