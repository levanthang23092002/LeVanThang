package com.ldt.btk3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NgonNguAdapter.OnSinhVienListener {

    private FloatingActionButton btnAddSV;
    private List<NgonNgu> ngonNguList;
    private RecyclerView recyclerView;
    private NgonNguAdapter ngonNguAdapter;
    private DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();

        mData = FirebaseDatabase.getInstance().getReference();
        ngonNguList = new ArrayList<>();
//        mData = FirebaseDatabase.getInstance().getReference();

        ngonNguList = createData();
        ngonNguAdapter = new NgonNguAdapter(this, this);
        ngonNguAdapter.setData(ngonNguList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ngonNguAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }



    private List<NgonNgu> createData() {
        List<NgonNgu> ngonNguList = new ArrayList<>();
        ngonNguList.add(new NgonNgu("Hàn Mặc Tử", "Hàn Mặc Tử hay Hàn Mạc Tử (tên khai sinh Nguyễn Trọng Trí; 22 tháng 9 năm 1912 – 11 tháng 11 năm 1940) là một nhà thơ người Việt Nam",R.drawable.tacgia1));
        ngonNguList.add(new NgonNgu("Mạc Ngôn", "Mạc Ngôn (sinh ngày 17 tháng 2 năm 1955) là một nhà văn người Trung Quốc xuất thân từ nông dân",R.drawable.tacgia2));
        ngonNguList.add(new NgonNgu(" Shakespeare", "Hầu hết các tác phẩm nổi tiếng nhất của ông được ông sáng tác trong giai đoạn từ 1589 đến 1613",R.drawable.tacgia3));
        ngonNguList.add(new NgonNgu("Hemingway", "Ernest Miller Hemingway là một tiểu thuyết gia người Mỹ, nhà văn viết truyện ngắn và là một nhà báo. Ông là một phần của cộng đồng những người xa xứ ở Paris trong thập niên 20 của thế kỷ XX và là một trong những cựu quân nhân trong Chiến tranh thế giới I, sau đó được biết đến qua \"Thế hệ đã mất\"",R.drawable.tacgia4));
        DatabaseReference mData = FirebaseDatabase.getInstance().getReference();

        for(NgonNgu sv : ngonNguList) {
            mData.child("DS_NgonNgu").push().setValue(sv);
        }
        return ngonNguList;
    }

    private List<NgonNgu> getDS_NgonNgu() {
        List<NgonNgu> dssv = new ArrayList<>();
        mData.child("DS_NgonNgu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ngonNguList.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    dssv.add(dataSnapshot.getValue(NgonNgu.class));
                }
                ngonNguAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return dssv;
    }

    private void anhXa() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onSinhVienClick(int position) {
        Intent intent = new Intent(MainActivity.this, XemChiTietActivity.class);
        intent.putExtra("NgonNgu", ngonNguList.get(position));
        startActivity(intent);
    }
}