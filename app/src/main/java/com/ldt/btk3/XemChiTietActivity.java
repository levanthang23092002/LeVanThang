package com.ldt.btk3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class XemChiTietActivity extends AppCompatActivity implements NgonNguAdapter.OnSinhVienListener{

    private TextView tvNgonNgu,tvmota;
    private ImageView anh;
    private List<NgonNgu> ngonNguList;
    private RecyclerView recyclerView;
    private NgonNguAdapter ngonNguAdapter;


    NgonNgu nn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_chi_tiet);

        anhXa();
        nn = new NgonNgu();
        nn = (NgonNgu) getIntent().getSerializableExtra("NgonNgu");
        tvNgonNgu.setText(nn.getTenNN());
        tvmota.setText(nn.getVidu());
        anh.setImageResource(nn.getImage());


        ngonNguList = new ArrayList<>();
//        mData = FirebaseDatabase.getInstance().getReference();

        ngonNguList = createData();
        ngonNguAdapter = new NgonNguAdapter (this, this);
        ngonNguAdapter.setData(ngonNguList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ngonNguAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }
    private List<NgonNgu> createData() {
        List<NgonNgu> sachList = new ArrayList<>();
        sachList.add(new NgonNgu("H??n M???c T??? Th?? V?? ?????i", "Nh?? xu???t b???n:NXB V??n H???c",R.drawable.sach1));
        sachList.add(new NgonNgu("H??n M???c T??? Th?? V?? ?????i", "Nh?? xu???t b???n:NXB V??n H???c",R.drawable.sach1));
        sachList.add(new NgonNgu(" Nguy???n Tr??i Th?? V?? ?????i", "Nh?? cung c???p:C??NG TY C??? PH???N S??CH TR?? TH???C VI???T",R.drawable.sach1));
        sachList.add(new NgonNgu("Nguy???n Tr??i Th?? V?? ?????i", "Nh?? cung c???p:C??NG TY C??? PH???N S??CH TR?? TH???C VI???T",R.drawable.sach1));
        return sachList;
    }
    private void anhXa() {
        tvNgonNgu = findViewById(R.id.tvNgonNgu);
        recyclerView =findViewById(R.id.rcvsach);
        tvmota=findViewById(R.id.txt_mota_detail);
        anh=findViewById(R.id.image_tacgia_detail);

    }






    @Override
    public void onSinhVienClick(int position) {

    }
}