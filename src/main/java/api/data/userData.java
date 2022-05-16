package api.data;

public class userData {
    //登录网站查看接口说明 发现post 方法需要传入两个参数 name job
    private String name;
    private String job;

    public userData() {
    }
    public userData(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }



}
