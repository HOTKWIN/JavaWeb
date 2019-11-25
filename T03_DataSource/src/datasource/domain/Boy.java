package datasource.domain;

/**
 * Boy的JavaBean
 *
 * @author kwin
 * @create 2019-11-25 20:37
 */
public class Boy {
    private Integer id;
    private String boyName;
    private Integer userCP;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoyName() {
        return boyName;
    }

    public void setBoyName(String boyName) {
        this.boyName = boyName;
    }

    public Integer getUserCP() {
        return userCP;
    }

    public void setUserCP(Integer userCP) {
        this.userCP = userCP;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                ", boyName='" + boyName + '\'' +
                ", userCP=" + userCP +
                '}';
    }
}
