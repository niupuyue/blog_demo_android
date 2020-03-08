package com.paulniu.selfview_demo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * 弹幕
 */
public class BarrageView extends LinearLayout {

    private static final int HANDLER_MSG_CODE_STAR_ANIM = 0;

    private static final int SHOW_RECENT_ITEM_LIMIT = 5;
    private static final int SHOW_RECENT_ITEM_DURATION = 2000;
    private static final int SHOW_RECENT_ITEM_MARGIN_TOP = 30;

    private Context mContext;
    private View mRoot;
    private LinearLayout llJobDetailBarrageContainer;
    private List<RecentApplyModel> recentTipViews;
    private Pools.SimplePool<TextView> recentTipsView;
    private BarrageHandler mHandler;

    private int index;
    private int offset;

    public BarrageView(Context context) {
        this(context, null);
    }

    public BarrageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BarrageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    // 初始化页面布局
    private void initView() {
        mRoot = LayoutInflater.from(mContext).inflate(R.layout.view_job_detail_barrage, this);
        llJobDetailBarrageContainer = mRoot.findViewById(R.id.llJobDetailBarrageContainer);

        // 设计开场动画
        LayoutTransition transition = new LayoutTransition();
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0, 1);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0, 1);

        ObjectAnimator valueAnimator = ObjectAnimator.ofPropertyValuesHolder(null, new PropertyValuesHolder[]{scaleX, scaleY})
                .setDuration(transition.getDuration(LayoutTransition.APPEARING));
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                ObjectAnimator objectAnimator = (ObjectAnimator) animation;
                View view = (View) objectAnimator.getTarget();
                view.setPivotX(0f);
                view.setPivotY(view.getMeasuredHeight());
            }
        });
        transition.setAnimator(LayoutTransition.APPEARING, valueAnimator);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(null, "alpha", 0, 1).setDuration(LayoutTransition.DISAPPEARING);
        transition.setAnimator(LayoutTransition.DISAPPEARING, objectAnimator);
        llJobDetailBarrageContainer.setLayoutTransition(transition);

        // 初始化Handler对象
        mHandler = new BarrageHandler(this);
    }

    /**
     * 获取最近消息的布局文件
     *
     * @return
     */
    private View getRecentTipsItem() {
        View tipView = recentTipsView.acquire();
        if (tipView == null) {
            tipView = LayoutInflater.from(mContext).inflate(R.layout.view_recent_tip, null);
        }
        return tipView;
    }

    /**
     * Handler对象，在这个class中完成每隔2秒钟弹出一个消息
     */
    private class BarrageHandler extends Handler {
        WeakReference<BarrageView> mWeakReference;

        // 构造方式初始化弱引用对象
        public BarrageHandler(BarrageView mWeakReference) {
            this.mWeakReference = new WeakReference(mWeakReference);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (recentTipViews.isEmpty()) {
                return;
            }
            // 判断当前发送的消息类型是否正确
            if (msg.what == HANDLER_MSG_CODE_STAR_ANIM) {

                if (llJobDetailBarrageContainer.getChildCount() == recentTipViews.size() && index <= offset) {
                    // 判断如果容器中存在5个子元素，并且当前下标小于等于偏移数据，则将第一个子元素移除掉
                    llJobDetailBarrageContainer.removeViewAt(0);
                } else if (index >= SHOW_RECENT_ITEM_LIMIT && index <= offset) {
                    // 如果下标大于5 并且下标小于等于偏移数据，移除容器中的第一个子元素
                    llJobDetailBarrageContainer.removeViewAt(0);
                }

                if (index < recentTipViews.size()) { // 如果当前下标小于需要显示的数据内容，则需要向容器中添加一个数据
                    View recentItem = getRecentTipsItem();
                    ImageView rivTipLogo = recentItem.findViewById(R.id.rivTipLogo);
                    TextView tvContent = recentItem.findViewById(R.id.tvContent);
                    // 填充数据内容
                    tvContent.setText(recentTipViews.get(index).name + recentTipViews.get(index).content);
                    rivTipLogo.setImageResource(R.mipmap.ic_avatar_default);
                    // 将recentItem添加到容器中
                    llJobDetailBarrageContainer.addView(recentItem);
                    // 设置上外边距为30px
                    LinearLayout.LayoutParams lp = (LayoutParams) recentItem.getLayoutParams();
                    lp.setMargins(0, SHOW_RECENT_ITEM_MARGIN_TOP, 0, 0);
                    // 延迟2秒钟添加一个新数据
                    sendEmptyMessageDelayed(0, SHOW_RECENT_ITEM_DURATION);
                    // 下标自增
                    index++;
                    recentItem = null;
                } else if (index <= offset) { // 如果已经将数据内容全部展示，后面为了能够让recentItem向上移动，向容器中添加空数据
                    View recentItem = getRecentTipsItem();
                    recentItem.setVisibility(View.INVISIBLE);
                    llJobDetailBarrageContainer.addView(recentItem);
                    LinearLayout.LayoutParams lp = (LayoutParams) recentItem.getLayoutParams();
                    lp.setMargins(0, SHOW_RECENT_ITEM_MARGIN_TOP, 0, 0);
                    sendEmptyMessageDelayed(0, SHOW_RECENT_ITEM_DURATION);
                    index++;
                } else {
                    // 弹幕弹窗显示完毕，自动关闭
                    stop();
                    return;
                }
                // 设置透明效果(因为五个item透明度没有规则，所以只能写死)
                setContianerAlpha();
            }
        }
    }

    // 设置每个子view的透明度(此处数据是写死的)
    private void setContianerAlpha() {
        if (llJobDetailBarrageContainer.getChildCount() == 1) {
            llJobDetailBarrageContainer.getChildAt(0).getBackground().setAlpha(148);
        } else if (llJobDetailBarrageContainer.getChildCount() == 2) {
            llJobDetailBarrageContainer.getChildAt(0).getBackground().setAlpha(46);
            llJobDetailBarrageContainer.getChildAt(1).getBackground().setAlpha(148);
        }
        if (llJobDetailBarrageContainer.getChildCount() == 3) {
            llJobDetailBarrageContainer.getChildAt(0).getBackground().setAlpha(46);
            llJobDetailBarrageContainer.getChildAt(1).getBackground().setAlpha(122);
            llJobDetailBarrageContainer.getChildAt(2).getBackground().setAlpha(148);
        } else if (llJobDetailBarrageContainer.getChildCount() == 4) {
            llJobDetailBarrageContainer.getChildAt(0).getBackground().setAlpha(46);
            llJobDetailBarrageContainer.getChildAt(1).getBackground().setAlpha(122);
            llJobDetailBarrageContainer.getChildAt(2).getBackground().setAlpha(148);
            llJobDetailBarrageContainer.getChildAt(3).getBackground().setAlpha(174);
        } else if (llJobDetailBarrageContainer.getChildCount() == 5) {
            llJobDetailBarrageContainer.getChildAt(0).getBackground().setAlpha(46);
            llJobDetailBarrageContainer.getChildAt(1).getBackground().setAlpha(122);
            llJobDetailBarrageContainer.getChildAt(2).getBackground().setAlpha(148);
            llJobDetailBarrageContainer.getChildAt(3).getBackground().setAlpha(174);
            llJobDetailBarrageContainer.getChildAt(4).getBackground().setAlpha(174);
        }
    }

    ////////////////////////////////////////////////////////////////////////////对外开放方法--必须实现//////////////////////////////////////////////////////////////////////

    /**
     * 开启动画，展示RecentTips
     * 先设置数据，再调用start()方法
     */
    public void start() {
        if (mHandler != null) {
            mHandler.sendEmptyMessage(HANDLER_MSG_CODE_STAR_ANIM);
        }
    }

    /**
     * 关闭动画
     */
    public void stop() {
        if (mHandler != null) {
            mHandler.removeMessages(HANDLER_MSG_CODE_STAR_ANIM);
        }
    }

    /**
     * 设置数据，将RecentApplyModel的集合数据传递过来即可
     *
     * @param recentTips
     */
    public void setRecentTips(List<RecentApplyModel> recentTips) {
        this.recentTipViews = recentTips;
        recentTipsView = new Pools.SimplePool<>(recentTipViews.size());
        offset = recentTipViews.size() * 2;
    }
    ////////////////////////////////////////////////////////////////////////////对外开放方法--必须实现//////////////////////////////////////////////////////////////////////

    static class RecentApplyModel {
        public String name;
        public String photo;
        public String content;
    }
}
