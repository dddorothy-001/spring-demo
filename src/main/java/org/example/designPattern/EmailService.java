package org.example.designPattern;

public class EmailService implements MessageService{
    @Override
    public void send(String message) {
        System.out.println("发送邮件: " + message);
    }

    public static void main(String[] args) {
        //注册服务
        ServiceLocator.registerService(MessageService.class, new EmailService());

        //获取服务并使用
        MessageService service = ServiceLocator.getService(MessageService.class);
        service.send("hello world!");
    }
}
