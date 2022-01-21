package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("Ciuc").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("Ciud").build();

        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetCustomerById(){
        CustomerDto customerDto = client.getCustomer(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer(){
        CustomerDto customerDto = CustomerDto.builder().name("Marcela").build();

        URI uri = client.saveCustomer(customerDto);

        assertNotNull(uri);
    }

    @Test
    void testUpdateCustomer(){
        CustomerDto customerDto = CustomerDto.builder().name("Marcela").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }

}