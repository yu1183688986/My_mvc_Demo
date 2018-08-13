package mvc.com.my_mvc.Model;

import java.util.List;

import mvc.com.my_mvc.Bean.Book;

/**
 * @date on 17:13 2018/8/12
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe Model层接口
 */
public interface IModel {
    void addBook(String name,int imageId,onAddBookListener listener);
    void deleteBook(onDeleteBookListener listener);
    List<Book> query();

    //添加成功的回调接口
    public interface onAddBookListener{
        void onComplete();
    }
    //删除成功的回调接口
    public interface onDeleteBookListener{
        void onComplete();
    }

}
