package com.wy.coupon.customer;

import com.wy.coupon.customer.config.CanaryRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.wy"})
@EnableTransactionManagement
//用于扫描Dao @Repository
@EnableJpaRepositories(basePackages = {"com.wy"})
//用于扫描JPA实体类 @Entity，默认扫本包当下路径
@EntityScan(basePackages = {"com.wy"})
// 发到coupon-template-serv的调用，使用CanaryRuleConfiguration中定义的负载均衡Rule
@LoadBalancerClient(value = "coupon-template-server", configuration = CanaryRuleConfiguration.class)
public class CouponCustomerImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponCustomerImplApplication.class, args);
    }

}
