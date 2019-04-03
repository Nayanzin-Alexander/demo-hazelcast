package com.nayanin.hazelcastclient;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HazelcastClientCLR implements CommandLineRunner {

    private final Log log = LogFactory.getLog(getClass());
    private final HazelcastInstance hazelcastClient;

    @Override
    public void run(String... args) {
        IMap<Long, String> map = hazelcastClient.getMap("data");

        map.forEach((key, value) -> log.info(key + ": " + value));
    }
}
