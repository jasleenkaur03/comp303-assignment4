package com.comp303.Assignment4.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeRepository extends MongoRepository<Employee, String>{
    
    @Query("{UserName:'?0'}")
    Employee getPassword(String UserName);
    
    // @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    // List<GroceryItem> findAll(String category);
    
    public long count();
}