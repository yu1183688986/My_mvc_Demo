package mvc.com.my_mvc.Model;

import java.util.ArrayList;
import java.util.List;

import mvc.com.my_mvc.Bean.Book;
import mvc.com.my_mvc.R;
import mvc.com.my_mvc.View.IView;

/**
 * @date on 17:50 2018/8/12
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe Model层接口实现类
 */
public class MyModel implements IModel {
    private IView view;
    private static List<Book> books = new ArrayList<>();

    /**
     * 初始化的ListView界面
     */
    static {
        books.add(new Book("Java从入门到精通", R.drawable.java));
        books.add(new Book("Android从入门到精通", R.drawable.android));
        books.add(new Book("JavaWeb从入门到精通", R.drawable.javaweb));
    }

    public MyModel(IView view) {
        this.view = view;
    }

    @Override
    public void addBook(String name,int imageId,IModel.onAddBookListener listener) {
        books.add(new Book(name,imageId));
        listener.onComplete();
        view.showBook();
    }

    @Override
    public void deleteBook(onDeleteBookListener listener) {
        books.remove(books.size()-1);
        listener.onComplete();
        view.showBook();
    }

    @Override
    public List<Book> query() {
        return books;
    }

}
