package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private ShoppingSQLiteOpenHelper mHelper;
    TextView mTextViewPrice;
    TextView mTextViewDescription;
    TextView mTextViewType;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent= getIntent();
        int id= intent.getIntExtra("id", -1);

        mHelper= ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this);

        Cursor cursor= mHelper.getShoppingList();

        String name= ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemNameById(id);
        String price= ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemPriceById(id);
        String description= ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemDescById(id);
        String type= ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemTypeById(id);


        if(id >=0){
            String itemName= ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getShoppingListById(id);
            TextView textView= (TextView)findViewById(R.id.textView);
            textView.setText(itemName);

            mTextViewPrice=(TextView)findViewById(R.id.textViewPrice);
            mTextViewDescription=(TextView)findViewById(R.id.textViewDescription);
            mTextViewType=(TextView)findViewById(R.id.textViewType);

            mTextViewPrice.setText(price);
            mTextViewDescription.setText(description);
            mTextViewType.setText(type);

        }
    }
}
