package com.francis.arcmenu;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ArcMotion;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.francis.arcmenu.view.ArcMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends Activity {


	private ListView mListView;
	private ArcMenu mArcMenu;
	private List<String> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initData();
		initView();

		mListView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data));

		initEvent();

	}

	private void initEvent() {
		mListView.setOnScrollListener(new AbsListView.OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				if(mArcMenu.isOpen()){
					mArcMenu.toggleMenu(600);
				}
			}
		});

		mArcMenu.setOnMenuItemClickListener(new ArcMenu.OnMenuItemClickListener() {

			@Override
			public void onClick(View view, int position) {
				Toast.makeText(MainActivity.this, position+":"+view.getTag(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void initView() {
		mListView = (ListView) findViewById(R.id.id_listview);
		mArcMenu = (ArcMenu) findViewById(R.id.id_menu);
	}

	private void initData() {
		data = new ArrayList<>();

		for(int i = 'A'; i < 'Z'; i++){
			data.add((char)i + "");
		}
	}
}
