package mvc.com.my_mvc.Utils;
/**
 * @date on 17:21 2018/8/12
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe ListView的Adapter
 */
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mvc.com.my_mvc.Bean.Book;
import mvc.com.my_mvc.R;

public class BookAdapter extends ArrayAdapter {
    //布局id
    private int resourceId;

    public BookAdapter(@NonNull Context context,int textViewResourceId, @NonNull List objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Book book = (Book) getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(MyApplication.getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.bookImage = view.findViewById(R.id.book_image);
            viewHolder.bookName = view.findViewById(R.id.book_name);
            view.setTag(viewHolder);//将viewHolder存储在View中
        }else {
            view = convertView;//使用前面缓存的布局
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.bookImage.setImageResource(book.getImageId());
        viewHolder.bookName.setText(book.getName());
        return view;
    }

    class ViewHolder{
        ImageView bookImage;
        TextView bookName;
    }
}
