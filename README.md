# ScreenViewPager
�м�Page�ڵ�����Pager��Viewpager
## ��ʾЧ��
![github](https://github.com/AkLeeii/ScreenViewPager/blob/master/screenviewpager.gif "��ʾЧ��")
## ���ʹ��
```XML
 <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="240dp"
        android:clipChildren="false"><!--clipChildren="false" ����-->

        <LinearLayout
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1" />

        <com.lch.screenviewpager.view.ScreenViewPager
            android:id="@+id/viewpager"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="2" />

        <LinearLayout
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1" />
    </LinearLayout>
```