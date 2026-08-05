package imagecoverflow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.ArrayList;
import share.ResValue;

/* JADX INFO: loaded from: classes.dex */
public class MyCoverFlowAdapter extends CoverFlowAdapter {
    private boolean dataChanged;
    private Bitmap image1 = null;
    private Bitmap image2 = null;
    private ArrayList<Bitmap> imgList = new ArrayList<>();

    public MyCoverFlowAdapter(Context context) {
        this.imgList.add(BitmapFactory.decodeResource(context.getResources(), ResValue.getInstance().com_syu_radio));
        this.imgList.add(BitmapFactory.decodeResource(context.getResources(), ResValue.getInstance().com_syu_bt_btact));
        this.imgList.add(BitmapFactory.decodeResource(context.getResources(), ResValue.getInstance().com_syu_onekeynavi));
        this.imgList.add(BitmapFactory.decodeResource(context.getResources(), ResValue.getInstance().com_syu_music));
        this.imgList.add(BitmapFactory.decodeResource(context.getResources(), ResValue.getInstance().com_syu_settings));
        this.imgList.add(BitmapFactory.decodeResource(context.getResources(), ResValue.getInstance().com_syu_video));
        this.imgList.add(BitmapFactory.decodeResource(context.getResources(), ResValue.getInstance().com_syu_car));
        this.imgList.add(BitmapFactory.decodeResource(context.getResources(), ResValue.getInstance().com_syu_dvr));
        this.imgList.add(BitmapFactory.decodeResource(context.getResources(), ResValue.getInstance().com_syu_voice_voicelaunch));
        this.imgList.add(BitmapFactory.decodeResource(context.getResources(), ResValue.getInstance().net_easyconn));
    }

    public void changeBitmap() {
        this.dataChanged = true;
        notifyDataSetChanged();
    }

    @Override // imagecoverflow.CoverFlowAdapter
    public int getCount() {
        return this.imgList.size();
    }

    @Override // imagecoverflow.CoverFlowAdapter
    public Bitmap getImage(int position) {
        return this.imgList.get(position);
    }
}
