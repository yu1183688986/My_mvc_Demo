package mvc.com.my_mvc.Bean;
/**
 * @date on 17:06 2018/8/12
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe Book实体类
 */
public class Book {
    //书名
    private String name;
    //书图片
    private int imageId;

    public Book(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
