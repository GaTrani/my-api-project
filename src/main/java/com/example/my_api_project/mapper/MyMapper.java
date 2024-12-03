package com.example.my_api_project.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MyMapper {

    private  ModelMapper mapper;

    public <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination){
        List<D> destinationObjects = new ArrayList<D>();
        for (O o: origin){
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}
