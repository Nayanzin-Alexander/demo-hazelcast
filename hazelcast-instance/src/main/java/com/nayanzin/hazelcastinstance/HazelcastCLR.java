package com.nayanzin.hazelcastinstance;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class HazelcastCLR implements CommandLineRunner {

    private final HazelcastInstance hazelcastInstance;

    private final Log log = LogFactory.getLog(getClass());

    @Override
    public void run(String... args) {
        Map<Long, String> map = hazelcastInstance.getMap("data");
        IdGenerator idGenerator = hazelcastInstance.getIdGenerator("newid");

        IntStream.range(0, 10)
                .forEach( i -> map.put(idGenerator.newId(), "message " + i));
    }
}
