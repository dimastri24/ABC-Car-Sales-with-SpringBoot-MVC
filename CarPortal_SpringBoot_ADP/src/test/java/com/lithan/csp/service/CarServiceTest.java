package com.lithan.csp.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.lithan.csp.entity.Cars;
import com.lithan.csp.entity.Users;
import com.lithan.csp.repository.CarRepo;
import com.lithan.csp.repository.UserRepo;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CarServiceTest {
	
	@Mock
	UserRepo userrepo;
	
	@Mock
	CarRepo carrepo;
	
	@InjectMocks
	CarService carservice;

	@Test
	void testListAllCars() {
		List<Cars> cars = carservice.listAllCars();
		
		assertNotNull(cars);
	}

	@Test
	void testAddCar() {
		//Optional<Users> user = Optional.of(new Users());
		//user.get().setId(3l);
		//when(userrepo.findById(user.get().getId())).thenReturn(user);
		//userrepo.findById(user.get().getId());
		
		Optional<Users> user = userrepo.findById(3L);
		
		if(user.isPresent()) {
			Cars car = new Cars("2017", "Jazz", "Honda", new BigDecimal(2000), user.get());			
			carrepo.save(car);
			verify(carrepo).save(any(Cars.class));
		}
		
		//Cars car = new Cars("2017", "Jazz", "Honda", new BigDecimal(2000), user.get());
		//when(carrepo.save(car)).thenReturn(car);
		//carservice.addCar(car);
	}

	@Test
	void testGetCarById() {
		Optional<Cars> car = carrepo.findById(3l);
		if(car.isPresent()) {
			assertNotNull(car);
		}
	}

	@Test
	void testEditCar() {
		Optional<Cars> car = Optional.of(new Cars());
		car.get().setId(3l);
		car.get().setModel("Yaris");
		
		when(carrepo.findById(car.get().getId())).thenReturn(car);
		carservice.editCar(car.get());
		
		verify(carrepo).save(any(Cars.class));
		assertEquals("Yaris", car.get().getModel());
	}

	@Test
	void testInactiveCar() {
		Optional<Cars> car = Optional.of(new Cars());
		car.get().setId(3l);
		car.get().setModel("Yaris");
		
		when(carrepo.findById(car.get().getId())).thenReturn(car);
		
		if(car.isPresent()) {
			carservice.inactiveCar(car.get().getId());
			assertEquals("Yaris", car.get().getModel());
		}
		
	}

	@Test
	void testDeleteCar() {
		long carid = 3l;
		carservice.deleteCar(carid);
		
		verify(carrepo, times(1)).deleteById(carid);
	}

	@Test
	void testSearchByParam() {
		List<Cars> cars = carservice.searchByParam("toyota");
		
		assertNotNull(cars);
	}

	@Test
	void testSearchByPrice() {
		List<Cars> cars = carservice.searchByPrice(new BigDecimal(1000), new BigDecimal(3000));
		assertNotNull(cars);
	}

	@Test
	void testListCarsUser() {
		Optional<Users> user = userrepo.findById(3L);
		
		if(user.isPresent()) {
			List<Cars> cars = carservice.listCarsUser(user.get());
			assertNotNull(cars);
		}
	}

}
