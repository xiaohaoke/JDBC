import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaolmpl implements AccountDao{
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public int addAccount(Account account){
        String sql="insert into account4(username,balance) value(?,?)";
        Object[] obj=new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        int num=this.jdbcTemplate.update(sql,obj);
        return num;
    }



    public int updateAccotunt(update update) {
        String sql="update account4 set username=?,balance=? where id=?";
        Object[] params=new Object[]{
                update.getUsername(),
                update.getBalance(),
                update.getId()

        };
        int num=this.jdbcTemplate.update(sql,params);
        return num;


    }

    public int deleAccoun(dele dele){
        String sql="delete from account4 where id =?";
        Object[] delet=new Object[]{
                dele.getId()
                       };
        int num=this.jdbcTemplate.update(sql,delet);
        return num;
    }
}