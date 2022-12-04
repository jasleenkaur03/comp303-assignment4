package com.comp303.Assignment4.Cruise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CruiseService {
    
    @Autowired
    CruiseRepository cruiseRepository;

    public Iterable<Cruise> findAll() throws Exception{
        return cruiseRepository.findAll();
    }

    public void saveCruise(Cruise c) throws Exception{
        cruiseRepository.save(c);
    }

    public void delCruise(String cruiseID) throws Exception{
        cruiseRepository.deleteById(cruiseID);
    }
}
