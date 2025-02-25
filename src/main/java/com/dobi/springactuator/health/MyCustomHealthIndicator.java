package com.dobi.springactuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyCustomHealthIndicator implements HealthIndicator {

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        if (!check()) {
            return Health.down()
                    .withDetail("MyCustomHealthIndicator", "Something went wrong")
                    .withDetail("key1", "100")
                    .build();
        }
        return Health.up()
                .withDetail("MyCustomHealthIndicator", "Everything is OK")
                .withDetail("key2", "200")
                .build();
    }

    boolean check() {
        return System.currentTimeMillis() % 2 == 0;
    }
}
