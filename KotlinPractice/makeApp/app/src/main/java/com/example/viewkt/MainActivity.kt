package com.example.viewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) { //앱이(액티비티가) 최초 실행될 떄 수행
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)//xml 화면 뷰 연결 <- 기존에 설정돼있는 이 부분 지우고 바인딩 넣기

//        바인딩해야 요소 불러올 수 있음!!
        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시
        setContentView(binding.root)

        binding.tvResult.setText("안녕하세요 김서현이에요!")
    }

    // 액티비티가 파괴될 때
    override fun onDestroy() {
        //onDestroy에서 binding class 인스턴스 참조 정리해줘야
        mBinding = null
        super.onDestroy()
    }
}