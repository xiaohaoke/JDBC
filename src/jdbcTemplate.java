import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;
        import org.springframework.jdbc.core.JdbcTemplate;

public class jdbcTemplate {


    public void addAccountTest(){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao=(AccountDao)applicationContext.getBean("accountDao");
        Account account=new Account();
        account.setUsername("tom");
        account.setBalance(1000.00);
        try {
            accountDao.addAccount(account);
        }catch (Exception e2) {

            System.out.println(e2);
        }
    }



    public void updateAccount(){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao3=(AccountDao)applicationContext.getBean("accountDao");
        update update=new update();
        update.setUsername("tom");
        update.setBalance(1050.00);
        update.setId(2);
        try {
            accountDao3.updateAccotunt(update);
            System.out.println("成功更新一条数据");
        }catch (Exception e2) {

            System.out.println("更新数据失败");
            System.out.println(e2);
        }


    }


    public void deleAccount()
    {
        ApplicationContext applicationContext1=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao1=(AccountDao)applicationContext1.getBean("accountDao1");
        dele dele=new dele();
        dele.setid(1);
        try {
            accountDao1.deleAccoun(dele);
            System.out.println("成功删除一条数据");
        }catch (Exception e2)
        {
            System.out.println(e2);
            System.out.println("未能成功删除一个数据");
        }
//        if(num1>0)
//        {
//            System.out.println("成功删除了一个数");
//
//        }else
//        {
//            System.out.println("删除操作失败");
//        }
    }


    public void create(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        try {
            jdbcTemplate.execute("create table account4(" + "id int primary key auto_increment," + "username varchar(50)," + "balance double)");
            System.out.println("账户表account创建成功!");
        }
        catch(Exception e){
            System.out.println("该表已经存在");
        }
    }




    public static void main(String[] args)
    {
        jdbcTemplate jd=new jdbcTemplate();
        jd.addAccountTest();
         //jd.create();
        //jd.deleAccount();
        //jd.updateAccount();
    }
}
