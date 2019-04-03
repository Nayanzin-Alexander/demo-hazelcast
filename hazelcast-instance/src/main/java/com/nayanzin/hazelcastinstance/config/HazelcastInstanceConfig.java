package com.nayanzin.hazelcastinstance.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastInstanceConfig {

    @Bean
    public HazelcastInstance hazelcastInstance() {

        Config config = new Config();

        NetworkConfig networkConfig = config.getNetworkConfig();
        networkConfig.setPort(5701).setPortCount(1);
        networkConfig.setPortAutoIncrement(false);

        JoinConfig join = networkConfig.getJoin();

        join.getMulticastConfig().setEnabled(false);

        join.getTcpIpConfig()
                .addMember("machine1")
                .addMember("localhost")
                .setEnabled(true);

        return Hazelcast.newHazelcastInstance(config);
    }
}
