# demo-spring-cloud
spring cloud项目简单实例
demo-boot-center（注册中心） 使用eureka

demo-boot-provide(服务提供者) 

demo-boot-provide1(服务提供者1模拟集群)

demo-boot-customer(服务消费者)

demo-boot-commons(提供统一的路径调用 消费者调用 提供者实现)

demo-boot-gateway(网关 ) 使用spring cloud gateway


启动注册中心        localhost:1000  查看管理界面

启动服务启动者       

启动服务消费者      localhost:1002/hello?name=aaa   查看页面显示

启动网关           localhost:1020/customer/hello?name=aaa     通过网关端口号加应用名加调用路径
  









