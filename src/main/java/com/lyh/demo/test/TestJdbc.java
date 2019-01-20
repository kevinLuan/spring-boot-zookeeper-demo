package com.lyh.demo.test;

import com.lyh.demo.test.api.CommonService;
import com.lyh.demo.test.api.CommonServiceImpl;
import com.lyh.demo.test.entity.Order;
import com.lyh.demo.test.entity.OrderItem;
import com.lyh.demo.test.repository.OrderItemRepository;
import com.lyh.demo.test.repository.OrderRepository;
import com.lyh.demo.test.repositoryJDBCImpl.JDBCOrderItemRepositoryImpl;
import com.lyh.demo.test.repositoryJDBCImpl.JDBCOrderRepositoryImpl;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class TestJdbc {

  @Autowired
  private DataSource demoMasterSlave;

  CommonService commonService= newCommonService();
  /**
   * 测试JDBC 读写分离
   */
  @SneakyThrows
  @PostConstruct
  public void init(){
    commonService= newCommonService();
    commonService.initEnvironment();
    commonService.processSuccess(false);
//		commonService.cleanEnvironment();
  }


  public Object get(){
    return commonService.getData();
  }

  public CommonService newCommonService(){
    CommonService commonService=new CommonServiceImpl() {
      @Override
      protected OrderRepository getOrderRepository() {
        return new JDBCOrderRepositoryImpl(demoMasterSlave);
      }

      @Override
      protected OrderItemRepository getOrderItemRepository() {
        return new JDBCOrderItemRepositoryImpl(demoMasterSlave);
      }

      @Override
      protected Order newOrder() {
        return new Order();
      }

      @Override
      protected OrderItem newOrderItem() {
        return new OrderItem();
      }
    };
    return commonService;
  }
}
