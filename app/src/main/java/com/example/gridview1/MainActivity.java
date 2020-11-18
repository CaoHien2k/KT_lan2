package com.example.gridview1;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    Context context;
    RelativeLayout gridviewdata;
    ArrayList<ProductModel> productData;
    ProductAdapter productAdapter;
    ProductModel productModel;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        //getviews
        gridView = findViewById(R.id.gridview);
        gridviewdata = (RelativeLayout) findViewById(R.id.gridviewdata);
        productData = new ArrayList<>();

        //add Countries Data
        populateProductData();
        gridView.setOnItemLongClickListener(new ItemLongClickRemove());
        productAdapter = new ProductAdapter(context,productData);
        gridView.setAdapter(productAdapter);
        registerForContextMenu(gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,productData.get(position).getNamedh(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void populateProductData() {
        //product1
        productModel = new ProductModel();
        productModel.setNamedh("Đồng hồ TwentySeventeen W001Q");
        productModel.setImages(R.drawable.dh1);
        productModel.setGiadh("450.000 ₫");
        productData.add(productModel);

        //product2
        productModel = new ProductModel();
        productModel.setNamedh("Đồng hồ phiên bản G70803.202.212");
        productModel.setImages(R.drawable.dh2);
        productModel.setGiadh("1.100.000 ₫");
        productData.add(productModel);

        //product3
        productModel = new ProductModel();
        productModel.setNamedh("Đồng hồ thạch anh TwentySeventeen W003Q");
        productModel.setImages(R.drawable.dh3);
        productModel.setGiadh("1.700.000 ₫");
        productData.add(productModel);

        //product4
        productModel = new ProductModel();
        productModel.setNamedh("Đồng hồ cao cấp TwentySeventeen W004Q");
        productModel.setImages(R.drawable.dh4);
        productModel.setGiadh("1.100.000 ₫");
        productData.add(productModel);

        //product5
        productModel = new ProductModel();
        productModel.setNamedh("Đồng hồ cơ Xiaomi CIGA mặt vuông");
        productModel.setImages(R.drawable.dh5);
        productModel.setGiadh("3.350.000 ₫");
        productData.add(productModel);

        //product6
        productModel = new ProductModel();
        productModel.setNamedh("Đồng hồ Longines nam L4.760.2 Automatic");
        productModel.setImages(R.drawable.dh6);
        productModel.setGiadh("2.800.000 ₫");
        productData.add(productModel);
    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    productData.remove(position);
                    //cập nhật lại listview
                    productAdapter.notifyDataSetChanged();

                }
            });
            alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //không làm gì
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}