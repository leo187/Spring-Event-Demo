## Spring Event Study Demo
### 依赖 :JDK8、Spring Boot 1.5.6
### 操作及说明
#### 操作：启动应用，访问http://localhost:8888/register
#### 说明：register()方法在数据入库同时会发布一个事件,CouponListener、LotteryListener、MessageListener 三个监听器监听了这个事件，收到事件后执行相应内容，三个监听者通过@Order注解排列执行顺序，值越小越先执行

### 模拟业务场景(单服务)
#### 用户注册，注册成功后发短信、优惠券、送抽奖
> 正常逻辑遵循代码解耦一般会在主注册方法里调用多个封装好的方法
> 我们将注册等称为一个事件、当后续事件越来越多时候，封装的方法就显得很乱
> 然后我们使用 Spring 事件对其进行解耦，此场景适合将注册当为一个事件，后续监听到会做相应的操作
#### 同步 or 异步
> 第一次看这种写法可能认为其是个异步的，其实 Spring 事件既可以同步又可以异步，在未配置线程池时候会选择同步，这也是大多数场景
> 对于一些不重要的可以选择异步
> 综上所述，Spring 事件主要还是对代码层面的解耦


