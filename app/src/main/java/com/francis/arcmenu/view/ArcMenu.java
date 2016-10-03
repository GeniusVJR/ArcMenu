package com.francis.arcmenu.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.francis.arcmenu.R;

/**
 * @author taoc @ Zhihu Inc.
 * @since 10-03-2016
 */

public class ArcMenu extends ViewGroup {

	private static final int POS_LEFT_TOP = 0;
	private static final int POS_LEFT_BOTTOM = 1;
	private static final int POS_RIGHT_TOP = 2;
	private static final int POS_RIGHT_BOTTOM = 3;
	private Position mPosition = Position.RIGHT_BOTTOM;

	private int mRadius;
	private Status mCurrentStatus = Status.CLOSE;
	private OnMenuItemClickListener mOnMenuItemClickListener;

	/**
	 * 菜单的状态
	 */
	public enum Status{
		OPEN,CLOSE
	}

	/**
	 * 菜单的主按钮
	 */
	private View mCBotton;

	/**
	 * 菜单的位置枚举类
	 */
	public enum Position{
		LEFT_TOP,LEFT_BOTTOM,RIGHT_TOP,RIGHT_BOTTOM
	}

	/**
	 * 点击子菜单的回调接口
	 */
	public interface OnMenuItemClickListener{
		void onClick(View view, int position);
	}

	public void setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener){
		this.mOnMenuItemClickListener = menuItemClickListener;
	}

	public ArcMenu(Context context) {
		this(context, null);
	}

	public ArcMenu(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ArcMenu(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mRadius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100,
				getResources().getDisplayMetrics());

		//获取自定义属性
		TypedArray array = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.ArcMenu, defStyleAttr, 0);

		int pos = array.getInt(R.styleable.ArcMenu_position, POS_RIGHT_BOTTOM);
		switch (pos){
			case POS_LEFT_TOP:
				mPosition = Position.LEFT_TOP;
				break;
			case POS_LEFT_BOTTOM:
				mPosition = Position.LEFT_BOTTOM;
				break;
			case POS_RIGHT_TOP:
				mPosition = Position.RIGHT_TOP;
				break;
			case POS_RIGHT_BOTTOM:
				mPosition = Position.RIGHT_BOTTOM;
				break;
		}

		mRadius = array.getDimensionPixelOffset(R.styleable.ArcMenu_radius, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100,
				getResources().getDisplayMetrics()));

		Log.e("TAG", "position = " + mPosition + ", radius = " + mRadius);

		array.recycle();
	}


	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {

	}
}
