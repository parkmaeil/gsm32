package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Customer;
import com.example.demo.payload.BookInfoDTO;
import com.example.demo.payload.CartDTO;
import com.example.demo.payload.CustomerCartDTO;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public List<CustomerCartDTO> getCustomersWithCarts(){
        List<Customer> customers=customerRepository.findAllWithCartsAndBooks();
        // Book->BookInfoDTO
        // Cart->CartDTO
        // Customer->CustomerCartDTO
        return customers.stream().map(customer->{
            List<CartDTO> cartDTOS=customer.getCarts().stream().map(cart->{
                Book book=cart.getBook();
                BookInfoDTO bookInfoDTO=new BookInfoDTO(book.getTitle(), book.getAuthor(), book.getPrice());
                return new CartDTO(cart.getQuantity(), cart.getCartDate(), bookInfoDTO);
            }).toList();
          return new CustomerCartDTO(customer.getUsername(), customer.getName(), customer.getAge(), cartDTOS);
        }).toList();
    }

}

