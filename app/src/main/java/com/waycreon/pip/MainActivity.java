package com.waycreon.pip;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity implements FragmentNavigation.OnFragmentInteractionListener {
    protected static final int REQUEST_CAMERA = 111;
    protected static final int SELECT_FILE = 222;
    public static Context context;
    Global mGlobal;
    File f;
    Bitmap m_bitmap1;
    Timer timer;
    int page = 1;
    //    AdView adView;
    private InterstitialAd interstitial;
    private DrawerLayout drawer;
    private TextView mTextView_Header;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TextView Premium;
    private LinearLayout PremiumLayout;
    private static int[] images = new int[]{R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};

    @Override
    protected void onResume() {
        super.onResume();
        if (!Global.isLimited) {
            try {
                PremiumLayout.setVisibility(View.GONE);
                FragmentNavigation.isPremium();
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        context = getApplicationContext();

        Typeface type = Typeface.createFromAsset(getAssets(), "iran_sans_regular.ttf");
        Typeface type_roboto = Typeface.createFromAsset(getAssets(), "roboto_light.ttf");

        PremiumLayout = (LinearLayout) findViewById(R.id.premium_layout);
        Premium = (TextView) findViewById(R.id.premium);
        TextView Premium1 = (TextView) findViewById(R.id.premium1);
        TextView Premium2 = (TextView) findViewById(R.id.premium2);
        Premium.setTypeface(type);
        Premium1.setTypeface(type);
        Premium2.setTypeface(type);

        Premium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityGoPremium.class);
                MainActivity.this.startActivity(intent);
            }
        });

        // Toolbar Buttons
        mTextView_Header = (TextView) findViewById(R.id.toolbar_main_tv_header);
//        mTextView_Header.setTypeface(typeFace_Medium);
        mTextView_Header.setText("P R O S H O T");
        mTextView_Header.setTypeface(type_roboto);
        ImageView btnNavigation = (ImageView) findViewById(R.id.btnNavigation);
        btnNavigation.setImageResource(R.mipmap.menu);
        btnNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.RIGHT);
            }
        });


        // Image Slider and its Indicator Implementation
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.vp_slider);
        mViewPager.setAdapter(mSectionsPagerAdapter);
//        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
//        indicator.setViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                if (state < images.length) {
//                    //intro_images is viewpager
//                }else {
//                    mViewPager.setCurrentItem(0, true);
//
//                }
            }
        });
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pageSwitcher(10);
            }
        }, 5000);

        // Navigation Drawer
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Fragment squadFragment = new FragmentNavigation();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_view, squadFragment, null);
        fragmentTransaction.commit();

        mGlobal = ((Global) getApplication());


//        adView = (AdView) this.findViewById(R.id.ads);

        AdRequest adRequest = new AdRequest.Builder()

                .build();


        // Load ads into Banner Ads
//        adView.loadAd(adRequest);

        // Load ads into Interstitial Ads

        // Prepare an Interstitial Ad Listener

        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(getResources().getString(R.string.admob_intersitials));
        interstitial.loadAd(adRequest);

        // Load ads into Interstitial Ads
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                interstitial.show();

            }
        });


//        try {
//            adView.loadAd(adRequest);
//        } catch (Exception e) {
//        }
        findViewById(R.id.camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                File f = new File(Environment
                        .getExternalStorageDirectory(), "temp.jpg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(f));
                startActivityForResult(intent, REQUEST_CAMERA);

            }
        });

        findViewById(R.id.galery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(
                        Intent.createChooser(intent, "Select File"),
                        SELECT_FILE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub

        // /==========================

        if (resultCode == RESULT_OK) {

            final Intent i = new Intent(MainActivity.this, SelectedImageActivity.class);


            if (requestCode == REQUEST_CAMERA) {
                f = new File(Environment.getExternalStorageDirectory()
                        .toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {

                    int rotate = 0;
                    ExifInterface exif;
                    try {
                        exif = new ExifInterface(
                                f.getAbsolutePath());
                        int orientation = exif.getAttributeInt(
                                ExifInterface.TAG_ORIENTATION,
                                ExifInterface.ORIENTATION_NORMAL);
                        switch (orientation) {
                            case ExifInterface.ORIENTATION_ROTATE_270:
                                rotate = 270;
                                break;
                            case ExifInterface.ORIENTATION_ROTATE_180:
                                rotate = 180;
                                break;
                            case ExifInterface.ORIENTATION_ROTATE_90:
                                rotate = 90;
                                break;
                        }
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                    final int finalRotate = rotate;

                    m_bitmap1 = BitmapFactory.decodeFile(f.getAbsolutePath());
                    int nh = (int) (m_bitmap1.getHeight() * (400.0 / m_bitmap1.getWidth()));
                    m_bitmap1 = Bitmap.createScaledBitmap(m_bitmap1, 400, nh, true);

                    Matrix matrix = new Matrix();
                    matrix.postRotate(finalRotate);

                    mGlobal.setImage(Bitmap.createBitmap(m_bitmap1, 0, 0, m_bitmap1.getWidth(), m_bitmap1.getHeight(), matrix, true));

                    startActivity(i);
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (requestCode == SELECT_FILE) {
                Uri selectedImageUri = data.getData();

                try {

                    f = FileUtils.getFile(this, (selectedImageUri));


                    Glide.with(this).load(f)
                            .asBitmap()
                            .into(new SimpleTarget<Bitmap>(400, 400) {
                                @Override
                                public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {

                                    mGlobal.setImage(bitmap);
                                    startActivity(i);
                                    finish();
                                }
                            });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    protected void onDestroy() {


        try {
            m_bitmap1.recycle();
            m_bitmap1 = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.gc();
        super.onDestroy();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
    }

    public static class PlaceholderFragment extends Fragment {

        //The fragment argument representing the section number for this fragment.

        private static final String ARG_SECTION_NUMBER = "section_number";
        private ImageView mImageViewBanner;

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber - 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_slider, container, false);
            mImageViewBanner = (ImageView) view.findViewById(R.id.fragment_slider_img_banner);
//            Glide.with(getContext())
//                    .load("http://sotapp.ir/pictures/view/" + picture)
//                    .override(300, 200)
//                    .placeholder(R.drawable.place_holder)
//                    .into(mImageViewBanner);

            mImageViewBanner.setImageResource(images[getArguments().getInt(ARG_SECTION_NUMBER)]);

            return view;
        }
    }

    // Image slider Adapter
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        //sets tab names
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // sets tab content (fragment)
        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);

        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page > 3) { // In my case the number of pages are 5
                        page = 0;
                        mViewPager.setCurrentItem(page++);
//                        timer.cancel();
                        // Showing a toast for just testing purpose
//                        Toast.makeText(getApplicationContext(), "Timer stoped", Toast.LENGTH_LONG).show();
                    } else {
                        mViewPager.setCurrentItem(page++);
                    }
                }
            });

        }
    }

}
