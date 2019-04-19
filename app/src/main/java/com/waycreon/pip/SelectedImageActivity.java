package com.waycreon.pip;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.commit451.nativestackblur.NativeStackBlur;
import com.google.android.gms.ads.InterstitialAd;
import com.myandroid.views.MultiTouchListener;
import com.rtugeek.android.colorseekbar.ColorSeekBar;
import com.squareup.picasso.Picasso;
import com.waycreon.pip.chiralcode.colorpicker.ColorPickerDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class SelectedImageActivity extends Activity {


    private static ArrayList<Struct> mArray_TextFont = new ArrayList<>();
    private static ArrayList<Struct> mArray_Frame = new ArrayList<>();
    private static ArrayList<Struct> mArray_FrameCat = new ArrayList<>();
    ImageView imageview_id;
    ImageView mFrameIv;
    ImageView mMovImage;
    Global mGlobal;
    GalleryImageAdapter galImageAdapter;
    Spinner mSpinner_text_style;
    ImageButton mIbtn_color_text;
    AutoResizeTextView mTv_text;
    //    AdView adView;
    String style[] = {"1.ttf", "2.ttf", "3.ttf", "4.ttf", "5.ttf", "6.ttf", "7.ttf", "8.ttf"};
    String styleFA[] = {"b_homa.ttf", "b_lotus.ttf", "b_mitra.ttf", "b_nazanin.ttf", "b_titr_bold.ttf", "b_yekan.ttf", "ghalam.ttf", "iran_nastaliq.ttf", "lotus.ttf", "yekan.ttf"};


    Integer[] iconImages_child = {
            R.drawable.i_child1,
            R.drawable.i_child2,
            R.drawable.i_child3,
            R.drawable.i_child4,
            R.drawable.i_child5,
            R.drawable.i_child6,
            R.drawable.i_child7,
            R.drawable.i_child8,
            R.drawable.i_child9,
            R.drawable.i_child10,
            R.drawable.i_child11,
            R.drawable.i_child12,
            R.drawable.i_child13,
            R.drawable.i_child14,
            R.drawable.i_child15,
            R.drawable.i_child16,
            R.drawable.i_child17,
            R.drawable.i_child18,
            R.drawable.i_child19,
    };

    Integer[] frameImages_child = {
            R.drawable.child1,
            R.drawable.child2,
            R.drawable.child3,
            R.drawable.child4,
            R.drawable.child5,
            R.drawable.child6,
            R.drawable.child7,
            R.drawable.child8,
            R.drawable.child9,
            R.drawable.child10,
            R.drawable.child11,
            R.drawable.child12,
            R.drawable.child13,
            R.drawable.child14,
            R.drawable.child15,
            R.drawable.child16,
            R.drawable.child17,
            R.drawable.child18,
            R.drawable.child19,
    };


    Integer[] maskImages_child = {
            R.drawable.child1m,
            R.drawable.child2m,
            R.drawable.child3m,
            R.drawable.child4m,
            R.drawable.child5m,
            R.drawable.child6m,
            R.drawable.child7m,
            R.drawable.child8m,
            R.drawable.child9m,
            R.drawable.child10m,
            R.drawable.child11m,
            R.drawable.child12m,
            R.drawable.child13m,
            R.drawable.child14m,
            R.drawable.child15m,
            R.drawable.child16m,
            R.drawable.child17m,
            R.drawable.child18m,
            R.drawable.child19m,
    };

    Integer[] iconImages_monasebat = {
            R.drawable.i_moharam1,
            R.drawable.i_moharam2,
            R.drawable.i_moharam3,
            R.drawable.i_moharam4,
            R.drawable.i_moharam5,
            R.drawable.i_moharam6,
    };

    Integer[] frameImages_monasebat = {
            R.drawable.moharam1,
            R.drawable.moharam2,
            R.drawable.moharam3,
            R.drawable.moharam4,
            R.drawable.moharam5,
            R.drawable.moharam6,
    };

    Integer[] maskImages_monasebat = {
            R.drawable.moharam1m,
            R.drawable.moharam2m,
            R.drawable.moharam3m,
            R.drawable.moharam4m,
            R.drawable.moharam5m,
            R.drawable.moharam6m,

    };

    Integer[] iconImages_love = {
            R.drawable.i_love1,
            R.drawable.i_love2,
            R.drawable.i_love3,
            R.drawable.i_love4,
            R.drawable.i_love5,
            R.drawable.i_love6,
    };

    Integer[] frameImages_love = {
            R.drawable.love1,
            R.drawable.love2,
            R.drawable.love3,
            R.drawable.love4,
            R.drawable.love5,
            R.drawable.love6,
    };

    Integer[] maskImages_love = {
            R.drawable.love1m,
            R.drawable.love2m,
            R.drawable.love3m,
            R.drawable.love4m,
            R.drawable.love5m,
            R.drawable.love6m,

    };
    Integer[] iconImages_nature = {
            R.drawable.i_flower1,
            R.drawable.i_flower2,
            R.drawable.i_flower3,
            R.drawable.i_flower4,
            R.drawable.i_flower5,
            R.drawable.i_flower6,
            R.drawable.i_flower7,
            R.drawable.i_flower8,
    };

    Integer[] frameImages_nature = {
            R.drawable.flower1,
            R.drawable.flower2,
            R.drawable.flower3,
            R.drawable.flower4,
            R.drawable.flower5,
            R.drawable.flower6,
            R.drawable.flower7,
            R.drawable.flower8,
    };

    Integer[] maskImages_nature = {
            R.drawable.flower1m,
            R.drawable.flower2m,
            R.drawable.flower3m,
            R.drawable.flower4m,
            R.drawable.flower5m,
            R.drawable.flower6m,
            R.drawable.flower7m,
            R.drawable.flower8m,

    };
    Integer[] iconImages_birthday = {
            R.drawable.i_birthday1,
            R.drawable.i_birthday2,
            R.drawable.i_birthday3,
            R.drawable.i_birthday4,
            R.drawable.i_birthday5,
            R.drawable.i_birthday6,
            R.drawable.i_birthday7,
            R.drawable.i_birthday8,
            R.drawable.i_birthday9,
            R.drawable.i_birthday10,
    };

    Integer[] frameImages_birthday = {
            R.drawable.birthday1,
            R.drawable.birthday2,
            R.drawable.birthday3,
            R.drawable.birthday4,
            R.drawable.birthday5,
            R.drawable.birthday6,
            R.drawable.birthday7,
            R.drawable.birthday8,
            R.drawable.birthday9,
            R.drawable.birthday10,
    };

    Integer[] maskImages_birthday = {
            R.drawable.birthday1m,
            R.drawable.birthday2m,
            R.drawable.birthday3m,
            R.drawable.birthday4m,
            R.drawable.birthday5m,
            R.drawable.birthday6m,
            R.drawable.birthday7m,
            R.drawable.birthday8m,
            R.drawable.birthday9m,
            R.drawable.birthday10m,

    };

    int currentimg = 0;
    int currentalpha = 25;

    Bitmap mask;
    Bitmap result;
    Bitmap original;


    FrameLayout frotext;
    EditText et_view;
    Bitmap bm;
    AlertDialog builder;
    private InterstitialAd interstitial;
    private RecyclerView mRecyclerView_FrameCat;
    private Adapter_Recycler mAdapter_FrameCat;
    private RecyclerView mRecyclerView_Frame;
    private Adapter_Recycler mAdapter_Frame;
    private Dialog dialog;
    private LinearLayout mLinearLayout_TextOption;
    private RecyclerView mRecyclerView_TextFont;
    private Adapter_Recycler mAdapter_TextFont;
    private LinearLayout mLinearLayout_TextFontEn;
    private LinearLayout mLinearLayout_TextFontColor;
    private ColorSeekBar colorSlider;
    private LinearLayout mLinearLayout_FontColor;
    private LinearLayout mLinearLayout_TextFontFa;
    private RelativeLayout mRelativeLayout_TextLayout;
    private TextView mTextView_Done;
    private Typeface face;
    private int selectedColor = Color.parseColor("#E43E4C");
    private LinearLayout mLinearLayout_textIndicator;
    private LinearLayout mLinearLayout_frameIndicator;
    private LinearLayout mLinearLayout_EditLayout;
    private ImageView mImageView_EditText;
    private ImageView mImageView_DeleteText;
    private int mIntPosition = 0;
    private TextView mTextView_Delete;
    private Typeface type;
    private TextView mTextView_buttonText;
    private TextView mTextView_buttonFrame;
    private TextView mTextView_ColorFont;
    private TextView mTextView_FAfont;
    private TextView mTextView_ENfont;
    private String textBackup = "";
    private Dialog dialog_premium;
    private FloatingActionButton mFab_Main;
    private int Selected;
    private ImageView mImageView_EN;
    private ImageView mImageView_FA;
    private ImageView mImageView_Color;
    private boolean ColorIsSelected = false;
    private boolean FAIsSelected = false;
    private Dialog dialog_save;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_image);
        face = Typeface.createFromAsset(getAssets(), "1.ttf");
        type = Typeface.createFromAsset(getAssets(), "iran_sans_regular.ttf");

        // premium Dialog
        dialog_save = new Dialog(SelectedImageActivity.this);
        dialog_save.setContentView(R.layout.dialog_save);
        dialog_save.setTitle("Custom Dialog");
        TextView txt1 = (TextView) dialog_save.findViewById(R.id.dialog_txt1);
        TextView ok = (TextView) dialog_save.findViewById(R.id.btn_ok);
        txt1.setTypeface(type);
        ok.setTypeface(type);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_save.dismiss();
            }
        });


        // premium Dialog
        dialog_premium = new Dialog(SelectedImageActivity.this);
        dialog_premium.setContentView(R.layout.dialog_upgrade);
        dialog_premium.setTitle("Custom Dialog");
        TextView dialog_txt = (TextView) dialog_premium.findViewById(R.id.dialog_txt);
        TextView dialog_txt1 = (TextView) dialog_premium.findViewById(R.id.dialog_txt1);
        TextView cancel = (TextView) dialog_premium.findViewById(R.id.cancel);
        TextView get_code = (TextView) dialog_premium.findViewById(R.id.premium);

        dialog_txt.setTypeface(type);
        dialog_txt1.setTypeface(type);
        cancel.setTypeface(type);
        get_code.setTypeface(type);

        mFab_Main = (FloatingActionButton) findViewById(R.id.activity_soot_fab_main);

        mFab_Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFab_Main.setVisibility(View.GONE);

                mLinearLayout_EditLayout.setVisibility(View.GONE);
                mRelativeLayout_TextLayout.setVisibility(View.VISIBLE);
                et_view.setSelection(et_view.getText().toString().length());
                mTv_text.setVisibility(View.INVISIBLE);
                et_view.setText("" + mTv_text.getText().toString().trim());
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInputFromWindow(et_view.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);

                et_view.requestFocus();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_premium.dismiss();
            }
        });
        get_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Global.isLimited = false;
                dialog_premium.dismiss();
                Intent intent = new Intent(SelectedImageActivity.this, ActivityGoPremium.class);
                SelectedImageActivity.this.startActivity(intent);
//                finish();
//                if (G.isLimited) {
//                    houseTemperatureCard.setVisibility(View.GONE);
//                    houseToolsCard.setVisibility(View.GONE);
//                    houseBuildCard.setVisibility(View.GONE);
//                    houseUnitCard.setVisibility(View.GONE);
//                    houseUnitDesc.setVisibility(View.GONE);
//                } else {
//                    houseTemperatureCard.setVisibility(View.VISIBLE);
//                    houseToolsCard.setVisibility(View.VISIBLE);
//                    houseBuildCard.setVisibility(View.VISIBLE);
//                    houseUnitCard.setVisibility(View.VISIBLE);
//                    houseUnitDesc.setVisibility(View.VISIBLE);
//                }
            }
        });

        mLinearLayout_frameIndicator = (LinearLayout) findViewById(R.id.frame_indicator);
        mLinearLayout_textIndicator = (LinearLayout) findViewById(R.id.text_indicator);
        mTextView_buttonFrame = (TextView) findViewById(R.id.toolbar_icons_txt_frame);
        mTextView_buttonText = (TextView) findViewById(R.id.toolbar_icons_txt_text);
        mTextView_ENfont = (TextView) findViewById(R.id.en_font);
        mTextView_FAfont = (TextView) findViewById(R.id.fa_font);
        mTextView_ColorFont = (TextView) findViewById(R.id.color_font);
        mImageView_EN = (ImageView) findViewById(R.id.img_en);
        mImageView_FA = (ImageView) findViewById(R.id.img_fa);
        mImageView_Color = (ImageView) findViewById(R.id.img_color);
        mTextView_buttonFrame.setTypeface(type);
        mTextView_buttonText.setTypeface(type);
        mTextView_ENfont.setTypeface(type);
        mTextView_FAfont.setTypeface(type);
        mTextView_ColorFont.setTypeface(type);
//Text
        dialog = new Dialog(SelectedImageActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.text_custom_dialog);
        dialog.setCancelable(false);
        et_view = (EditText) findViewById(R.id.et_view);

        mLinearLayout_TextOption = (LinearLayout) findViewById(R.id.text_options_ll);
        mRelativeLayout_TextLayout = (RelativeLayout) findViewById(R.id.text_layout);
        mLinearLayout_EditLayout = (LinearLayout) findViewById(R.id.edit_layout);
        mImageView_EditText = (ImageView) findViewById(R.id.edit_text);
        mImageView_DeleteText = (ImageView) findViewById(R.id.delete_text);
        mImageView_EditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBackup = et_view.getText().toString();
                mLinearLayout_EditLayout.setVisibility(View.GONE);
                mRelativeLayout_TextLayout.setVisibility(View.VISIBLE);
                et_view.setSelection(et_view.getText().toString().length());
                mTv_text.setVisibility(View.INVISIBLE);
                et_view.setText("" + mTv_text.getText().toString().trim());
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInputFromWindow(et_view.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);

                et_view.requestFocus();
            }
        });
        mImageView_DeleteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFab_Main.setVisibility(View.VISIBLE);

                mTv_text.setText("");
                et_view.setText("");
                textBackup = "";
                mLinearLayout_EditLayout.setVisibility(View.GONE);
            }
        });

        mTv_text = (AutoResizeTextView) findViewById(R.id.resizable_text);
        mTv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRelativeLayout_TextLayout.setVisibility(View.VISIBLE);
                mTv_text.setVisibility(View.INVISIBLE);
            }
        });
        mTv_text.setOnTouchListener(new MultiTouchListener());

        mTextView_Done = (TextView) findViewById(R.id.done);
        mTextView_Delete = (TextView) findViewById(R.id.delete);
        mTextView_Done.setTypeface(type);
        mTextView_Delete.setTypeface(type);
        mTextView_Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_view.getText().toString().length() > 0) {
                    mRelativeLayout_TextLayout.setVisibility(View.GONE);
                    mTv_text.setVisibility(View.VISIBLE);
                    mLinearLayout_EditLayout.setVisibility(View.VISIBLE);
                    String s = et_view.getText().toString();

                    mTv_text.setText(s);
                    mTv_text.setTextSize(500);
                    mTv_text.setTextColor(selectedColor);
                    mTv_text.setTypeface(face);
                } else {
                    mRelativeLayout_TextLayout.setVisibility(View.GONE);
                    String s = et_view.getText().toString();
                    mFab_Main.setVisibility(View.VISIBLE);

                    mTv_text.setText(s);
                }

                View view = SelectedImageActivity.this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(SelectedImageActivity.this.getCurrentFocus().getWindowToken(), 0);
                }
            }
        });
        mTextView_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (textBackup.equals("clear")) {
//                }else {
                mTv_text.setText(textBackup);
                et_view.setText(textBackup);
                if (textBackup.length() > 0) {
                    mTv_text.setVisibility(View.VISIBLE);
                    mLinearLayout_EditLayout.setVisibility(View.VISIBLE);
                }
                mRelativeLayout_TextLayout.setVisibility(View.GONE);
//                if (et_view.getText().toString().length() > 0) {
//                    mTv_text.setVisibility(View.VISIBLE);
//                    mLinearLayout_EditLayout.setVisibility(View.VISIBLE);
//                    String s = et_view.getText().toString();
//
//                    mTv_text.setText(s);
//                    mTv_text.setTextSize(500);
//                    mTv_text.setTextColor(selectedColor);
//                    mTv_text.setTypeface(face);
//                } else {
//                    mRelativeLayout_TextLayout.setVisibility(View.GONE);
//                    String s = et_view.getText().toString();
//
//                    mTv_text.setText(s);
//                }

                View view = SelectedImageActivity.this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(SelectedImageActivity.this.getCurrentFocus().getWindowToken(), 0);
                }
            }
        });

        mLinearLayout_TextFontEn = (LinearLayout) findViewById(R.id.text_option_ll_en_font);
        mLinearLayout_TextFontFa = (LinearLayout) findViewById(R.id.text_option_ll_fa_font);
        mLinearLayout_TextFontColor = (LinearLayout) findViewById(R.id.text_option_ll_font_color);
        mLinearLayout_FontColor = (LinearLayout) findViewById(R.id.text_color_ll);

        colorSlider = (ColorSeekBar) findViewById(R.id.colorSlider);
        colorSlider.setMaxPosition(100);
        colorSlider.setColorSeeds(R.array.material_colors); // material_colors is defalut included in res/color,just use it.
        colorSlider.setColorBarPosition(2); //0 - maxValue
        colorSlider.setAlphaBarPosition(10); //0 - 255
        colorSlider.setShowAlphaBar(true);
        colorSlider.setBarHeight(5); //5dpi
        colorSlider.setThumbHeight(30); //30dpi
        colorSlider.setBarMargin(10); //set the margin between colorBar and alphaBar 10dpi
        int x = colorSlider.getColorIndexPosition(Color.parseColor("#c0c0c0"));
        Log.d("sssss", String.valueOf(x));
        colorSlider.setOnColorChangeListener(new ColorSeekBar.OnColorChangeListener() {
            @Override
            public void onColorChangeListener(int colorBarPosition, int alphaBarPosition, int color) {
//                Log.d("color",String.valueOf(color));
                int code = colorSlider.getColorIndexPosition(color);
                Log.d("color1", String.valueOf(code));
                selectedColor = color;
                et_view.setTextColor(color);
                mTv_text.setTextColor(color);


                //colorSeekBar.getAlphaValue();
            }
        });
//        colorSlider.setOnInitDoneListener(new ColorSeekBar.OnInitDoneListener() {
//            @Override
//            public void done() {
//                colorSlider.getColorIndexPosition(mColor);
//                //mColorSeekBar.getColors();
//                //mColorSeekBar.getColor();
//            }
//        });

        mLinearLayout_TextFontEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ColorIsSelected = false;
                FAIsSelected = false;

                mImageView_EN.setColorFilter(getResources().getColor(R.color.pink));
                mImageView_FA.setColorFilter(getResources().getColor(R.color.black));
                mImageView_Color.setColorFilter(getResources().getColor(R.color.black));
                mTextView_ENfont.setTextColor(getResources().getColor(R.color.pink));
                mTextView_FAfont.setTextColor(getResources().getColor(R.color.black));
                mTextView_ColorFont.setTextColor(getResources().getColor(R.color.black));

                mArray_TextFont.clear();
                for (int i = 0; i < style.length; i++) {
                    Struct struct = new Struct();
                    struct.strTitle = style[i];
                    struct.strKEY = "Isatel";
                    if (i > 4) {
                        struct.strValue = "lock";
                    } else {
                        struct.strValue = "unlock";
                    }
                    mArray_TextFont.add(struct);
                }
                mAdapter_TextFont.notifyDataSetChanged();

                mRecyclerView_TextFont.setVisibility(View.VISIBLE);
                mLinearLayout_FontColor.setVisibility(View.GONE);
            }
        });
        mLinearLayout_TextFontFa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorIsSelected = false;
                FAIsSelected = true;

                mImageView_EN.setColorFilter(getResources().getColor(R.color.black));
                mImageView_FA.setColorFilter(getResources().getColor(R.color.pink));
                mImageView_Color.setColorFilter(getResources().getColor(R.color.black));
                mTextView_ENfont.setTextColor(getResources().getColor(R.color.black));
                mTextView_FAfont.setTextColor(getResources().getColor(R.color.pink));
                mTextView_ColorFont.setTextColor(getResources().getColor(R.color.black));

                mArray_TextFont.clear();
                for (int i = 0; i < styleFA.length; i++) {
                    Struct struct = new Struct();
                    struct.strTitle = styleFA[i];
                    struct.strKEY = "ایساتل";
                    if (i > 4) {
                        struct.strValue = "lock";
                    } else {
                        struct.strValue = "unlock";
                    }

                    mArray_TextFont.add(struct);
                }
                mAdapter_TextFont.notifyDataSetChanged();

                mRecyclerView_TextFont.setVisibility(View.VISIBLE);
                mLinearLayout_FontColor.setVisibility(View.GONE);
            }
        });
        mLinearLayout_TextFontColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorIsSelected = true;
                FAIsSelected = false;
                mImageView_EN.setColorFilter(getResources().getColor(R.color.black));
                mImageView_FA.setColorFilter(getResources().getColor(R.color.black));
                mImageView_Color.setColorFilter(getResources().getColor(R.color.pink));
                mTextView_ENfont.setTextColor(getResources().getColor(R.color.black));
                mTextView_FAfont.setTextColor(getResources().getColor(R.color.black));
                mTextView_ColorFont.setTextColor(getResources().getColor(R.color.pink));

                mRecyclerView_TextFont.setVisibility(View.GONE);
                mLinearLayout_FontColor.setVisibility(View.VISIBLE);
            }
        });


        for (int i = 0; i < style.length; i++) {
            Struct struct = new Struct();
            struct.strTitle = style[i];
            if (i > 4) {
                struct.strValue = "lock";
            } else {
                struct.strValue = "unlock";
            }
            mArray_TextFont.add(struct);
        }

        mRecyclerView_TextFont = (RecyclerView) findViewById(R.id.text_font_rv);
        LinearLayoutManager mLayoutManager_TextFont = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mAdapter_TextFont = new Adapter_Recycler(getApplicationContext(), mArray_TextFont, new OnItemListener() {
            @Override
            public void onItemSelect(int position) {
                dialog_premium.show();
            }

            @Override
            public void onItemClick(int position) {
                if (et_view.getText().toString().length() < 1) {
                    mFab_Main.setVisibility(View.GONE);

//                    textBackup = "clear";
                    mLinearLayout_EditLayout.setVisibility(View.GONE);
                    mRelativeLayout_TextLayout.setVisibility(View.VISIBLE);
                    et_view.setSelection(et_view.getText().toString().length());
                    mTv_text.setVisibility(View.INVISIBLE);
                    et_view.setText("" + mTv_text.getText().toString().trim());
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.toggleSoftInputFromWindow(et_view.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);

                    et_view.requestFocus();
                }
                face = Typeface.createFromAsset(getAssets(), mArray_TextFont.get(position).strTitle);
                et_view.setTypeface(face);
                mTv_text.setTypeface(face);
//                mRecyclerView_Frame.setVisibility(View.VISIBLE);
            }
        }, 1, false);

        mRecyclerView_TextFont.setLayoutManager(mLayoutManager_TextFont);
        mRecyclerView_TextFont.setAdapter(mAdapter_TextFont);

//Frame
        final String[] names = new String[]{"عاشقانه", "بچگانه", "طبیعت", "مناسبتی", "تولد"};
        final int[] icons = new int[]{R.drawable.favorite, R.drawable.kid, R.drawable.nature, R.drawable.calendar, R.drawable.cake};
        for (int i = 0; i < 5; i++) {
            Struct struct = new Struct();
            struct.intSource = icons[i];
            struct.strTitle = names[i];
            if (i == 0) {
                struct.intColor = getResources().getColor(R.color.pink);
            } else {
                struct.intColor = getResources().getColor(R.color.black);
            }
            mArray_FrameCat.add(struct);
        }

        for (int i = 0; i < iconImages_love.length; i++) {
            Struct struct = new Struct();
            struct.intSource = iconImages_love[i];
            if (i > 4) {
                struct.strValue = "lock";
            } else {
                struct.strValue = "unlock";
            }
            mArray_Frame.add(struct);
        }


        mRecyclerView_FrameCat = (RecyclerView) findViewById(R.id.frame_cat_rv);
        LinearLayoutManager mLayoutManager_FrameCat = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mAdapter_FrameCat = new Adapter_Recycler(getApplicationContext(), mArray_FrameCat, new OnItemListener() {
            @Override
            public void onItemSelect(int position) {

            }

            @Override
            public void onItemClick(int position) {
                mArray_FrameCat.clear();
                for (int i = 0; i < 5; i++) {
                    Struct struct = new Struct();
                    struct.intSource = icons[i];
                    struct.strTitle = names[i];
                    if (i == position) {
                        struct.intColor = getResources().getColor(R.color.pink);
                    } else {
                        struct.intColor = getResources().getColor(R.color.black);
                    }
                    mArray_FrameCat.add(struct);
                }
                mAdapter_FrameCat.notifyDataSetChanged();


                mRecyclerView_Frame.setVisibility(View.VISIBLE);
                mIntPosition = position;
                switch (position) {
                    case 0:
                        mArray_Frame.clear();
                        for (int i = 0; i < iconImages_love.length; i++) {
                            Struct struct = new Struct();
                            struct.intSource = iconImages_love[i];
                            if (i > 4) {
                                struct.strValue = "lock";
                            } else {
                                struct.strValue = "unlock";
                            }
                            mArray_Frame.add(struct);
                        }
                        mAdapter_Frame.notifyDataSetChanged();
                        break;
                    case 1:
                        mArray_Frame.clear();
                        for (int i = 0; i < iconImages_child.length; i++) {
                            Struct struct = new Struct();
                            struct.intSource = iconImages_child[i];
                            if (i > 4) {
                                struct.strValue = "lock";
                            } else {
                                struct.strValue = "unlock";
                            }
                            mArray_Frame.add(struct);
                        }
                        mAdapter_Frame.notifyDataSetChanged();
                        break;
                    case 2:
                        mArray_Frame.clear();
                        for (int i = 0; i < iconImages_nature.length; i++) {
                            Struct struct = new Struct();
                            struct.intSource = iconImages_nature[i];
                            if (i > 4) {
                                struct.strValue = "lock";
                            } else {
                                struct.strValue = "unlock";
                            }
                            mArray_Frame.add(struct);
                        }
                        mAdapter_Frame.notifyDataSetChanged();
                        break;
                    case 3:
                        mArray_Frame.clear();
                        for (int i = 0; i < iconImages_monasebat.length; i++) {
                            Struct struct = new Struct();
                            struct.intSource = iconImages_monasebat[i];
                            if (i > 4) {
                                struct.strValue = "lock";
                            } else {
                                struct.strValue = "unlock";
                            }
                            mArray_Frame.add(struct);
                        }
                        mAdapter_Frame.notifyDataSetChanged();
                        break;
                    case 4:
                        mArray_Frame.clear();
                        for (int i = 0; i < iconImages_birthday.length; i++) {
                            Struct struct = new Struct();
                            struct.intSource = iconImages_birthday[i];
                            if (i > 4) {
                                struct.strValue = "lock";
                            } else {
                                struct.strValue = "unlock";
                            }
                            mArray_Frame.add(struct);
                        }
                        mAdapter_Frame.notifyDataSetChanged();
                        break;
                }
            }
        }, 2, false);

        mRecyclerView_FrameCat.setLayoutManager(mLayoutManager_FrameCat);
        mRecyclerView_FrameCat.setAdapter(mAdapter_FrameCat);

        mRecyclerView_Frame = (RecyclerView) findViewById(R.id.frame_rv);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mAdapter_Frame = new Adapter_Recycler(getApplicationContext(), mArray_Frame, new OnItemListener() {
            @Override
            public void onItemSelect(int position) {
                dialog_premium.show();
            }

            @Override
            public void onItemClick(int position) {
                Selected = position;

                switch (mIntPosition) {
                    case 0:
                        makeMaskImage(imageview_id, maskImages_love[position], frameImages_love[position]);
                        break;
                    case 1:
                        makeMaskImage(imageview_id, maskImages_child[position], frameImages_child[position]);
                        break;
                    case 2:
                        makeMaskImage(imageview_id, maskImages_nature[position], frameImages_nature[position]);
                        break;
                    case 3:
                        makeMaskImage(imageview_id, maskImages_monasebat[position], frameImages_monasebat[position]);
                        break;
                    case 4:
                        makeMaskImage(imageview_id, maskImages_birthday[position], frameImages_birthday[position]);
                        break;
                }
                currentimg = position;
            }
        }, 3, false);

        mRecyclerView_Frame.setLayoutManager(mLayoutManager);
        mRecyclerView_Frame.setAdapter(mAdapter_Frame);


//        adView = (AdView) this.findViewById(R.id.ads);
//        AdRequest adRequest = new AdRequest.Builder().build();


//        interstitial = new InterstitialAd(this);
//        interstitial.setAdUnitId(getResources().getString(R.string.admob_intersitials));
//        interstitial.loadAd(adRequest);
//
//        // Load ads into Interstitial Ads
//        interstitial.setAdListener(new AdListener() {
//            public void onAdLoaded() {
//                // Call displayInterstitial() function
//                interstitial.show();
//
//            }
//        });


//        try {
//            adView.loadAd(adRequest);
//        } catch (Exception e) {
//        }

        galImageAdapter = new GalleryImageAdapter(this);

        imageview_id = (ImageView) findViewById(R.id.imageview_id);
        mMovImage = (ImageView) findViewById(R.id.iv_mov);
        mFrameIv = (ImageView) findViewById(R.id.mFrameIv);

        mGlobal = ((Global) getApplication());
        //RUNTIME

        mMovImage.setImageBitmap(mGlobal.getImage());

//        mask = BitmapFactory.decodeResource(getResources(), maskImages_child[0]);    //masking
//        result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Config.ARGB_8888);
//        bm = mGlobal.getImage();
//        original = NativeStackBlur.process(getResizedBitmap(mask.getWidth(), mask.getHeight()), currentalpha);
//        Canvas mCanvas = new Canvas(result);
//        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
//        mCanvas.drawBitmap(original, 0, 0, null);
////        mCanvas.drawBitmap(mask, 0, 0, paint);
//        paint.setXfermode(null);

        imageview_id.setImageBitmap(mGlobal.getImage());
//        makeMaskImage(imageview_id, maskImages_child[0], frameImages_child[0]);
        imageview_id.setScaleType(ScaleType.CENTER_CROP);

        mMovImage.setOnTouchListener(new MultiTouchListener());
        mMovImage.setVisibility(View.INVISIBLE);

    }


    public void toolbar_icons_ll_text(View v) {
        mRecyclerView_TextFont.setVisibility(View.VISIBLE);

        if (ColorIsSelected) {
            mImageView_EN.setColorFilter(getResources().getColor(R.color.black));
            mImageView_FA.setColorFilter(getResources().getColor(R.color.black));
            mImageView_Color.setColorFilter(getResources().getColor(R.color.pink));
            mTextView_ENfont.setTextColor(getResources().getColor(R.color.black));
            mTextView_FAfont.setTextColor(getResources().getColor(R.color.black));
            mTextView_ColorFont.setTextColor(getResources().getColor(R.color.pink));
            mRecyclerView_TextFont.setVisibility(View.GONE);
            mLinearLayout_FontColor.setVisibility(View.VISIBLE);

        }else if(FAIsSelected){
            mImageView_EN.setColorFilter(getResources().getColor(R.color.black));
            mImageView_FA.setColorFilter(getResources().getColor(R.color.pink));
            mImageView_Color.setColorFilter(getResources().getColor(R.color.black));
            mTextView_ENfont.setTextColor(getResources().getColor(R.color.black));
            mTextView_FAfont.setTextColor(getResources().getColor(R.color.pink));
            mTextView_ColorFont.setTextColor(getResources().getColor(R.color.black));
            mRecyclerView_TextFont.setVisibility(View.VISIBLE);

            mArray_TextFont.clear();
            for (int i = 0; i < styleFA.length; i++) {
                Struct struct = new Struct();
                struct.strTitle = styleFA[i];
                struct.strKEY = "ایساتل";
                if (i > 4) {
                    struct.strValue = "lock";
                } else {
                    struct.strValue = "unlock";
                }
                mArray_TextFont.add(struct);
            }
            mAdapter_TextFont.notifyDataSetChanged();
            mLinearLayout_FontColor.setVisibility(View.GONE);
        }

        if (et_view.getText().toString().length() > 0) {
            mLinearLayout_EditLayout.setVisibility(View.VISIBLE);
        } else {
            mFab_Main.setVisibility(View.VISIBLE);
        }
        mLinearLayout_frameIndicator.setVisibility(View.INVISIBLE);
        mLinearLayout_textIndicator.setVisibility(View.VISIBLE);

        mRecyclerView_FrameCat.setVisibility(View.GONE);
        mRecyclerView_Frame.setVisibility(View.GONE);

        mLinearLayout_TextOption.setVisibility(View.VISIBLE);
        mArray_TextFont.clear();
        for (int i = 0; i < style.length; i++) {
            Struct struct = new Struct();
            struct.strTitle = style[i];
            struct.strKEY = "ab";
            if (i > 4) {
                struct.strValue = "lock";
            } else {
                struct.strValue = "unlock";
            }
            mArray_TextFont.add(struct);
        }
        mAdapter_TextFont.notifyDataSetChanged();
        mRecyclerView_TextFont.setVisibility(View.VISIBLE);
//        String off_id = "", unm = "", pass = "";
//        // test dialog
//        RelativeLayout.LayoutParams mParams1;
//        // Set dialog title

//        dialog.setTitle("Text Appearance");
//        dialog.show();
//        mSpinner_text_style = (Spinner) dialog.findViewById(R.id.spinner_text_style);
//        mIbtn_color_text = (ImageButton) dialog.findViewById(R.id.ibtn_color_text);
//
//        MyAdapter adapter = new MyAdapter(SelectedImageActivity.this, R.layout.spinner_row, style);
//        mSpinner_text_style.setAdapter(adapter);
//
//        mSpinner_text_style.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> arg0,
//                                       View arg1, int arg2, long arg3) {
//                // TODO Auto-generated method stub
//                mGlobal.setPosition(arg2);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });

//        mIbtn_color_text.setBackgroundColor(mGlobal.getColor());
//
//        mIbtn_color_text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                showColorPickerDialogDemo();
//
//            }
//        });


//        Button declineButton = (Button) dialog.findViewById(R.id.btn_cancel);
//        // if decline button is clicked, close the custom dialog
//        declineButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // Close dialog
//                dialog.dismiss();
//            }
//        });
//
//        Button Ok = (Button) dialog.findViewById(R.id.btn_ok);
//        // if decline button is clicked, close the custom dialog
//        Ok.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // Close dialog
//
//                mTv_text.setTextColor(mGlobal.getColor());
//                Typeface face = Typeface.createFromAsset(getAssets(), style[mGlobal.getPosition()]);
//
//                mTv_text.setTypeface(face);
//
//                String s = et_view.getText().toString().trim();
//
//                mTv_text.setText(s);
//                dialog.dismiss();
//
//
//            }
//        });

        // ===========================================

//        mTv_text.setTextSize(58);
//        mTv_text.setOnTouchListener(new MultiTouchListener());
    }

    public void toolbar_icons_ll_frame(View view) {
        mLinearLayout_EditLayout.setVisibility(View.GONE);
        mLinearLayout_frameIndicator.setVisibility(View.VISIBLE);
        mLinearLayout_textIndicator.setVisibility(View.INVISIBLE);

        mRelativeLayout_TextLayout.setVisibility(View.GONE);
        mLinearLayout_TextOption.setVisibility(View.GONE);
        mRecyclerView_TextFont.setVisibility(View.GONE);
        mLinearLayout_FontColor.setVisibility(View.GONE);

        mRecyclerView_FrameCat.setVisibility(View.VISIBLE);
        mRecyclerView_Frame.setVisibility(View.VISIBLE);
        mFab_Main.setVisibility(View.GONE);
        // Prepare grid view
//        GridView gridView = new GridView(this);
//        gridView.setAdapter(new ArrayAdapter(this, R.layout.single_image, iconImages_child) {
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//
//                ViewHolder holder;
//
//                ImageView imageView;
//
//                if (convertView == null) {
//
//                    holder = new ViewHolder();
//
//                    imageView = new ImageView(getApplicationContext());
//
//                    imageView.setPadding(3, 3, 3, 3);
//
//                    convertView = imageView;
//
//                    holder.imageView = imageView;
//
//                    convertView.setTag(holder);
//
//                } else {
//
//                    holder = (ViewHolder) convertView.getTag();
//                }
//
//                Picasso.with(getApplicationContext()).load(iconImages_child[position]).into(holder.imageView);
//                holder.imageView.setScaleType(ScaleType.CENTER_INSIDE);
//                //    holder.imageView.setLayoutParams(new Gallery.LayoutParams(200, 200));
//                //  holder.imageView.setBackgroundResource(imageBackground);
//                return holder.imageView;
//            }
//        });
//        gridView.setNumColumns(2);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
//                // do something here
//
//                makeMaskImage(imageview_id, maskImages_child[i], frameImages_child[i]);
//                currentimg = i;
//                builder.dismiss();
//            }
//
//
//        });
//
//        // Set grid view to alertDialog
//
//
//        builder = new AlertDialog.Builder(this).create();
//        builder.setView(gridView);
//        builder.setTitle("Select frame");
//        builder.show();
//

    }

    //adapter

    //Method of creating mask runtime
    public void makeMaskImage(ImageView mImageView, int maskimg, int frame) {
        mMovImage.setVisibility(View.VISIBLE);

        mFrameIv.setBackgroundResource(frame); // frame of image


        try {
            result.recycle();
            result = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mask.recycle();
            mask = null;
        } catch (Exception e) {

        }


        mask = BitmapFactory.decodeResource(getResources(), maskimg);    //masking
        result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Config.ARGB_8888);
        bm = mGlobal.getImage();

        original = NativeStackBlur.process(getResizedBitmap(mask.getWidth(), mask.getHeight()), currentalpha);

        Canvas mCanvas = new Canvas(result);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

        mCanvas.drawBitmap(original, 0, 0, null);
        mCanvas.drawBitmap(mask, 0, 0, paint);
        paint.setXfermode(null);

        imageview_id.setImageBitmap(result);
        mImageView.setScaleType(ScaleType.CENTER_INSIDE);


        try {
            mask.recycle();
            mask = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bm.recycle();
            bm = null;
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            original.recycle();
            original = null;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SelectedImageActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public Bitmap getResizedBitmap(int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();

        float scaleWidth;
        float scaleHeight;


        if (width < height) {

            scaleWidth = ((float) newWidth) / width;
            scaleHeight = scaleWidth;

        } else {    // width >height

            scaleHeight = ((float) newHeight) / height;
            scaleWidth = scaleHeight;

        }

        Matrix matrix = new Matrix();
// RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);
        // RECREATE THE NEW BITMAP
        bm = Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, false);
        return bm;
    }


    public void back(View view) {
        onBackPressed();
    }

    public void save(View view) {
        dialog_save.show();
        captureImage();
    }

    public void share(View view) {


        File fileWithinMyDir = captureImage();

        Intent sharingIntent = new Intent(
                android.content.Intent.ACTION_SEND);
        Uri screenshotUri = Uri.fromFile(fileWithinMyDir);
        sharingIntent.setType("image/*");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
        startActivity(Intent.createChooser(sharingIntent,
                "Share image using"));
    }

    //
    private File captureImage() {
        // TODO Auto-generated method stub
        OutputStream output;

        Calendar cal = Calendar.getInstance();
        RelativeLayout capturelayout = (RelativeLayout) findViewById(R.id.rl);

        Bitmap bitmap = Bitmap.createBitmap(capturelayout.getWidth(), capturelayout.getHeight(),
                Bitmap.Config.ARGB_8888);

		/*
         * bitmap = ThumbnailUtils.extractThumbnail(bitmap, ll1.getWidth(),
		 * ll1.getHeight());
		 */
        Canvas b = new Canvas(bitmap);
        capturelayout.draw(b);

        // Find the SD Card path
        File filepath = Environment.getExternalStorageDirectory();

        // Create a new folder in SD Card
        File dir = new File(filepath.getAbsolutePath() + "/PIPIMAGE/");
        dir.mkdirs();

        String mImagename = "image" + cal.getTimeInMillis() + ".png";

        // Create a name for the saved image
        File file = new File(dir, mImagename);

        MediaScannerConnection.scanFile(this, new String[]{file.getPath()},
                null, new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        // now visible in gallery
                    }
                });

        // Show a toast message on successful save
        Toast.makeText(SelectedImageActivity.this, "Image Saved to SD Card",
                Toast.LENGTH_SHORT).show();

        try {

            output = new FileOutputStream(file);
            // Compress into png format image from 0% - 100%
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
            output.flush();
            output.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return file;

    }


    @Override
    protected void onDestroy() {

        imageview_id.setImageBitmap(null);
        mFrameIv.setImageBitmap(null);
        mMovImage.setImageBitmap(null);


        iconImages_child = null;
        frameImages_child = null;
        maskImages_child = null;


        try {
            mGlobal.getImage().recycle();
            mGlobal.setImage(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.gc();
        super.onDestroy();
    }


    public void showColorPickerDialogDemo() {

        int initialColor = mGlobal.getColor();

        ColorPickerDialog colorPickerDialog = new ColorPickerDialog(this,
                initialColor, new ColorPickerDialog.OnColorSelectedListener() {

            @Override
            public void onColorSelected(int color) {
                mIbtn_color_text.setBackgroundColor(color);
                mGlobal.setColor(color);

            }

        });
        colorPickerDialog.show();

    }


    public class GalleryImageAdapter extends BaseAdapter {

        int imageBackground;
        private Activity context;
        private ImageView imageView;


        private ViewHolder holder;

        public GalleryImageAdapter(Activity context) {

            this.context = context;
            TypedArray ta = obtainStyledAttributes(R.styleable.Gallery1);
            imageBackground = ta.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 1);
            ta.recycle();

        }

        @Override
        public int getCount() {
            return iconImages_child.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {

                holder = new ViewHolder();

                imageView = new ImageView(this.context);

                imageView.setPadding(3, 3, 3, 3);

                convertView = imageView;

                holder.imageView = imageView;

                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            Picasso.with(context).load(iconImages_child[position]).into(holder.imageView);
            holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            holder.imageView.setLayoutParams(new Gallery.LayoutParams(200, 200));
            holder.imageView.setBackgroundResource(imageBackground);
            return imageView;
        }

        private class ViewHolder {
            ImageView imageView;
        }

    }

    public class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter(Context context, int textViewResourceId,
                         String[] objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.spinner_row, parent, false);

            TextView label = (TextView) row.findViewById(R.id.textView1);
            label.setText("PIP camera");

            Typeface face = Typeface.createFromAsset(getAssets(), style[position]);

            label.setTypeface(face);

            return row;
        }

    }

    class ViewHolder {
        ImageView imageView;
    }

}

