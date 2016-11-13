package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import demo.cehua.nicestars.activity.R;

/**
 * Description 自定义button
 * Created by NiceStars on 2016/11/12.
 */
public class CostomButtom extends View {
    private float x;
    private float y;
    private int lastX;
    private int lastY;
    private Paint paint;

    private String text;
    public CostomButtom(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        x = 0;
        y = 0;
        paint = new Paint();
        TypedArray ta = getContext().obtainStyledAttributes(attrs,R.styleable.myView);
        int textSize = ta.getDimensionPixelOffset(R.styleable.myView_textSize, 26);
        paint.setTextSize(textSize);
        String text = ta.getString(R.styleable.myView_text);
        setcostomtext(text);
        int color = ta.getColor(R.styleable.myView_textColor, 0xff000000);
        paint.setColor(color);
        ta.recycle();
    }





    //  创建一个画板
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //买支笔

      //  paint.setTextSize(90f);
       
        //画笔颜色  1
        // paint.setColor(getResources().getColor(R.color.black));
        //画笔颜色  2
        //paint.setColor(Color.BLACK);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap,  0 ,getHeight()/2 , paint);
        if (bitmap.isRecycled()){
            bitmap.recycle();
        }

        canvas.drawText(text,getWidth()/2 ,getHeight()/2 ,paint);
    }
      public void setcostomtext(String text){
          this.text=text;
      }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        // 获取当前触摸的绝对坐标
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 上一次离开时的坐标
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                // 两次的偏移量
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;
                moveView(offsetX, offsetY);
                // 不断修改上次移动完成后坐标
                lastX = rawX;
                lastY = rawY;
                break;
            default:
                break;
        }
        return true;
    }
    private void moveView(int offsetX, int offsetY) {
        // 方法一
       //layout(getLeft() + offsetX, getTop() + offsetY, getRight() +
        //offsetX, getBottom() + offsetY);

        // 方法二
        // offsetLeftAndRight(offsetX);
        // offsetTopAndBottom(offsetY);

        // 方法三
        // LinearLayout.LayoutParams layoutParams = (LayoutParams)
        // getLayoutParams();
        // layoutParams.leftMargin = getLeft() + offsetX;
        // layoutParams.topMargin = getTop() + offsetY;
        // setLayoutParams(layoutParams);

        // 方法四
        // ViewGroup.MarginLayoutParams layoutParams = (MarginLayoutParams)
        // getLayoutParams();
        // layoutParams.leftMargin = getLeft() + offsetX;
        // layoutParams.topMargin = getLeft() + offsetY;
        // setLayoutParams(layoutParams);

        // 方法五
        ((View) getParent()).scrollBy(-offsetX, -offsetY);
    }*/

  /*  public  void settext(String text){
        this.Text=text;
    }*/
}
