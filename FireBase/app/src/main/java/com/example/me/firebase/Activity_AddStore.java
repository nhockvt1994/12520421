package com.example.me.firebase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.me.firebase.Store.Menu;
import com.example.me.firebase.Store.Store;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Calendar.AM;
import static java.util.Calendar.PM;

public class Activity_AddStore extends AppCompatActivity {
    ImageView imgHinh;
    EditText edtTen, edtThoiGian, edtDiaChi,edtSDT;
    Button btncancel, btnsave;
    int REQUEST_CODE_IMAGE = 1;

    ArrayList<Menu> menu=new ArrayList<Menu>();
    List<Menu> menuList=new ArrayList<Menu>();
    List<Menu> menuList1=new ArrayList<Menu>();
    List<Menu> menuList2=new ArrayList<Menu>();
    List<Menu> menuList3=new ArrayList<Menu>();
    List<Menu> menuList4=new ArrayList<Menu>();
    List<Menu> menuList5=new ArrayList<Menu>();
    List<Menu> menuList6=new ArrayList<Menu>();


    DatabaseReference mData;

    FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__add_store);
        mData = FirebaseDatabase.getInstance().getReference();
        final StorageReference storageRef = storage.getReferenceFromUrl("gs://demohbb.appspot.com");
        Anhxa();
        imgHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_IMAGE);
            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

               /* Store store=new Store("https://media.foody.vn/res/g8/72444/prof/s480x300/foody-mobile-quang-jpg-932-636090177829559146.jpg",
                        "Mì Quảng - Don Quỳnh Khương","8h-22h","409/5 Nguyễn Trọng Tuyển P. 2 Quận Tân Bình TP. HCM","01689670663");
                Store store1=new Store("https://media.foody.vn/res/g9/88314/prof/s480x300/foody-mobile-sup-cua-oc-heo-mb-jp-972-635821591218933233.jpg",
                        "Súp Cua Óc Heo - Hồ Thị Kỷ","8h-22h","Hẻm 57 Hồ Thị Kỷ Quận 10 TP. HCM","01689670663");
               // mData.child("Store").push().setValue(store);
               // mData.child("Store").push().setValue(store1);
                finish();


                Menu menu1=new Menu("https://media.foody.vn/res/g1/6309/prof/s480x300/foody-mobile-mobile-jpg-371-635745599864306146.jpg"
                ,"Xôi Gà Bà Chiểu","15.000đ - 28.000đ");
                Menu menu2=new Menu("https://media.foody.vn/res/g1/6309/s180x180/foody-xoi-ga-ba-chieu-959-636058253075513926.jpg"
                        ,"Xôi Gà Bà Chiểu","15.000đ - 28.000đ");
                Menu menu3=new Menu("https://media.foody.vn/res/g1/6309/s180x180/foody-xoi-ga-ba-chieu-283-635631063423278339.jpg"
                        ,"Xôi Gà Bà Chiểu","15.000đ - 28.000đ");
                menuList.add(menu1);
                menuList.add(menu2);
                menuList.add(menu3);
                store.setMenuList(menuList);
                mData.child("Store").push().setValue(store);*/

                /*Store store=new Store("https://media.foody.vn/res/g13/129958/prof/s480x300/foody-mobile--2-_hinhmob-jpg-788-635738442670544067.jpg",
                        "Dallas Cakes & Coffee","T2 - T6: 10:00 AM - 10:00 PM | T7 - CN: 08:00 AM - 10:00 PM","233 Đường 3 Tháng 2, P. 10, Quận 10, TP. HCM","01689670663");
                Store store3=new Store("https://media.foody.vn/res/g28/279435/prof/s480x300/foody-mobile-qwe-jpg-664-636118764056866433.jpg","Lẩu Sữa Hấm Ky ","Trưa: 11:00 AM - 02:00 PM | Tối: 05:00 PM - 02:00 AM",
                        "126 Nguyễn Trãi, P. Bến Thành, Quận 1, TP. HCM","01689670663");
                Menu menu1=new Menu("https://media.foody.vn/res/g30/292621/prof/s480x300/foody-mobile-mobile-jpg-748-636153327649393322.jpg"
                        ," Đồng Xanh Quán - Cua Tuyết 86k ","50000đ-200000đ");
                Menu menu3=new Menu("https://media.foody.vn/res/g23/228489/prof/s480x300/foody-mobile-20160802_172844-jpg-138-636058122472767900.jpg"
                        ," Bingsu - Bingsuya ","50.000đ - 139.000đ");
                mData.child("Store").push().setValue(store3);
                Store store2=new Store("https://media.foody.vn/res/g3/23203/prof/s480x300/foody-mobile-sgn05bml-jpg-413-636136751879870323.jpg"," Súp Cua Soup Bông "," 07:00 AM - 07:00 PM","59C Mạc Đĩnh Chi, Quận 1, TP. HCM","01689670663");
                Store store4=new Store("https://media.foody.vn/res/g3/26762/prof/s480x300/foody-mobile-j3-jpg-658-635778452638478291.jpg", "Cajun Cua - Lý Tự Trọng "," 07:00 AM - 07:00 PM","59C Mạc Đĩnh Chi, Quận 1, TP. HCM","01689670663");

                Menu menu2=new Menu("https://media.foody.vn/res/g1/978/prof/s480x300/foody-mobile-countryhouse-jpg-246-635683259648435945.jpg"
                        ," Country House Cafe ","50.000đ - 139.000đ");
                Menu menu4=new Menu("https://media.foody.vn/res/g8/71105/prof/s480x300/foody-mobile-phuong-bun-bap-bo-tp-hcm-140429102152.jpg"
                        ," Quán Phương - Bún Bắp Bò "," 27.000đ - 40.000đ");
                Menu menu5=new Menu("https://media.foody.vn/res/g6/53647/prof/s480x300/foody-mobile-z2-jpg-435-635750536704367502.jpg"," Há Cảo Xíu Mại - Vạn Kiếp "," 10.000đ - 20.000đ");
                menuList.add(menu1);
                menuList.add(menu3);
                menuList.add(menu2);
                menuList.add(menu4);
                menuList.add(menu5);
                store.setMenuList(menuList);



                Store store5=new Store("https://media.foody.vn/res/g10/97982/prof/s480x300/foody-mobile-kimchi-kimchi-mb-jpg-602-635742143638557440.jpg", " Kimchi KimChi - Sư Vạn Hạnh "," 10:00 AM - 10:00 PM | 0:00 - 0:00"," 850 Sư Vạn Hạnh, Quận 10, TP. HCM","01689670663");
                Store store6=new Store("https://media.foody.vn/res/g1/4352/prof/s480x300/foody-mobile-3hoqwfzm-jpg-199-635853633538408701.jpg", "Phở 24 - Vincom Center "," 07:00 AM - 10:00 PM"," Tầng B3, Vincom Center, 72 Lê Thánh Tôn, P. Bến Nghé, Quận 1, TP. HCM","01689670663");
                mData.child("Store").push().setValue(store5);
                mData.child("Store").push().setValue(store6);
                Menu menu11=new Menu("https://www.foody.vn/ho-chi-minh/domino-s-pizza-cao-thang"," Domino's Pizza - Cao Thắng ","50.000đ - 139.000đ");
                Menu menu12=new Menu("https://media.foody.vn/res/g1/3577/prof/s480x300/foody-mobile-z5-jpg-702-635774754963251121.jpg"," Tokyo Deli - Điện Biên Phủ "," 80.000đ - 165.000đ");
                Menu menu13=new Menu("https://media.foody.vn/res/g14/134884/prof/s480x300/foody-mobile-hmb-f-jpg-671-635780149578882810.jpg"," Sài Gòn Ơi Cafe - Nguyễn Huệ "," 40.000đ - 100.000đ");
                menuList.add(menu11);
                menuList.add(menu12);
                menuList.add(menu13);
                store.setMenuList(menuList);
                menuList2.add(menu2);
                menuList2.add(menu3);
                menuList2.add(menu5);
                menuList2.add(menu11);
                menuList2.add(menu12);
                menuList2.add(menu13);
                store3.setMenuList(menuList2);
                menuList3.add(menu1);
                menuList3.add(menu3);
                menuList3.add(menu5);
                menuList3.add(menu11);
                menuList3.add(menu12);
                menuList3.add(menu13);
                store4.setMenuList(menuList3);
                menuList4.add(menu5);
                menuList4.add(menu3);
                menuList4.add(menu2);
                menuList4.add(menu1);
                menuList4.add(menu4);
                menuList4.add(menu13);
                store2.setMenuList(menuList4);
                menuList5.add(menu4);
                menuList5.add(menu5);
                menuList5.add(menu1);
                menuList5.add(menu11);
                menuList5.add(menu12);
                menuList5.add(menu13);
                store5.setMenuList(menuList5);
                menuList6.add(menu13);
                menuList6.add(menu3);
                menuList6.add(menu5);
                menuList6.add(menu11);
                menuList6.add(menu12);
                menuList6.add(menu4);
                store6.setMenuList(menuList6);
                mData.child("Store").push().setValue(store);
                mData.child("Store").push().setValue(store2);
                mData.child("Store").push().setValue(store3);
                mData.child("Store").push().setValue(store4);
                mData.child("Store").push().setValue(store5);
                mData.child("Store").push().setValue(store6);*/

            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                StorageReference mountainsRef = storageRef.child(("image" + calendar.getTimeInMillis() + ".jpg"));
                imgHinh.setDrawingCacheEnabled(true);
                imgHinh.buildDrawingCache();
                Bitmap bitmap = imgHinh.getDrawingCache();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(Activity_AddStore.this, "Lỗi!!!!", Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText(Activity_AddStore.this, "Thành Công", Toast.LENGTH_LONG).show();
                        Log.d("AAA", downloadUrl + "");

                        //Toast.makeText(Activity_AddStore.this,String.valueOf(downloadUrl),Toast.LENGTH_LONG).show();


                       // Store store = new Store(String.valueOf(downloadUrl), edtTen.getText().toString(), edtChiTiet.getText().toString(), edtDiaChi.getText().toString());
                        //Toast.makeText(Activity_AddStore.this, store.getTenStore() + " " + store.getLinkHinhStore(), Toast.LENGTH_LONG).show();
                        // Store store=new Store(String.valueOf(downloadUrl),edtTen.getText().toString(),edtChiTiet.getText().toString(),edtDiaChi.getText().toString());
                       // mData.child("Data").push().setValue(store);
                        Store data = new Store(String.valueOf(downloadUrl), edtTen.getText().toString(), edtThoiGian.getText().toString(),
                                edtDiaChi.getText().toString(),edtSDT.getText().toString(),menu);
                        mData.child("Store").push().setValue(data);
                        finish();
                    }
                });


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgHinh.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void Anhxa() {
        imgHinh = (ImageView) findViewById(R.id.imagehinh);
        edtTen = (EditText) findViewById(R.id.edtten);
        edtThoiGian = (EditText) findViewById(R.id.edttime);
        edtDiaChi = (EditText) findViewById(R.id.edtdiachi);
        edtSDT=(EditText) findViewById(R.id.edtsdt);
        btncancel = (Button) findViewById(R.id.btncancel);
        btnsave = (Button) findViewById(R.id.btnsave);


    }

}
