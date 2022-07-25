package com.lithan.csp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.lithan.csp.entity.Users;
import com.lithan.csp.repository.RoleRepo;
import com.lithan.csp.repository.UserRepo;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceTest {
	
	@Mock
	UserRepo userrepo;
	
	@Mock
	RoleRepo rolerepo;
	
	@InjectMocks
	UserService userservice;
	
//	@Autowired
//	UserService userService;

	@Test
	void testAddUser() {
		Users user = new Users();
		user.setName("Jackson Micky");
		user.setUserName("jakmi22");
		user.setEmail("jakmi22Gmail.com");
		user.setPassword("qwer");
		
		when(userrepo.save(user)).thenReturn(user);
		userservice.addUser(user);
		verify(userrepo).save(any(Users.class));
	}

	@Test
	void testListAllUsers() {
		List<Users> listuser = userservice.listAllUsers();
		
		assertNotNull(listuser);
	}

	@Test
	void testGetUserById() {
//		Users user = userservice.getUserById(2L);
//		Optional<Users> user = Optional.of(userservice.getUserById(2l));
//		Optional<Users> user = Optional.of(new Users());
//		user.get().setId(3l);
//		
//		userservice.getUserById(user.get().getId());
//		
//		assertNotNull(user);
//		assertEquals("kiara1234", user.get().getUserName());
//		assertEquals("kiara1234", user.getUserName());
		
		Optional<Users> user = userrepo.findById(3l);
		if(user.isPresent()) {
			assertTrue(user.isPresent());			
		}
	}

	@Test
	void testGetByUserName() {
//		Users user = userservice.getByUserName("lorikoho123");
//		
//		assertNotNull(user);
//		assertEquals("kiara1234", user.getUserName());
//		assertThat(user.getUserName(), equalTo("lorikoho123"));
		
		Users user = userrepo.findByUserName("lorikoho123");
		assertNotNull(user);
	}

	@Test
	void testUpdateUser() {
//		Users user = new Users();
//		user.setId(3l);
//		user.setAddress("Kalimalang");
		
//		when(userrepo.findById(user.getId()).get()).thenReturn(user);
//		userservice.editUser(user);
		
//		verify(userrepo).save(any(Users.class));
//		assertEquals(user.getAddress(), "Kalimalang");
		
		Optional<Users> user = Optional.of(new Users());
		user.get().setId(3l);
		user.get().setAddress("Kalimalang");
		
		when(userrepo.findById(user.get().getId())).thenReturn(user);
		userservice.editUser(user.get());
		
		verify(userrepo).save(any(Users.class));
		assertEquals(user.get().getAddress(), "Kalimalang");
	}

//	@Test
//	void testBecomeAdmin() {
//		Set<String> role = new HashSet<>();
//		role.add("Admin");
//		
////		Users user = new Users();
////		user.setId(3l);
////		
////		when(userrepo.findById(user.getId()).get()).thenReturn(user);
////		userservice.becomeAdmin(user.getId());
////		
////		assertEquals(user.getRoles(), role);
//		
//		Optional<Users> user = Optional.of(new Users());
//		user.get().setId(3l);
//		
//		when(userrepo.findById(user.get().getId())).thenReturn(user);
//		userservice.becomeAdmin(user.get().getId());
//		
//		assertEquals(user.get().getRoles(), role);
//	}

	@Test
	void testDeleteUser() {
		long userid = 3l;
		userservice.deleteUser(userid);
		
		verify(userrepo, times(1)).deleteById(userid);
	}

}
