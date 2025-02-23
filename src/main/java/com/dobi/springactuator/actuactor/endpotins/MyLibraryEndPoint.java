package com.dobi.springactuator.actuactor.endpotins;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Endpoint(id = "myLibrary")
public class MyLibraryEndPoint {

    @ReadOperation
    public List<MyLib> getMyLibraryInfos() {

        return List.of(new MyLib("Java", "8"), new MyLib("Spring", "5"));
    }
}
