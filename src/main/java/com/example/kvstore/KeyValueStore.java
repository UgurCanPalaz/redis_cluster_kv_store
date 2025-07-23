package com.example.kvstore;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class KeyValueStore {

    private JedisCluster jedisCluster;

    public KeyValueStore() {
        Set<HostAndPort> nodes = new HashSet<>();
        // Docker ağı içindeki IP’ler ve portlar:
        nodes.add(new HostAndPort("172.19.0.3", 7000)); // kvstore-redis-node1-1
        nodes.add(new HostAndPort("172.19.0.4", 7001)); // kvstore-redis-node2-1
        nodes.add(new HostAndPort("172.19.0.2", 7002)); // kvstore-redis-node3-1

        jedisCluster = new JedisCluster(nodes);
    }

    public void set(String key, String value) {
        jedisCluster.set(key, value);
    }

    public String get(String key) {
        return jedisCluster.get(key);
    }

    public void close() throws IOException {
        jedisCluster.close();
    }
}
