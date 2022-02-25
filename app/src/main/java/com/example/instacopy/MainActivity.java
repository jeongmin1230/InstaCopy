package com.example.instacopy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.instacopy.fragment.fragment_account;
import com.example.instacopy.fragment.fragment_add_a_photo;
import com.example.instacopy.fragment.fragment_home;
import com.example.instacopy.fragment.fragment_search;
import com.example.instacopy.fragment.fragment_shop;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 프레그먼트 객체 선언
        Fragment home = new fragment_home();
        Fragment search = new fragment_search();
        Fragment add_a_photo = new fragment_add_a_photo();
        Fragment shop = new fragment_shop();
        Fragment account = new fragment_account();

        // 제일 처음 띄울 뷰 세팅. commit() 까지 꼭 해야됨!!!! 저는 fragment_home 을 먼저 띄우겠습니다.
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, home).commitAllowingStateLoss();

        // 바텀 네비게이션 객체 선언
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // 바텀 네비게이션 클릭 리스너 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.fragment_home:
                        // replace(프레그먼트를 띄워줄 frameLayout, 교체할 com.example.instacopy.fragment 객체)
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, home).commitAllowingStateLoss();
                        return true;
                    case R.id.fragment_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, search).commitAllowingStateLoss();
                        return true;
                    case R.id.fragment_add_a_photo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, add_a_photo).commitAllowingStateLoss();
                        return true;
                    case R.id.fragment_shop:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, shop).commitAllowingStateLoss();
                        return true;
                    case R.id.fragment_account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, account).commitAllowingStateLoss();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}