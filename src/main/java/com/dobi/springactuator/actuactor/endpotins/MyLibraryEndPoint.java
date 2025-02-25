package com.dobi.springactuator.actuactor.endpotins;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@Endpoint(id = "myLibrary")
public class MyLibraryEndPoint {

    @WriteOperation
    public void writeOperatorTest(String value) {
        log.info("Write Operation: {}", value);
    }

//    @ReadOperation
//    public String getPathTest(@Selector String path1) {
//        log.info("Read Operation: {}", path1);
//        return "Path1: " + path1;
//    }

    @ReadOperation
    public String getPathTest(@Selector(match = Selector.Match.ALL_REMAINING) String path1[]) {
        log.info("path: {}", Arrays.asList(path1));
        return "Path1: " + path1;
    }

    @ReadOperation
    public List<MyLib> getMyLibraryInfos(@Nullable String name) {
        List<MyLib> libs = List.of(new MyLib("Java", "8"), new MyLib("Spring", "5"));;

        if(name != null) {
            libs = libs.stream()
                    .filter(lib -> lib.getName().equals(name))
                    .toList();
        }
        return libs;
    }
}
