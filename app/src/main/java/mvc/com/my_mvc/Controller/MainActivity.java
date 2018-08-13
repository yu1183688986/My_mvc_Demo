package mvc.com.my_mvc.Controller;
/**
 * @date on 18:22 2018/8/12
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe controller层
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mvc.com.my_mvc.Bean.Book;
import mvc.com.my_mvc.Model.IModel;
import mvc.com.my_mvc.Model.MyModel;
import mvc.com.my_mvc.R;
import mvc.com.my_mvc.Utils.BookAdapter;
import mvc.com.my_mvc.Utils.MyApplication;
import mvc.com.my_mvc.View.IView;

public class MainActivity extends AppCompatActivity implements IView,View.OnClickListener{

    private ListView lv_book;
    private List<Book> list;
    private BookAdapter adapter;
    private IModel iModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_book = findViewById(R.id.lv);
        iModel = new MyModel(this);
        list = iModel.query();
        adapter = new BookAdapter(this,R.layout.book_item,list);
        showBook();
        Button bt_add = findViewById(R.id.bt_add);
        Button bt_delete = findViewById(R.id.bt_delete);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
    }

    @Override
    public void showBook() {
        lv_book.setAdapter(adapter);
        lv_book.setOnItemClickListener((parent,view,position,id)->{
            Book book = list.get(position);
            Toast.makeText(MyApplication.getContext(),book.getName()+"被选中",Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_add:
                iModel.addBook(getRandomBook().getName(),getRandomBook().getImageId(),()->{
                    adapter.notifyDataSetChanged();
                });
                break;
            case R.id.bt_delete:
                iModel.deleteBook(()->{
                    adapter.notifyDataSetChanged();
                });
                break;
            default:
                break;
        }
    }

    private Book getRandomBook(){
        String[] bookNames = {"Java从入门到精通","Android从入门到精通","JavaWeb从入门到精通"};
        Random random = new Random();
        String name = bookNames[random.nextInt(bookNames.length)];
        int imageId = 0;
        switch (name){
            case "Java从入门到精通":
                imageId = R.drawable.java;
                break;
            case "Android从入门到精通":
                imageId = R.drawable.android;
                break;
            case "JavaWeb从入门到精通":
                imageId = R.drawable.javaweb;
                break;
            default:
                break;
        }
        return new Book(name,imageId);
    }
}
