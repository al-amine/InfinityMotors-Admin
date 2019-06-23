package com.st.il.infinitymotors.adminapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.il.infinitymotors.adminapp.dao.CarDao;
import com.st.il.infinitymotors.adminapp.dao.OrderDao;
import com.st.il.infinitymotors.adminapp.dao.OrderItemDao;
import com.st.il.infinitymotors.adminapp.dao.UserDao;
import com.st.il.infinitymotors.adminapp.exception.AlreadyExistsException;
import com.st.il.infinitymotors.adminapp.exception.BadRequestException;
import com.st.il.infinitymotors.adminapp.exception.NotFoundException;
import com.st.il.infinitymotors.adminapp.model.User;
import com.st.il.infinitymotors.adminapp.service.AdministratorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {
	
	@Autowired
    private AdministratorService service;
	
    @MockBean
    private UserDao userDao;
    
    @MockBean
    private OrderDao orderDao;
    
    @MockBean
    private OrderItemDao orderItemDao;
    
    @MockBean
    private CarDao carDao;
 
//    @Before
//    public void setUp() {
//    	
//    	MockitoAnnotations.initMocks(this);
//    	
//    	UserDao userDao = Mockito.mock(UserDao.class);
//     
//        Mockito.when(userDao.save(Mockito.any(User.class))).thenAnswer(new Answer<User>() {
//			@Override
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				Object[] args = invocation.getArguments();
//			      return (User) args[0];
//			}
//          });
//        
//        Mockito.when(userDao.findByUsername(Mockito.anyString())).thenAnswer(new Answer<User>() {
//			@Override
//			public User answer(InvocationOnMock invocation) throws Throwable {
//				Object[] args = invocation.getArguments();
//			      return (User) args[0];
//			}
//          });
//    }
    
    /*************************************
     Order Tests
     *************************************/
    
    /**
     * 
     */
    @Test
    public void testGetOrder() {
    	
    }
    
    @Test
    public void testGetOrdersByUser() {
    	
    }
    
    @Test
    public void testGetOrders() {
    	
    }
    
    @Test
    public void testAddOrder() {
    	
    }
    
    /**************************************
     User Tests
     **************************************/
    
    /**
     *  Provides a list of Users for usage in tests.
     *  @author Tonny Huang
     */
    private List<User> listOfUsers() {
    	
    	User u1 = new User(1, 
    			"user1", 
    			"password", 
    			"customer", 
    			"full name", 
    			"address", 
    			"phone");
    	User u2 = new User(2, 
    			"user2",
    			"", "customer", "", "", "");
    	User u3 = new User(2, 
    			"user3",
    			"", "customer", "", "", "");
    	
    	ArrayList<User> list = new ArrayList();
    	list.add(u1);
    	list.add(u2);
    	list.add(u3);	

    	return list;
    }
    
    @Test
    public void testAddUser() throws AlreadyExistsException, BadRequestException {
    	List<User> list = listOfUsers();
    	User u1 = list.get(0);
    	User u2 = list.get(1);
    	
    	given(this.userDao.save(u1)).willReturn(u1);
		assertThat(service.addUser(u1))
			.isEqualToComparingFieldByField(u1);
		
		given(this.userDao.findByUsername("user2"))
			.willReturn(Optional.of(u2));
		assertThatThrownBy(() -> {service.addUser(u2);})
			.isInstanceOf(AlreadyExistsException.class);
		
		u1.setRole("Fake Role");
    	given(this.userDao.findById(u1.getUserId())).willReturn(Optional.of(u1));
    	assertThatThrownBy(() -> { service.addUser(u1);})
			.isInstanceOf(BadRequestException.class);
		
    }
    
    @Test
    public void testUpdateUser() throws NotFoundException, BadRequestException {
    	User u1 = listOfUsers().get(0);
    	
    	given(this.userDao.findById(u1.getUserId())).willReturn(Optional.of(u1));
    	given(this.userDao.save(u1)).willReturn(u1);
    	assertThat(service.updateUser(u1.getUserId(), u1))
    		.isEqualToComparingFieldByField(u1);
    	
    	given(this.userDao.findById(u1.getUserId())).willReturn(Optional.empty());
    	assertThatThrownBy(() -> { service.updateUser(u1.getUserId(), u1);})
			.isInstanceOf(NotFoundException.class);
    	
    	u1.setRole("Fake Role");
    	given(this.userDao.findById(u1.getUserId())).willReturn(Optional.of(u1));
    	assertThatThrownBy(() -> { service.updateUser(u1.getUserId(), u1);})
			.isInstanceOf(BadRequestException.class);
    }
    
    @Test
    public void testDeleteUser() {
    	
    	User u1 = listOfUsers().get(0);
    	
    	given(this.userDao.findById(u1.getUserId())).willReturn(Optional.empty());
    	assertThatThrownBy(() -> { service.deleteUser(u1.getUserId());})
			.isInstanceOf(NotFoundException.class);
    	
    }
    
    @Test
    public void testGetUser() throws NotFoundException {
    	List<User> list = listOfUsers();
    	User u1 = list.get(0);
    	
    	given(this.userDao.findById(u1.getUserId()))
    		.willReturn(Optional.of(u1));
    	assertThat(service.getUser(u1.getUserId()))
    		.isEqualToComparingFieldByField(u1);
    	
    	given(this.userDao.findByUsername(u1.getUsername()))
    		.willReturn(Optional.of(u1));
    	assertThat(service.getUser(u1.getUsername()))
			.isEqualToComparingFieldByField(u1);
    	
    	
    	given(this.userDao.findByUsername("notExist"))
    		.willReturn(Optional.empty());
    	assertThatThrownBy(() -> { service.getUser("notExist"); })
			.isInstanceOf(NotFoundException.class);
    }
    
    @Test
    public void testGetAllUsers() {
    	List<User> list = listOfUsers();
    	given(this.userDao.findAll()).willReturn(list);
    	
    }
    
}
